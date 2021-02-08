package id.calocallo.gunbatker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.calocallo.gunbatker.databinding.ActivityHomeBinding
import id.calocallo.gunbatker.model.PlayerModel
import id.calocallo.gunbatker.utils.Constants
import id.calocallo.gunbatker.utils.action
import id.calocallo.gunbatker.utils.showSnackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val player = intent.getParcelableExtra<PlayerModel>(Constants.PLAYER1)
//        Log.e("player", "$player")

        binding.textView3.showSnackbar("Selamat Datang ${player?.name}") {
            action("Tutup") { dismiss() }
        }

        binding.txtPlayerVsPlayer.text = "${player?.name} Vs Pemain"
        binding.txtPlyerVsCom.text = "${player?.name} Vs Computer"

        binding.imgPlayerVsPlayer.setOnClickListener {
            val intent = Intent(this, VersPlayerActivity::class.java).apply {
                this.putExtra(Constants.PLAYER1, player)
            }
            startActivity(intent)
        }
        binding.imgPlayerVsCom.setOnClickListener {
            val intent = Intent(this, VersComActivity::class.java).apply {
                this.putExtra(Constants.PLAYER1, player)
            }
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        val player = intent.getParcelableExtra<PlayerModel>(Constants.PLAYER1)
//        Log.e("player", "$player")

        binding.textView3.showSnackbar("Selamat Datang ${player?.name}") {
            action("Tutup") { dismiss() }
        }

        binding.txtPlayerVsPlayer.text = "${player?.name} Vs Pemain"
        binding.txtPlyerVsCom.text = "${player?.name} Vs Computer"
    }
}