import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// ロガーを取得してログレベルをINFOに設定
Logger logger = Logger.getLogger(this.getClass().getName());
logger.setLevel(Level.INFO);

// ハンドラーを作成してロガーに登録
Handler handler = new FileHandler("sample.log");
logger.addHandler(handler);

// フォーマッターを作成してハンドラーに登録
Formatter formatter =  new SimpleFormatter();
handler.setFormatter(formatter);

// INFOメッセージを出力
logger.log(Level.INFO, "INFOメッセージ");

// それぞれのログレベルのメッセージを出力する簡易メソッドが用意されています。
logger.finest("FINESTメッセージ");
logger.finer("FINERメッセージ");
logger.fine("FINEメッセージ");
logger.config("CONFIGメッセージ");
logger.info("INFOメッセージ");
logger.warning("WARNINGメッセージ");
logger.severe("SEVEREメッセージ");

// メッセージは文字列で渡す方法の他に、Supplier<String>を渡す方法もあります。
Supplier<String> supplier = new Supplier<String>() {
	@Override
	public String get() {
		return "Supplyメッセージ";
	}
};
logger.info(supplier);

// Exceptionが発生した時のログ出力方法は以下の通り。引数に渡されたThrowableのスタックトレースが出力されます。
logger.log(Level.WARNING, "エラーが発生しました。", new RuntimeException("ランタイムエラー"));
