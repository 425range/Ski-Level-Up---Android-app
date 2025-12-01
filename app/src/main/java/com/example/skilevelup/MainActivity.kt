package com.example.skilevelup

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.skilevelup.data.db.AppDatabase
import com.example.skilevelup.data.entity.SkillEntity
import com.example.skilevelup.data.entity.UserEntity
import com.example.skilevelup.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.skillListFragment,
                R.id.levelFragment,
                R.id.mapFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        lifecycleScope.launch {
            val db = AppDatabase.get(this@MainActivity)
            // Put data of skill list on DataBase
            val skills = listOf(
                SkillEntity(
                    name = "SnowPlow",
                    desc = "대한스키지도자연맹에서 정의하는 스노우플라우는 스키의 앞부분(tip)을\n" +
                            "'A'자 모양으로 만들어 양 스키에 압력을 분산시켜 속도를 줄이고, 안정성을 확보하며 회전을\n" +
                            "유도하는 가장 초급 기술입니다. 바깥발(계곡쪽)에 체중을 두고 다운모션으로 시작하여, 대각선방향(사활강)으로\n" +
                            "이동하며 몸의 수직운동(버티컬 무브먼트)이 함께 일어납니다. 폴라인(최대경사선)에 진입하면, 피보팅(발 앞쪽을 안쪽으로 돌림)\n" +
                            "동작과 함께 바깥쪽 스키에 더 많은 체중을 실어 턴을 만듭니다.\n",
                    practice = "스노우플라우는 감속이 주목적이며, 양쪽 스키의 탑 간격을 일정하게 유지하고 무게중심을\n" +
                            "정확히 이동시킬 때 평가점수가 높아집니다. 대한스키지도자연맹에서는 이 기술을 레벨1 자격증 기본기술로 활용하고 있습니다.",
                    difficulty = 0.5f,
                    score = 50

                ),
                SkillEntity(
                    name = "SnowPlowTurn",
                    desc = "대한스키지도자연맹(KSIA)에서 정의하는 스노우플라우턴(Snowplow Turn)은 스키의 가장 기본적인 턴 기술로,\n" +
                            "스키를 A자 형태로 벌려 눈을 넓게 쓸면서 속도를 조절하고 회전을 수행하는 방법입니다.\n" +
                            "플루크 보겐이라는 독일어로 된 용어를 대신해 사용되며, 눈을 쓸며(넉가래처럼) 회전하는 동작을 의미합니다.\n" +
                            "이때 체중은 바깥발에 실어주고, 다운모션과 버티컬 무브먼트(수직운동)를 사용해 폴라인(fall line, 최대 경사선)으로\n" +
                            "진입 후 피보팅(발 앞부분을 안쪽으로 돌리는 동작)으로 턴을 완성합니다.",
                    practice = "스노우플라우턴 연습 포인트\n" +
                            "출발은 바깥발(계곡 쪽)에 체중을 실은 다운모션으로 사활강(대각선 활주) 시작\n" +
                            "버티컬 무브먼트로 신체를 수직으로 움직여 회전 유도\n" +
                            "양발에 동일한 체중을 실은 상태로 폴라인 진입하고, 피보팅과 함께 바깥스키에 체중 집중\n" +
                            "스탠스는 너무 넓거나 좁지 않게 조절, 스키 탑 간격이 일정하도록 유지\n" +
                            "자세는 상체가 산 쪽으로 기울지 않도록 골반 중심을 안정시켜 균형 유지\n" +
                            "회전의 크기와 속도는 부드럽게 연결되도록 조절하며, 감속 효과를 중점으로 연습",
                    difficulty = 0.5f,
                    score = 50
                ),
                SkillEntity(
                    name="StemTurn",
                    desc="대한스키지도자연맹(KSIA)에서 정의하는 스템턴 원리\n" +
                            "초반: 사활강(스키를 평행하게, 옆으로 활주) 상태에서 출발\n" +
                            "턴 시작: 산쪽(업힐) 스키의 뒷부분을 바깥으로 벌리며 A자 형태\n" +
                            "중반: 두 스키를 별도의 각도로 유지하며 뉴트럴 포지션(양발에 체중이 나눠짐)으로 폴라인(최대 경사선) 진입\n" +
                            "턴 마무리: 바깥발(계곡 쪽)에 체중을 싣고, 안쪽 스키를 평행하게 붙이며 점차 11자(패러렐) 형태로 전환\n" +
                            "몸의 중심: 항상 골반 중심이 양 스키의 중간에 위치하도록\n" +
                            "상체 회전(로테이션): 되도록 피하고, 하체 위주로 턴 실시\n" +
                            "스템턴은 초보자도 비교적 쉽게 방향 전환을 배우고, 자연스럽게 감속/제동/회전을 익힐 수 있게 설계된 기술.",
                    practice="스템턴 연습 포인트\n" +
                            "알파인 베이직 포지션에서 출발 (무릎 살짝 굽히기, 시선 전방)\n" +
                            "버티컬 무브먼트(상하 움직임)와 함께 산쪽 스키의 뒷부분(A자)을 바깥으로 벌려 스노우플라우 스탠스 만들기\n" +
                            "두 스키에 체중을 골고루 실으며 폴라인 진입\n" +
                            "폴라인 직후 바깥발에 체중 집중하며, 안쪽 스키를 바깥스키에 붙여가며 패러렐(11자) 형태로 마무리\n" +
                            "턴 중 상체 혹은 골반이 경사 반대방향으로 쏠리지 않는지 계속 신경쓰며, 중심 유지\n" +
                            "양쪽 턴 크기(호 크기)가 비슷하고 연결이 자연스러워야 함\n" +
                            "과도한 상체 회전, 무릎·골반의 흔들림 감점 요소",
                    difficulty=1f,
                    score=100
                ),
                SkillEntity(
                    name="ParallelLongTurn",
                    desc="대한스키지도자연맹(KSIA)에서 말하는 패러렐 롱턴/베이직 롱턴은," +
                            "두 스키를 패러렐(11자)에 유지한 상태에서 롱턴(대회전 크기)의 호를 그리며, " +
                            "바깥발 중심의 하중과 상하운동을 활용해 속도를 조절·활용하는 기초 패러렐 기술을 의미한다.",
                    practice="패러렐 롱턴 연습 포인트\n" +
                    "패러렐 스탠스 유지: 턴 전 과정에서 스키는 11자에 가깝게 유지하며, 스템 동작 없이 패러렐 상태로 회전한다.\n" +
                            "롱턴(대회전) 크기: 턴 호가 길고 완만한 롱턴 계열로, 속도를 급하게 죽이기보다 진행 방향을 크게 바꾸면서 속도를 조절·활용한다.\n" +
                            "바깥발 중심 하중: 폴라인 전후 구간에서 버티컬 무브먼트(상하운동)를 통해 바깥발에 확실한 압력을 만들고, 그 압력으로 턴을 리드한다.\n" +
                            "버티컬 무브먼트 + 폴 플랜트: 상하운동과 폴 플랜트 타이밍을 맞추어 리듬을 만들고, 중심 이동을 자연스럽게 하여 매끄러운 롱턴 연결을 목표로 한다.\n" +
                            "전후·좌우 밸런스: 몸의 중심(COM)이 양 스키 사이, 특히 바깥발 위 근처에 안정적으로 위치하도록 하여, 스키가 폴라인 방향으로 자연스럽게 낙하·회전하게 만든다.",
                    difficulty=1.5f,
                    score=150
                ),
                SkillEntity(
                    name="ParallelShortTurn",
                    desc="패러렐 혹은 베이직 숏턴은 “패러렐 스탠스로 짧은 턴을 만드는 소회전 기술”로 설명되며, " +
                            "경사가 있는 중사면에서 속도 조절과 리듬 확보를 목표로 한다. " +
                            "KSIA 주니어·기술등급 체계에서 베이직 롱턴 다음 단계(보통 5단계 정도)에 배치되는 기초 숏턴 종목으로, " +
                            "이후 다이나믹/카빙 숏턴으로 연결되는 중간 단계 기술이다.",
                    practice="상체 고정·하체 주도: 어깨와 골반은 계곡 방향으로 비교적 고정하고, 무릎·발목을 중심으로 하체를 리듬 있게 움직여 스키를 회전시킨다.\n" +
                            "빠른 버티컬 무브먼트: 한 번의 상하운동 안에서 에지 체인지와 방향 전환이 이루어질 정도로 상하운동을 빠르고 과감하게 사용한다.\n" +
                            "에지, 폴, 리듬\n" +
                            "에지 사용: 턴 시작 때마다 양 스키 팁을 경사 아래로 떨어뜨려 앞 에지가 설면을 파고들게 하고, " +
                            "턴 마무리는 테일 에지로 깨끗하게 마무리해 반발력과 리듬을 만든다.\n" +
                            "폴 플랜트: 에지 체인지 순간에 맞춰 폴 플랜트를 사용하며, " +
                            "롱턴보다 턴 템포가 빠르기 때문에 폴이 조금 더 빨리 나가야 리듬이 맞는다.\n" +
                            "중심과 라인 개념\n" +
                            "중심 위치: 빠른 회전과 스키 컨트롤을 위해 신체 중심(COM)은 항상 스키의 중앙 부근에 두며, " +
                            "머리가 앞바인딩 위로 나가는 느낌으로 적극적으로 전방 중심을 만든다.\n" +
                            "투 폴라인 숏턴: KSIA 베이직 숏턴 설명에서는 진폭이 큰, 투 폴라인(short turn)을 지향해 " +
                            "바깥발에 생긴 압력과 반발력을 활용해 좌우로 크게, 리드미컬한 소회전을 만들어내는 것을 강조한다.",
                    difficulty=3f,
                    score=300
                ),
                SkillEntity(
                    name="DynamicLongTurn",
                    desc="개념과 특징\n" +
                            "턴 크기는 기본적으로 롱턴(대회전 크기)을 유지하지만, 베이직 롱턴보다 스키가 더 세게 눌리고 더 많이 휘어지는 상태를 만든다." +
                            "속도를 크게 줄이지 않고, 스키의 탄성·반발을 이용해 가속과 방향 전환을 동시에 노리는 “공격적인 롱턴”에 가깝다." +
                            "베이직 롱턴과의 차이\n" +
                            "미끄러짐(스키딩) 감소: 베이직 롱턴보다 스키딩을 줄이고, 더 카빙에 가까운 얇은 활주 자국(스퍼)을 만든다고 이해하면 좋다." +
                            "하중과 리바운드: 다운에서 폴라인까지 바깥발에 강하게 눌러놓고, " +
                            "턴 후반/에지 체인지 구간에서 그 반발을 받아 다음 턴으로 튀어나가는 느낌이 강조된다.",
                    practice="기술 포인트\n" +
                            "상체는 안정된 센터 포지션(중간 높이)을 유지하면서, 하체를 크게 쓰되 “많이 눌러서, 크게 휘게 하고, 반발로 연결”하는 흐름이 중요하다.\n" +
                            "에지 각과 스티어링 앵글을 적당히 줄여, 베이직보다 덜 미끄러지고 더 세게 서는 에지 상태를 만들면서도, " +
                            "완전 카빙처럼 미끄러짐이 0이 되지는 않는 포지션으로 생각하면 이해가 쉽다." +
                            "숏턴·카빙과의 관계\n" +
                            "베이직(많이 미끄러짐) → 다이나믹(조금 미끄러짐, 하중·반발 활용) " +
                            "→ 카빙(거의 안 미끄러짐)이라는 흐름에서 “중간 단계의 고속 기술”이 다이나믹 롱턴이다.\n" +
                            "다이나믹 숏턴은 같은 개념을 숏턴 크기로 가져온 형태이고, " +
                            "카빙 롱턴은 다이나믹보다 더 에지 의존적이며 스키딩을 최소화한 상태라고 보면 된다.",
                    difficulty=3.5f,
                    score=350
                ),
                SkillEntity(
                    name="DynamicShortTurn",
                    desc="다이나믹 숏턴은 작은 턴 크기에서 스키를 세게 휘고 빠르게 회전시키며, " +
                            "베이직 단계의 미끄러짐을 줄인 형태로 레벨2 검정 종목에 포함된다." +
                            "속도 저항을 최소화하면서도 턴 전환을 재빠르게 연결하는 것이 핵심이며, " +
                            "스키가 세워진 상태를 유지해 다음 턴 도입에 유리하다.",
                    practice="기술 포인트\n" +
                            "스티어링 앵글 작게: 스키 회전 속도를 높여 작은 턴을 만들되, 인위적 조작보다는 스키의 사이드커브를 활용한다." +
                            "하중과 리듬: 한 턴 동안 꾸준히 미끄러트리지 않고, 좁은 스퍼(활주 자국)를 그리며 상체 안정과 하체 적극 움직임을 병행한다." +
                            "턴 흐름: 롱턴 이미지를 축소한 형태로, 에지 체인지와 폴 플랜트를 빠르게 맞춰 리드미컬한 소회전을 연속한다." +
                            "KSIA 교본 영상과 레벨2 시연에서 강조되는 바에 따르면, 다이나믹 숏턴은 베이직→다이나믹→카빙 흐름의 중간 고급 기술로, " +
                            "고속 컨트롤을 위한 스키딩 최소화가 관건이다.",
                    difficulty=3.5f,
                    score=350
                ),
                SkillEntity(
                    name="CarvingLongTurn",
                    desc="카빙 롱턴은 다이나믹 롱턴보다 스키딩을 거의 없애고, 에지 각도와 사이드컷을 이용해 " +
                            "얇은 활주 자국을 그리며 고속에서 안정적으로 큰 호를 완성한다." +
                            "레벨3(브론즈) 또는 기술등급 8단계 종목으로, 중사면에서 원심력과 리바운드를 활용한 부드러운 연결이 핵심이다.",
                    practice="에지 세팅: 턴 시작 시 발목·고관절로 빠르게 에지 세팅하며, 과도한 깊은 에지각 피하고 상체 수평 유지로 스피드 저하 방지." +
                            "중심 이동: 안쪽으로 중심 이동해 원심력 활용, 턴 후반 리바운드로 바깥 스키 압력 유지하며 다음 턴 추진력 생성." +
                            "폴 플랜트: 상황에 따라 생략 가능하며, 상체 모션으로 자체 유지와 부드러운 연결 강조." +
                            "KSIA 교본 영상에서 강조하듯, 카빙 롱턴은 에지·사이드컷 중심의 안정적 고속 기술로 다이나믹 단계 이후 카빙성 롱턴으로 이어진다.",
                    difficulty=4f,
                    score=400
                ),
                SkillEntity(
                    name="CarvingShortTurn",
                    desc="카빙 숏턴은 활주 시간이 짧은 숏턴의 리듬과 카빙의 순수 에지 활주를 결합하며, " +
                            "레벨3 이상 또는 기술선수권에서 상급 종목으로 등장한다." +
                            "상하 움직임을 최소화하고 좌우 중심 이동으로 원심력을 제어하며, " +
                            "스키 팁-테일이 일직선에 가까운 얇은 트랙을 그리는 것이 핵심이다.",
                    practice="에지 활용: 턴 시작에 빠른 에지 세팅으로 스키를 세우고, 다리 비틀림·앵글레이션으로 압력을 전달하며 스키딩 없이 회전한다." +
                            "상체·하체 분리: 상체는 정대 유지하며 하체를 좌우로 재빠르게 움직여 리듬을 만들고, 폴 체킹으로 턴 전환을 돕는다." +
                            "하중 타이밍: 업-다운 리듬에서 턴 마무리에 압축 후 빠른 풀림으로 다음 턴 추진력을 생성한다." +
                            "KSIA 교본(11강)에서 카빙 숏턴은 패러렐→다이나믹→카빙 흐름의 최종 단계로, 고속 컨트롤과 순수 카빙 감각을 강조한다.",
                    difficulty=4.5f,
                    score=450
                ),
                SkillEntity(
                    name="CombinedDownhill",
                    desc="종합활강은 단일 턴 크기가 아닌 롱턴(큰 호)·숏턴(작은 호)·미들턴을 코스에 따라 번갈아 사용하며, " +
                            "턴 후반 반발력을 활용해 리듬 있게 전환하는 다재다능한 활주를 요구한다." +
                            "레벨3 또는 기술선수권 예선에서 롱턴·숏턴과 함께 점수화되며, 전체적인 균형과 속도 컨트롤을 평가한다.",
                    practice="턴 전환: 각 턴 진입 시 바깥발 하중과 에지 세팅으로 시작해 후반 리바운드로 다음 턴(크기 변화 무관) 연결." +
                            "리듬 유지: 상체 안정과 하체 적극 움직임으로 불규칙 코스에서도 속도 저하 없이 흐름 유지."+
                            "코스 적응: 게이트나 마커 없이 자유 활주하되, 경사 변화에 맞춰 턴 크기 조절.",
                    difficulty=4f,
                    score=400
                ),
                SkillEntity(
                    name="SlalomRacing",
                    desc="Slalom gate racing은 알파인 스키 레이싱의 기술 종목으로, " +
                            "빨강·파랑 폴로 된 게이트 사이를 빠르고 짧은 턴으로 통과하며 가장 빠른 시간을 내는 경쟁이다." +
                            "규칙과 코스\n" +
                            "경쟁자는 남자 180-220m, 여자 140-180m 수직 낙차 코스를 내려가며, " +
                            "55-75개(남자) 또는 40-60개(여자) 게이트를 통과해야 한다. " +
                            "게이트는 빨강·파랑 폴 쌍으로 구성되며 최소 4m, 최대 6m 폭으로, 스키 팁과 발이 폴 사이를 지나야 유효하다.",
                    practice="짧고 빠른 턴을 요구하므로 크로스-블로킹(상체를 게이트 쪽으로 기울여 폴을 팔·다리로 밀치며 통과) 기술이 핵심이며," +
                            " 게이트 간격이 좁아(6-12m) 민첩성과 에지 컨트롤이 필수다." +
                            "2런으로 진행되며 1런 후 상위 30명이 역순으로 2런, " +
                            "총 시간으로 승패 결정; 게이트 미스나 스트래들(게이트가 다리 사이 통과)은 실격이다.",
                    difficulty=5f,
                    score=500
                ),
                SkillEntity(
                    name="GiantSlalomRacing",
                    desc="자이언트 슬라롬(Giant Slalom, GS) 게이트 레이싱은 알파인 스키 레이싱의 기술 종목으로, " +
                            "슬라롬보다 넓고 긴 게이트를 통과하며 속도와 큰 턴 기술을 결합해 가장 빠른 시간을 경쟁한다." +
                            "규칙과 코스\n" +
                            "코스 수직 낙차는 남자 300-450m, 여자 300-400m로, " +
                            "게이트는 4-8m 폭의 빨강·파랑 폴 쌍(남자 50-55개, 여자 45-50개)으로 설치되며 " +
                            "게이트 간격은 20-30m 정도로 슬라롬(6-12m)보다 길다. 2런으로 진행되며 1런 상위 30명(역순 출발)이 " +
                            "2런에 진출하고 총 시간으로 순위 결정; 게이트 미스나 폴 넘어뜨림은 실격이다.",
                    practice="카빙 롱턴 스타일의 큰 호 턴으로 고속 유지하며, 에지 세팅과 원심력 활용이 핵심이며 " +
                            "슬라롬만큼 재빠른 턴 전환이 아닌 안정적 속도 컨트롤을 요구한다.",
                    difficulty=4.5f,
                    score=450
                )
            )
            db.skillDao().insertAll(skills) // insert skills to DB

            // Show score
            if (db.userDao().getScore() == null) {
                db.userDao().saveUser(UserEntity(totalScore = 0))
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return super.onSupportNavigateUp() || navController.navigateUp()
    }
}