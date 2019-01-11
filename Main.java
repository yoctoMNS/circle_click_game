import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage stage) {
        stage.setTitle("Click game");

        GameController game = new GameController();
        stage.setScene(game.getScene());
        game.start();

        stage.show();
    }
}
