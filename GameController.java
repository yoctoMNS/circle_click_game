import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


/**
 * GameController クラス。<br>
 * 
 * ゲームの制御全般を管理するクラスです。<br>
 * ゲームで必要な基本的なオブジェクトが定義されていて、<br>
 * それらを利用しゲーム全般の制御を行ってください。<br>
 * @see javafx.animation.AnimationTimer
 * FIXME: 
 * 1. 文字が青になりません。
 * 2. 画像が画面からはみ出してしまいます。
 */
public class GameController extends AnimationTimer{
    public static final int CANVAS_SIZE = 500;
    
    private int score;
    private Circle circle;
    private Group root;
    private Scene scene;         
    private Canvas canvas;
    private GraphicsContext gc;
    private Image circleImg;
    private Font font;
    private Random rnd;
    

    /**
     * GameControllerクラスのコンストラクタです。
     */
    public GameController() {
        buildInstance();
        root.getChildren().add(canvas);
    }

    /*
     * このクラスに定義されている、各オブジェクトのインスタンス化を行います。
     * このメソッドはコンストラクタからのみ呼び出されます。
     */
    private void buildInstance() {
        circle = new Circle(100, 100, 32);
        root = new Group();
        scene = new Scene(root);
        canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
        gc = canvas.getGraphicsContext2D();
        font = Font.font("family", FontWeight.BOLD, 24);
        circleImg = new Image("img/circle.png");
        rnd = new Random();
    }

    /*
     * フォントの各パラメータの設定を行います。
     * このメソッドはコンストラクタからのみ呼び出されます。
     */
    private void buildFont() {
        gc.setFont(font);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
    }

    /*
     * マウスがクリックされた際の処理です。
     * マウスがクリックされたら、クリックされた位置が円の範囲内かを判定し、
     * もしそうであるのならば、円が表示される位置と円の中心点座標を変更します。
     * このメソッドはhandleメソッドからのみ呼び出されます。
     */
    private void mouseClick() {
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                if (circle.isContains(event.getX(), event.getY())) {
                    double x = rnd.nextInt(CANVAS_SIZE);
                    double y = rnd.nextInt(CANVAS_SIZE);
                    circle.setCenter(x, y);
                    ++score;
                } else {
                    score = 0;
                }
            }
        });
    }

    /*
     * 画面の描画処理です。
     * このメソッドはhandleメソッドからのみ呼び出されます。
     */
    private void draw() {
        // 背景の描画
        gc.setFill(new Color(0.9, 0.9, 1.0, 1.0));
        gc.fillRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);

        // 画像の描画
        gc.drawImage(circleImg,
                     circle.getX() - circle.getRadius(),
                     circle.getY() - circle.getRadius());

        // 文字の描画
        String strScore = "Score: " + score;
        gc.setFill(Color.BLUE);
        gc.fillText(strScore, CANVAS_SIZE-100, 30);
        gc.strokeText(strScore, CANVAS_SIZE-100, 30);
    }

    /**
     * {@inheritDoc}
     */
    @Override public void handle(long now) {
        draw();
        mouseClick();
    }

    /**
     * sceneを返却します。
     * @return scene.
     */
    public Scene getScene() {
        return scene;
    }
}
