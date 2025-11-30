package com.example.skilevelup.ui.skill_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.skilevelup.databinding.FragmentSkillDetailBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.skilevelup.data.db.AppDatabase
import com.example.skilevelup.util.ScoreManager
import com.google.android.material.color.utilities.Score
import kotlinx.coroutines.launch


class SkillDetailFragment : Fragment() {
    private var _binding : FragmentSkillDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var scoreManager: ScoreManager
    private var skillName: String = "" // Default value

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View {
        _binding = FragmentSkillDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstance: Bundle?){
        super.onViewCreated(view, savedInstance)

        scoreManager = ScoreManager(requireContext())

        val skillName = arguments?.getString("skillName") ?: return

        val db = AppDatabase.get(requireContext())

        lifecycleScope.launch {

            // DB에서 스킬 데이터 가져오기
            val skill = db.skillDao().getSkill(skillName)

            if(skill == null){
                Toast.makeText(requireContext(), "기술 데이터 없음: $skillName", Toast.LENGTH_LONG).show()
                return@launch
            }

            // UI 바인딩
            binding.tvName.text = skill.name
            binding.tvDesc.text = skill.desc
            binding.tvPrac.text = skill.practice
            binding.ratingBarDifficulty.rating = skill.difficulty
        }

        // 연습 완료 버튼 처리
        binding.btnDone.setOnClickListener {

            lifecycleScope.launch {

                val skill = db.skillDao().getSkill(skillName)
                if (skill == null) {
                    Toast.makeText(requireContext(),"점수 처리 실패: 데이터 없음", Toast.LENGTH_SHORT).show()
                    return@launch
                }

                val done = db.practiceDao().isDone(skillName) ?: false
                val total = db.userDao().getScore() ?: 0

                if (!done) {
                    db.userDao().saveUser(
                        com.example.skilevelup.data.entity.UserEntity(
                            uid = 0,
                            totalScore = total + skill.score
                        )
                    )
                }

                db.practiceDao().setDone(
                    com.example.skilevelup.data.entity.PracticeEntity(
                        skillName = skillName,
                        done = true
                    )
                )

                Toast.makeText(
                    requireContext(),
                    "연습 완료! +${skill.score}점",
                    Toast.LENGTH_SHORT
                ).show()

                binding.btnDone.isEnabled = false
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}