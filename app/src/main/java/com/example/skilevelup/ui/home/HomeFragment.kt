package com.example.skilevelup.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.skilevelup.R
import com.example.skilevelup.data.db.AppDatabase
import com.example.skilevelup.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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

    }

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch {
            val db = AppDatabase.get(requireContext())
            val score = db.userDao().getScore() ?: 0
            updateLevelUI(score)
        }

    }

    private fun updateLevelUI(score: Int) {
        binding.tvScore.text = "점수: $score"

        val (levelName, imageRes, start, end) = when {
            score < 200 -> Quad("Bronze", R.drawable.bronze, 0, 200)
            score < 300 -> Quad("Silver", R.drawable.silver, 200, 300)
            score < 400 -> Quad("Gold", R.drawable.gold, 300, 400)
            score < 500 -> Quad("Platinum", R.drawable.platinum, 400, 500)
            score < 600 -> Quad("Diamond", R.drawable.diamond, 500, 600)
            score < 700 -> Quad("Master", R.drawable.master, 600, 700)
            score < 800 -> Quad("Grand Master", R.drawable.grandmaster, 700, 800)
            else -> Quad("Professional", R.drawable.professional, 800, 800)
        }

        binding.tvLevel.text = "Level : $levelName"
        binding.ivLevel.setImageResource(imageRes)

        if (end > start) {
            val percent = ((score - start) * 100) / (end - start)
            binding.progressLevel.progress = percent
            val remain = end - score
            binding.tvNext.text = "다음 레벨까지 ${remain}점"
        } else {
            binding.progressLevel.progress = 100
            binding.tvNext.text = "최고 레벨입니다!"
        }
    }
    data class Quad<T1, T2, T3, T4>(
        val first: T1,
        val second: T2,
        val third: T3,
        val fourth: T4
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}