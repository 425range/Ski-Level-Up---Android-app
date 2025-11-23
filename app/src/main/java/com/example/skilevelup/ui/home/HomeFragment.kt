package com.example.skilevelup.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.skilevelup.R
import com.example.skilevelup.databinding.FragmentHomeBinding
import com.example.skilevelup.util.ScoreManager
import com.google.android.material.color.utilities.Score


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var scoreManager: ScoreManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view : View, savedState: Bundle?) {
        super.onViewCreated(view, savedState)

        scoreManager = ScoreManager(requireContext())
    }

    override fun onResume() {
        super.onResume()

        val currentScore = scoreManager.getTotalScore()
        updateLevelUI(currentScore)
    }

    private fun updateLevelUI(score: Int) {
        binding.tvScore.text = "점수: $score"

        val (levelName, imageRes) = when{
            score < 200 -> "Bronze" to R.drawable.bronze
            score < 300 -> "Silver" to R.drawable.silver
            score < 400 -> "Gold" to R.drawable.gold
            score < 500 -> "Platinum" to R.drawable.platinum
            score < 600 -> "Diamond" to R.drawable.diamond
            score < 700 -> "Master" to R.drawable.master
            score < 800 -> "Grand Master" to R.drawable.grandmaster
            score > 800 -> "Professional" to R.drawable.professional
            else -> "None" to R.drawable.bronze
        }
        binding.tvLevel.text = "Level : $levelName"
        binding.ivLevel.setImageResource(imageRes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}