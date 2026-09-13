******

### リリース履歴

******

# v1.0.3

###### 2026/09/13

* `修正` プラグインセンターのバージョンと ABI 情報がインストール済み APK と一致
* `修正` エンコード済み画像は 64 MiB まで対応し ファイル記述子とパイプを使用できます
* `修正` バージョン日付は英語の統一形式で表示されます
* `改善` ダウンロード用ファイルの作成前に, リリース APK のバージョン, 署名, バリアントの完全性を検証
* `改善` 画像は最大 16777216 ピクセルまで, 生画像バッファーは 64 MiB まで対応

# v1.0.2

###### 2026/09/12

* `修正` 16 KB ページサイズ端末でエンジン初期化時にクラッシュ (SIGSEGV) する問題を修正: 同梱の `libc++_shared.so` を NDK r28.2 ビルドに更新し, RELRO セグメントが書き込み可能データとページを共有しないように (arm64-v8a, armeabi-v7a)
* `修正` 大きな認識モデルの読み込み時に `OutOfMemoryError` が発生して空の結果が返される問題を修正: モデルアセットをアプリ専用ストレージへ一度だけ展開し, Java ヒープに読み込む代わりに ONNX Runtime がメモリマップするように
* `修正` 一部の Gradle/AGP の組み合わせで Kotlin ソースがコンパイルされず, `WakeActivity` の重複定義によりビルドが失敗する問題
* `改善` OpenCV 4.8.0 ネイティブライブラリを NDK r28c (Clang 19.0.1) 再ビルド版に同期 (donor: AutoJs6-Plugin-OpenCV); 4 つの ABI の `libopencv_java4.so` は 16 KB `PT_LOAD` アラインメントを維持し provenance マニフェストを同梱

# v1.0.1

###### 2026/09/11

* `改善` 64 ビットのネイティブライブラリの 16 KB ページアラインメントをビルド時に検証, manifest 契約の検査と JSON レポートに対応

# v1.0.0

###### 2026/09/01

* `機能` プラグイン ID `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`, エンジン `paddle-ocr`, バリアント `v6` の Paddle OCR PP-OCRv6 プラグインサービスを追加
* `機能` 共有 OCR AIDL action `org.autojs.plugin.PADDLE_OCR` によるホスト側の検出と呼び出しを追加
* `機能` 認識テキスト, 信頼度, 行境界, 四点座標, 検出/認識時間を返す `recognizeText` と `detect` インターフェイスを追加
* `機能` Tiny, Small, Medium のモデルプロファイルを追加し, `small` を Android 推奨デフォルトに設定
* `機能` エンコード画像入力と raw `ARGB_8888` 画像バッファ入力に対応
* `機能` 公式 ONNX ダウンロードと `--source-dir` によるローカル Paddle 静的モデル変換に対応した PP-OCRv6 モデルアセット準備スクリプトを追加
* `機能` スペイン語/フランス語/ロシア語/アラビア語/日本語/韓国語/英語/簡体字中国語/香港繁体字/台湾繁体字のプラグインメタデータと使用説明を追加
* `機能` README と CHANGELOG 用の JSON ソースファイルおよび `.python/generate_markdown.py` 生成フローを追加
* `機能` `arm64-v8a`, `armeabi-v7a`, `universal` APK 向けの ABI 分割 APK ビルドを追加
* `機能` Release APK ファイル名にバージョン, flavor, ABI バリアント, release アーカイブタスクによる任意の CRC32 ダイジェストを含めるように変更
* `修正` 一部のシステムでインストール後にプラグインセンターからプラグインを有効化できない問題
* `改善` README のレイアウトと Gradle プラットフォームのバージョン管理方式を統一
