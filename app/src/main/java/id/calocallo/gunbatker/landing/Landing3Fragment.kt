package id.calocallo.gunbatker.landing

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.calocallo.gunbatker.HomeActivity
import id.calocallo.gunbatker.R
import id.calocallo.gunbatker.databinding.FragmentLanding3Binding
import id.calocallo.gunbatker.model.PlayerModel
import id.calocallo.gunbatker.utils.Constants
import id.calocallo.gunbatker.utils.showSnackbar


class Landing3Fragment : Fragment() {
    private lateinit var binding: FragmentLanding3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLanding3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNextHome.setOnClickListener {
            val namePlayer = binding.edtNamePlayer.editText?.text.toString()
            if (namePlayer.isEmpty()) {
                Toast.makeText(activity, "Nama Player Tidak Boleh Kosong", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(activity, HomeActivity::class.java).apply {
                    val player = PlayerModel(namePlayer)
                    this.putExtra(Constants.PLAYER1, player)
                }
                startActivity(intent)
            }
        }
    }
}