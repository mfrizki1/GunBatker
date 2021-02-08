package id.calocallo.gunbatker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import id.calocallo.gunbatker.databinding.ActivityVersPlayerBinding
import id.calocallo.gunbatker.model.PlayerModel
import id.calocallo.gunbatker.utils.Constants
import id.calocallo.gunbatker.utils.alert
import id.calocallo.gunbatker.utils.setFromUrl

class VersPlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVersPlayerBinding
    private var option1: String = ""
    private var option2: String = ""
    private var state1: Boolean = false
    private var state2: Boolean = false
    private lateinit var selected1: View
    private lateinit var selected2: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVersPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val player = intent.getParcelableExtra<PlayerModel>(Constants.PLAYER1)
        binding.txtPlayer1Vers.text = player?.name

        binding.imgTitleVersPlayer.setFromUrl("https://i.ibb.co/HC5ZPgD/splash-screen1.png")

        binding.imgBackHome.setOnClickListener {
            finish()
        }
        binding.imgRefresh.setOnClickListener {
            if (option1 != "" && option2 != "") {
                refresh()
            }
        }

        player1Game()
        player2Game()


    }

    private fun player1Game() {
        binding.imgBatuPlayer1Vers.setOnClickListener {
            p1Select(it)
            if (option2.isNotEmpty()) {
                checkResult()
            }
        }
        binding.imgGuntingPlayer1Vers.setOnClickListener {
            p1Select(it)
            if (option2.isNotEmpty()) {
                checkResult()

            }
        }
        binding.imgKertasPlayer1Vers.setOnClickListener {
            p1Select(it)
            if (option2.isNotEmpty()) {
                checkResult()

            }
        }
    }


    private fun player2Game() {
        binding.imgBatuPlayer2Vers.setOnClickListener {
            p2Select(it)
            if (option1.isNotEmpty()) {
                checkResult()

            }
        }
        binding.imgGuntingPlayer2Vers.setOnClickListener {
            p2Select(it)
            if (option1.isNotEmpty()) {
                checkResult()

            }
        }
        binding.imgKertasPlayer2Vers.setOnClickListener {
            p2Select(it)
            if (option1.isNotEmpty()) {
                checkResult()

            }
        }
    }

    private fun checkResult() {
//        Log.e("option1","$option1")
//        Log.e("option2","$option2")
        if (option1 == option2) {
//            Log.e("seri", "seri")
            showResultDialog("Seri")

        }

        when (option1) {
            "batu" -> {
                when (option2) {
                    "gunting" ->  showResultDialog("Pemain 1 Menang")
                    "kertas" -> showResultDialog("Pemain 2 Menang")
                }
            }
            "gunting" -> {
                when (option2) {
                    "kertas" ->showResultDialog("Pemain 1 Menang")
                    "batu" -> showResultDialog("Pemain 2 Menang")
                }
            }
            "kertas" -> {
                when (option2) {
                    "batu" -> showResultDialog("Pemain 1 Menang")
                    "gunting" -> showResultDialog("Pemain 2 Menang")
                }
            }
        }
    }

    private fun showResultDialog(result: String) {
        this.alert(result) {
            positiveButton {
                refresh()
            }
            negativeButton{
                finish()
            }
        }.show()
    }

    private fun p1Select(view: View) {
        if (!state1) {
            selected1 = view
            refreshPlayer1()
            state1 = true
            option1 = selected1.contentDescription.toString()
            view.background =
                ResourcesCompat.getDrawable(this.resources, R.drawable.bg_selected, null)
        } else {
            refreshPlayer1()
        }
    }

    private fun p2Select(view: View) {
        if (!state2) {
            selected2 = view
            refreshPlayer2()
            state2 = true
            option2 = selected2.contentDescription.toString()
            view.background =
                ResourcesCompat.getDrawable(this.resources, R.drawable.bg_selected, null)
        } else {
            refreshPlayer2()
        }
    }

    private fun refreshPlayer1() {
        option1 = ""
        state1 = false
        selected1.background = ResourcesCompat.getDrawable(this.resources, R.color.white, null)
    }

    private fun refreshPlayer2() {
        option2 = ""
        state2 = false
        selected2.background = ResourcesCompat.getDrawable(this.resources, R.color.white, null)
    }

    private fun refresh() {
        option1 = ""
        option2 = ""
        state1 = false
        state2 = false
        selected1.background = ResourcesCompat.getDrawable(this.resources, R.color.white, null)
        selected2.background = ResourcesCompat.getDrawable(this.resources, R.color.white, null)
    }
}