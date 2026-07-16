******

### リリース履歴

******

# v1.0.0

###### 2026/07/17

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
