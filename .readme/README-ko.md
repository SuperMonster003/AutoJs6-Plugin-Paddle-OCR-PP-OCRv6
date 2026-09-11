<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-paddle-ocr-pp-ocrv6-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>로컬 OCR용 Paddle OCR PP-OCRv6 플러그인</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 언어 (Languages)

******

현재 README.md는 다음 언어를 지원합니다:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ja.md)
- 한국어 [ko] # 현재
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ar.md)

******

### 소개

******

AutoJs6 Paddle OCR PP-OCRv6 플러그인은 Paddle OCR PP-OCRv6 기반 로컬 텍스트 검출과 인식을 AutoJs6에 제공합니다. Tiny, Small, Medium 모델 프로필마다 별도 APK를 빌드합니다.

******

### 기능

******

- 플러그인 ID `paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium`, 엔진 `paddle-ocr`, 변형 `v6`의 공유 OCR 플러그인 서비스를 제공합니다.
- `org.autojs.plugin.PADDLE_OCR`를 통해 OCR AIDL 인터페이스를 노출하고 AutoJs6 호스트 OCR 플러그인 검색 흐름과 호환됩니다.
- `recognizeText`는 텍스트 줄 목록을 반환하고 `detect`는 텍스트, 신뢰도, 줄 경계, 사각형 좌표, 시간 메타데이터를 반환합니다.
- 인코딩 이미지 입력과 원시 `ARGB_8888` 이미지 버퍼 입력을 지원합니다.
- `small`은 Android 권장 기본값, `tiny`는 저사양 기기와 가장 빠른 로컬 OCR, `medium`은 더 높은 정확도의 OCR을 대상으로 합니다.
- `scripts/prepare_ppocrv6_assets.py`를 제공하여 PP-OCRv6 모델 자산을 준비하고 각 프로필을 자체 flavor assets 디렉터리에 배치합니다.
- 플러그인 메타데이터, 사용 설명, README, CHANGELOG는 스페인어/프랑스어/러시아어/아랍어/일본어/한국어/영어/간체 중국어/홍콩 번체/대만 번체로 현지화되어 있습니다.
- `com.microsoft.onnxruntime:onnxruntime-android`와 OpenCV 4.8.0을 기반으로 합니다.

******

### 모델 프로필

******

```text
tiny: 저사양 기기와 가장 빠른 로컬 OCR
small: Android 권장 기본값
medium: 더 큰 모델 자산을 사용하는 고정확도 OCR
```

각 프로필은 독립 product flavor로 패키징되므로 APK에는 선택한 모델 자산만 포함됩니다

******

### 플러그인 인터페이스

******

호스트는 다음 식별 정보로 플러그인을 검색하고 호출할 수 있습니다:

```text
action: org.autojs.plugin.PADDLE_OCR
engine: paddle-ocr
variant: v6
plugin ids: paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium
```

`recognizeText`는 문자열 목록을 반환합니다; `detect`는 `text`, `confidence`, `bounds`, `quad`, `detectionTimeMs`, `recognitionTimeMs`, `totalTimeMs`, `coldLoadTimeMs`를 포함하는 OCR 결과 객체를 반환합니다.

******

### 모델 자산

******

```powershell
python scripts/prepare_ppocrv6_assets.py --profile small
python scripts/prepare_ppocrv6_assets.py --profile tiny
python scripts/prepare_ppocrv6_assets.py --profile medium
```

스크립트는 공식 PP-OCRv6 ONNX 자산을 다운로드하거나 `--source-dir`가 제공되면 로컬 Paddle 정적 모델 아카이브를 변환합니다. 기본적으로 자산은 `app/src/<profile>/assets`에 기록됩니다.

******

### 릴리스 기록

******

# v1.0.1

###### 2026/09/11

* `개선` 64비트 네이티브 라이브러리의 16 KB 페이지 정렬을 빌드 시 검증, manifest 계약 검사 및 JSON 보고서 지원

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

##### 더 많은 릴리스 기록

* [CHANGELOG-ko.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/assets/doc/CHANGELOG-ko.md)

******

### 빌드

******

```powershell
.\gradlew.bat :app:assembleSmallDebug
.\gradlew.bat :app:assembleTinyDebug
.\gradlew.bat :app:assembleMediumDebug
```

Release 빌드:

```powershell
.\gradlew.bat :app:assembleSmallRelease
.\gradlew.bat :app:assembleTinyRelease
.\gradlew.bat :app:assembleMediumRelease
```

빌드 매개변수는 `version.properties`에서 가져옵니다. app 최소 SDK는 26이고 대상 SDK는 36입니다.

******

### 리소스 구조

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG-*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml`에는 현지화된 플러그인 설명이 포함됩니다; `plugin_instruction.md`에는 호스트에서 표시하는 사용 설명이 포함됩니다. README와 CHANGELOG는 `.python/generate_markdown.py`가 JSON 소스에서 생성합니다.

******

### 링크

******

- AutoJs6 문서: https://docs.autojs6.com
- PaddleOCR 공식 프로젝트: https://github.com/PaddlePaddle/PaddleOCR
- PaddleX 공식 프로젝트: https://github.com/PaddlePaddle/PaddleX


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/docs/16kb.md)
