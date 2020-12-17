# 지하철 노선도 미션 연습
> 시작 : 2020-12-17 13:07  
> 종료 :   
> 소요시간 : 시간 분

<br>

## 🎯 기능 구현 목록
- 프로그램 실행 및 Main 메뉴 출력
- 역(Station) 메뉴 출력
- 노선(Line) 메뉴 출력
- 구간(Section) 메뉴 출력
- 역(Station) 등록
    - Station 만든 후 StationRepository에 등록
- 역(Station) 출력
    - StationRepostiroy->Station 이름
- 노선(Line) 등록
    - Line 만든 후 LineRepository에 등록
- 구간(Section) 출력
- 구간(Section) 등록
    - StationService를 통해 가져와서 Line에 등록
- 구간(Section) 삭제
    - LineService를 통해 가져와서 제거
- 역(Station) 제거
    - StationRepository에서 제거
- 노선(Line) 제거
    - LineRepository에서 제거

<br>

## ☑️ 예외처리 목록
### 메뉴 선택 관련
- [ ] 존재하지 않는 메뉴 입력시

### Station 관련
#### 저장
- [x] 이름 2글자 미만
- [x] 이름이 '역'으로 끝나지 않을 시
- [x] 이름에 공백이 포함된 경우
- [x] 중복된 이름

#### 삭제
- [ ] 없는 역 이름
- [ ] 구간(Section)에 등록되어 있는 역

#### 출력
- [ ] 등록 되어있는 Station이 없는 경우

### Line 관련
#### 저장
- [x] 이름 2글자 미만
- [x] 이름이 '선'으로 끝나지 않을 시
- [x] 이름에 공백이 포함된 경우
- [x] 중복된 노선명
- [ ] 상/하행에 중복된 Station

#### 삭제
- [ ] 없는 노선명

#### 출력
- [ ] 등록 되어있는 Line이 없는 경우

### Section 관련
#### 삽입
- [ ] 삽입시 이미 중복된 Station 존재
- [ ] 존재하지 않는 Line 이름 입력
- [ ] 존재하지 않는 Station 이름 입력
- [ ] 순서가 양의 정수가 아님
- [ ] 순서 범위를 넘어감

#### 제거
- [ ] 없는 Line 이름 입력
- [ ] Line에 없는 Station 이름 입력
- [ ] Line에 남은 Station이 2개 이하

#### 출력
- [ ] 등록된 구간(노선)이 없는 경우