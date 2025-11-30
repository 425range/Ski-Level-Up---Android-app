package com.example.skilevelup.ui.level

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.skilevelup.data.db.AppDatabase
import com.example.skilevelup.databinding.FragmentLevelBinding
import kotlinx.coroutines.launch

class LevelFragment : Fragment() {

    private var _binding: FragmentLevelBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLevelBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReset.setOnClickListener {
            resetScore()
        }
    }
    private fun resetScore() {
        lifecycleScope.launch {
            val db = AppDatabase.get(requireContext())

            // 점수만 초기화
            db.userDao().resetScore()
            // 연습 상태 초기화
            db.practiceDao().resetAllPractice()

            Toast.makeText(requireContext(), "점수가 초기화되었습니다", Toast.LENGTH_SHORT).show()
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}