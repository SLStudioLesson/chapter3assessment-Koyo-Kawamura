import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");

            // ユーザーからの入力を読み込む
            String choice = reader.readLine();
            // 選択されたデータハンドラーを格納する変数
            DataHandler dataHandler;

            switch (choice) {
                case "1":
                    // CSVデータハンドラーのインスタンスを生成
                    dataHandler = new CSVDataHandler();
                    break;
                case "2":
                    // JSONデータハンドラーのインスタンスを生成
                    dataHandler = new JSONDataHandler();
                    break;
                // 不正な入力の場合、デフォルトでCSVデータハンドラーを生成
                default:
                    dataHandler = new CSVDataHandler();
                    break;
            }

            // 生成されたインスタンスを渡す
            RecipeUI ui = new RecipeUI(dataHandler);
            // メニューを表示する
            ui.displayMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
