******

### 릴리스 기록

******

# v1.0.0

###### 2026/09/01

* `기능` 플러그인 ID `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`, 엔진 `paddle-ocr`, 변형 `v6`의 Paddle OCR PP-OCRv6 플러그인 서비스를 추가
* `기능` 공유 OCR AIDL action `org.autojs.plugin.PADDLE_OCR`를 통한 호스트 검색 및 호출을 추가
* `기능` 인식 텍스트, 신뢰도, 줄 경계, 사각형 좌표, 검출/인식 시간을 반환하는 `recognizeText`와 `detect` 인터페이스를 추가
* `기능` Tiny, Small, Medium 모델 프로필을 추가하고 `small`을 Android 권장 기본값으로 설정
* `기능` 인코딩 이미지 입력과 원시 `ARGB_8888` 이미지 버퍼 입력 지원을 추가
* `기능` 공식 ONNX 다운로드와 `--source-dir`를 통한 로컬 Paddle 정적 모델 변환을 지원하는 PP-OCRv6 모델 자산 준비 스크립트를 추가
* `기능` 스페인어/프랑스어/러시아어/아랍어/일본어/한국어/영어/간체 중국어/홍콩 번체/대만 번체에 대한 플러그인 메타데이터와 사용 설명을 추가
* `기능` README와 CHANGELOG용 JSON 소스 파일 및 `.python/generate_markdown.py` 생성 흐름을 추가
* `기능` `arm64-v8a`, `armeabi-v7a` 및 `universal` APK를 위한 ABI 분할 APK 빌드를 추가
* `기능` Release APK 파일 이름에 버전, flavor, ABI 변형 및 release 아카이브 작업의 선택적 CRC32 다이제스트를 포함하도록 변경
* `수정` 일부 시스템에서 설치 후 플러그인 센터를 통해 플러그인을 활성화할 수 없는 문제
* `개선` README 레이아웃과 Gradle 플랫폼 버전 관리 방식을 통일
