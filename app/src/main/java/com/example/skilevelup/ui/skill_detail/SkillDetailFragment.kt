package com.example.skilevelup.ui.skill_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.skilevelup.databinding.FragmentSkillDetailBinding
import androidx.fragment.app.Fragment
import com.example.skilevelup.util.ScoreManager
import com.google.android.material.color.utilities.Score


class SkillDetailFragment : Fragment() {
    private var _binding : FragmentSkillDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var scoreManager: ScoreManager
    private var skillName: String = "SnowPlow" // Default value

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

        val skillName = arguments?.getString("skillName") ?: "SnowPlow"

        when(skillName) {
            "SnowPlow" -> {
                binding.tvName.text = "SnowPlow"
                binding.tvDesc.text = "대한스키지도자연맹에서 정의하는 스노우플라우는 스키의 앞부분(tip)을\n" +
                        "'A'자 모양으로 만들어 양 스키에 압력을 분산시켜 속도를 줄이고, 안정성을 확보하며 회전을\n" +
                        "유도하는 가장 초급 기술입니다. 바깥발(계곡쪽)에 체중을 두고 다운모션으로 시작하여, 대각선방향(사활강)으로\n" +
                        "이동하며 몸의 수직운동(버티컬 무브먼트)이 함께 일어납니다. 폴라인(최대경사선)에 진입하면, 피보팅(발 앞쪽을 안쪽으로 돌림)\n" +
                        "동작과 함께 바깥쪽 스키에 더 많은 체중을 실어 턴을 만듭니다."
                binding.tvPrac.text = "스노우플라우는 감속이 주목적이며, 양쪽 스키의 탑 간격을 일정하게 유지하고 무게중심을\n" +
                        "정확히 이동시킬 때 평가점수가 높아집니다. 대한스키지도자연맹에서는 이 기술을 레벨1 자격증 기본기술로 활용하고 있습니다."
                binding.ratingBarDifficulty.rating = 0.5f
            }
            "SnowPlowTurn" -> {
                binding.tvName.text = "SnowPlow Turn"
                binding.tvDesc.text = "대한스키지도자연맹(KSIA)에서 정의하는 스노우플라우턴(Snowplow Turn)은 스키의 가장 기본적인 턴 기술로, " +
                        "스키를 A자 형태로 벌려 눈을 넓게 쓸면서 속도를 조절하고 회전을 수행하는 방법입니다. " +
                        "플루크 보겐이라는 독일어로 된 용어를 대신해 사용되며, 눈을 쓸며(넉가래처럼) 회전하는 동작을 의미합니다. " +
                        "이때 체중은 바깥발에 실어주고, 다운모션과 버티컬 무브먼트(수직운동)를 사용해 폴라인(fall line, 최대 경사선)으로" +
                        " 진입 후 피보팅(발 앞부분을 안쪽으로 돌리는 동작)으로 턴을 완성합니다."
                binding.tvPrac.text = "스노우플라우턴 연습 포인트\n" +
                        "출발은 바깥발(계곡 쪽)에 체중을 실은 다운모션으로 사활강(대각선 활주) 시작\n" +
                        "버티컬 무브먼트로 신체를 수직으로 움직여 회전 유도\n" +
                        "양발에 동일한 체중을 실은 상태로 폴라인 진입하고, 피보팅과 함께 바깥스키에 체중 집중\n" +
                        "스탠스는 너무 넓거나 좁지 않게 조절, 스키 탑 간격이 일정하도록 유지\n" +
                        "자세는 상체가 산 쪽으로 기울지 않도록 골반 중심을 안정시켜 균형 유지\n" +
                        "회전의 크기와 속도는 부드럽게 연결되도록 조절하며, 감속 효과를 중점으로 연습"
                binding.ratingBarDifficulty.rating = 0.5f
            }
            "StemTurn" -> {
                binding.tvName.text = "Stem Turn"
                binding.tvDesc.text = "대한스키지도자연맹(KSIA)에서 정의하는 스템턴 원리\n" +
                        "초반: 사활강(스키를 평행하게, 옆으로 활주) 상태에서 출발\n" +
                        "턴 시작: 산쪽(업힐) 스키의 뒷부분을 바깥으로 벌리며 A자 형태\n" +
                        "중반: 두 스키를 별도의 각도로 유지하며 뉴트럴 포지션(양발에 체중이 나눠짐)으로 폴라인(최대 경사선) 진입\n" +
                        "턴 마무리: 바깥발(계곡 쪽)에 체중을 싣고, 안쪽 스키를 평행하게 붙이며 점차 11자(패러렐) 형태로 전환\n" +
                        "몸의 중심: 항상 골반 중심이 양 스키의 중간에 위치하도록\n" +
                        "상체 회전(로테이션): 되도록 피하고, 하체 위주로 턴 실시\n" +
                        "스템턴은 초보자도 비교적 쉽게 방향 전환을 배우고, 자연스럽게 감속/제동/회전을 익힐 수 있게 설계된 기술."
                binding.tvPrac.text = "스노우플라우턴 연습 포인트\n" +
                        "알파인 베이직 포지션에서 출발 (무릎 살짝 굽히기, 시선 전방)\n" +
                        "버티컬 무브먼트(상하 움직임)와 함께 산쪽 스키의 뒷부분(A자)을 바깥으로 벌려 스노우플라우 스탠스 만들기\n" +
                        "두 스키에 체중을 골고루 실으며 폴라인 진입\n" +
                        "폴라인 직후 바깥발에 체중 집중하며, 안쪽 스키를 바깥스키에 붙여가며 패러렐(11자) 형태로 마무리\n" +
                        "턴 중 상체 혹은 골반이 경사 반대방향으로 쏠리지 않는지 계속 신경쓰며, 중심 유지\n" +
                        "양쪽 턴 크기(호 크기)가 비슷하고 연결이 자연스러워야 함\n" +
                        "과도한 상체 회전, 무릎·골반의 흔들림 감점 요소"
                binding.ratingBarDifficulty.rating = 1.0f
            }
        }
        binding.btnDone.setOnClickListener {
            val gained = getScoreForSkill(skillName)
            scoreManager.addScore(gained)

            Toast.makeText(
                requireContext(),
                "연습 완료! +$gained 점이 추가되었습니다.",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.btnDone.isEnabled = false
    }
    private fun getScoreForSkill(name : String) : Int {
        return when (name) {
            "SnowPlow" -> 100
            "SnowPlowTurn" -> 150
            "StemTurn"      -> 200
            "ParallelTurn"  -> 250
            "CarvingLong"   -> 300
            "CarvingShort"  -> 350
            else -> 10
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}