### 페어 매칭 기능
페어 매칭 조건
- 미션을 함께 수행할 페어를 두명씩 매칭한다.
- 페어 매칭 대상이 홀수인 경우 한 페어는 3인으로 구성한다.
- 같은 레벨에서 이미 페어를 맺은 크루와는 다시 페어로 매칭될 수 없다.

페어 매칭 구현 방법
- 크루들의 이름 목록을 List<String> 형태로 준비한다.
- 크루 목록의 순서를 랜덤으로 섞는다. 이 때 `camp.nextstep.edu.missionutils.Randoms`의 shuffle 메서드를 활용해야 한다.
- 랜덤으로 섞인 페어 목록에서 페어 매칭을 할 때 앞에서부터 순서대로 두명씩 페어를 맺는다.
- 홀수인 경우 마지막 남은 크루는 마지막 페어에 포함시킨다.
- 같은 레벨에서 이미 페어로 만난적이 있는 크루끼리 다시 페어로 매칭 된다면 크루 목록의 순서를 다시 랜덤으로 섞어서 매칭을 시도한다.
- 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러 메시지를 출력한다.

페어 재매칭 시도
- 안내 문구를 출력 후 매칭을 진행한다.
- 아니오를 선택할 경우 코스, 레벨, 미션을 다시 선택한다.

### 페어 조회 기능
- 과정, 레벨, 미션을 선택하면 해당 미션의 페어 정보를 출력한다.
- 매칭 이력이 없으면 매칭 이력이 없다고 안내한다. ([ERROR] 매칭 이력이 없습니다.)

---
과정, 레벨, 미션정보



---

- [ ] 기능 선택
  - [x] 기능 종류 출력 - OutputView#printOption
  - [x] 기능 중 하나의 입력 받기 - InputView#readOption
    - [ ] 예외처리 - InputValidator#validateOptionCommand
  
- [ ] 페어 매칭 선택 - PairMatcher
  - [x] 과정과 미션 출력 - OutputView#printCourseAndMission
  - [x] 매칭하고자 하는 과정, 레벨, 미션 입력 받기 - InputView#readCourseAndMission
    - [ ] 예외처리 - InputValidator#validateCourseAndMissionCommand
  - [ ] 페어 매칭 기록이 있는지 확인 - PairMatcher#hasMatchRecord
    - [ ] 매칭 정보가 있을 경우
      - [x] 매칭 재시도 안내 문구 출력 - OutputView#printRematch
      - [x] 매칭 재시도 의사 입력받기 - InputView#readRematch
        - [ ] 예외처리 - InputValidator#validateRematchCommand
        - [ ] 매칭 재시도 yes : 매칭 수행 - PairMatcher#match
        - [ ] 매칭 재시도 no : 매칭하고자 하는 과정, 레벨, 미션 입력 받기 - InputView#readCourseAndMission
  - [ ] 매칭 수행 - PairMatcher#match
    - [ ] 파일 입출력을 통해 필요한 크루들의 이름을 불러오기 (List<String> 형태로)
    - [ ] 페어 제작 - PairGenerator
      - [ ] 크루 목록의 순서를 랜덤으로 섞는다 (shuffle 사용)
      - [ ] 랜덤으로 섞인 페어 목록에서 앞에서부터 두명씩 페어를 맺는다
      - [ ] 홀수인 경우 마지막 남은 크루는 마지막 페어에 포함시킨다
    - [ ] 페어 검증 - PairValidator
      - [ ] 같은 레벨에서 이미 페어로 만난적이 있는 크루끼리 다시 페어로 매칭 되었는지 확인 - PairValidator#check
        - [ ] 같은 레벨의 모든 페어매칭 기록 조회 - PairRecordRepository#findByLevel
        - [ ] 새로 제작한 페어 목록과 기존의 페어목록 순회 하며 중복 확인
    - [ ] 페어 검증 성공 -> 결과 출력 (출력되는 순서는 shuffle 메서드 결과 순서) - OutputView#printMatchResult
    - [ ] 페어 검증 실패 -> 크루 목록 다시 섞어서 매칭 시도
      - [ ] 3회 시도까지 매칭이 되지 않으면 에러 메시지 출력 - OutputView#printError ([ERROR] 매칭에 실패하였습니다.)
    - [ ] 매칭 할 수 있는 경우의 수가 없으면 에러 메시지 출력 - OutputView#printError ([ERROR] 매칭 할 수 있는 경우의 수가 없습니다.)
  - [x] 매칭 결과 출력 - OutputView#printMissionPair

- [ ] 페어 조회 선택 - PairFinder
    - [x] 과정과 미션 출력 - OutputView#printCourseAndMission
    - [ ] 조회하고자 하는 과정, 레벨, 미션 입력 받기 - InputView#readCourseAndMission
    - [ ] 페어 매칭 기록이 있는지 확인 - PairRecordRepository#findByMission
      - [ ] 있을 경우 : 해당 미션의 페어 출력 - OutputView#printMissionPair
      - [ ] 없을 경우 : 매칭 이력이 없다고 안내 - OutputView#printError ([ERROR] 매칭 이력이 없습니다.)
  
- [ ] 페어 초기화 선택 - PairInitializer
    - [ ] 모든 미션의 페어 초기화 - PairRecordRepository#deleteAll
    - [x] 초기화 완료 문구 출력 - OutputView#printResetComplete
  
- [ ] 종료 선택

에러처리
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
- [ERROR]로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.
