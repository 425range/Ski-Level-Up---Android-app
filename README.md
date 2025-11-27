# Ski‑Level‑Up — Android 앱 (스키 학습 & 정보 제공 앱)  Ski‑Level‑Up: An Android application for skiers_

## 프로젝트 개요

**Ski‑Level‑Up** 은 스키어들을 위해 설계된 Android 애플리케이션으로,  
스키 기술 정보 제공과 학습 지원, 스키장 정보 표시 기능 등을 통해  
스키를 배우는 사람들이 편하게 학습하고 정보를 얻을 수 있도록 돕는 것을 목표로 합니다.

- **주요 목적**  
  - 스키 기술 정보를 제공하고, 사용자가 자신의 스키 실력 향상 과정을 기록할 수 있도록 지원  
  - 국내 주요 스키장 위치를 표시하고, 스키어들이 원하는 장소를 쉽게 찾도록 도와줌  
  - 사용자 경험(UX)을 고려한 모바일 UI 제공  

---

## 주요 기능

<img width="280" height="510" alt="image" src="https://github.com/user-attachments/assets/60baa047-41cd-4f64-892b-f712e033b85e" /> <img width="280" height="510" alt="image" src="https://github.com/user-attachments/assets/262ed814-132b-43f5-ac49-fe215e55d22a" /> <img width="280" height="510" alt="image" src="https://github.com/user-attachments/assets/1f945d45-cc32-4ac8-8b7d-3a3ad3ee0d62" />  

- 스키 기술 정보 데이터베이스 기반 제공

- 스키 학습 정보 열람 및 레벨업 기능 구현  
- SQLite 데이터베이스를 이용한 정보 저장 및 로딩  
- Kotlin + Android Studio 기반 개발  
- 스키장 위치 표시 기능 추가 (지도나 위치 표시 기능 연동)  
- 사용자 피드백을 반영한 기능 개선  

---

## 기술 스택 & 개발 환경

- **언어**: Kotlin  
- **개발 환경**: Android Studio / Gradle  
- **DB**: SQLite  
- **레이아웃**: XML 액티비티 기반 UI 구성  
- **빌드 시스템**: Gradle (build.gradle.kts 포함)  

---

### 사용 방법
1. 이 저장소를 클론합니다.  
git clone https://github.com/425range/Ski-Level-Up---Android-app.git

2. Android Studio 로 프로젝트를 엽니다.  
3. File → Open → 저장소 루트 선택  
Gradle Sync 가 자동으로 진행됩니다.  

4. 에뮬레이터 또는 실제 안드로이드 기기에서 apk를 설치하여 앱을 실행합니다.

5. 메인 액티비티에서 스키 정보 열람 및 기능을 테스트할 수 있습니다.

6. 필요 라이브러리나 권한이 있다면 AndroidManifest.xml 또는 Gradle 설정에서 확인 후 적용합니다.

### 사용 시나리오
스키를 처음 배우는 초보자 → 스키 기술 정보 학습 및 레벨업 트래킹  

스키장 정보 검색 → 국내 스키장 위치 및 정보 확인  

반복 학습 및 연습 → 연습을 하며 레벨을 올리는 재미로 스키에 흥미를 붙임    

### 향후 개선 및 기능 추가 아이디어
스키 기술별 영상 튜토리얼 제공 (영상 + 텍스트 병합)

사용자 계정 및 클라우드 연동 → 학습 정보 백업 및 동기화

지도 API 연동 → 스키장 위치, 거리, 지도 네비게이션 기능 제공

Push 알림 기능 → 시즌/이벤트, 콘텐츠 업데이트 알림 제공

다국어 지원 → 영어/한국어 UI 병합


