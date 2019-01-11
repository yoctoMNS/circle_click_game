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
 * GameController �N���X�B<br>
 * 
 * �Q�[���̐���S�ʂ��Ǘ�����N���X�ł��B<br>
 * �Q�[���ŕK�v�Ȋ�{�I�ȃI�u�W�F�N�g����`����Ă��āA<br>
 * �����𗘗p���Q�[���S�ʂ̐�����s���Ă��������B<br>
 * @see javafx.animation.AnimationTimer
 * FIXME: 
 * 1. �������ɂȂ�܂���B
 * 2. �摜����ʂ���͂ݏo���Ă��܂��܂��B
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
     * GameController�N���X�̃R���X�g���N�^�ł��B
     */
    public GameController() {
        buildInstance();
        root.getChildren().add(canvas);
    }

    /*
     * ���̃N���X�ɒ�`����Ă���A�e�I�u�W�F�N�g�̃C���X�^���X�����s���܂��B
     * ���̃��\�b�h�̓R���X�g���N�^����̂݌Ăяo����܂��B
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
     * �t�H���g�̊e�p�����[�^�̐ݒ���s���܂��B
     * ���̃��\�b�h�̓R���X�g���N�^����̂݌Ăяo����܂��B
     */
    private void buildFont() {
        gc.setFont(font);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
    }

    /*
     * �}�E�X���N���b�N���ꂽ�ۂ̏����ł��B
     * �}�E�X���N���b�N���ꂽ��A�N���b�N���ꂽ�ʒu���~�͈͓̔����𔻒肵�A
     * ���������ł���̂Ȃ�΁A�~���\�������ʒu�Ɖ~�̒��S�_���W��ύX���܂��B
     * ���̃��\�b�h��handle���\�b�h����̂݌Ăяo����܂��B
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
     * ��ʂ̕`�揈���ł��B
     * ���̃��\�b�h��handle���\�b�h����̂݌Ăяo����܂��B
     */
    private void draw() {
        // �w�i�̕`��
        gc.setFill(new Color(0.9, 0.9, 1.0, 1.0));
        gc.fillRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);

        // �摜�̕`��
        gc.drawImage(circleImg,
                     circle.getX() - circle.getRadius(),
                     circle.getY() - circle.getRadius());

        // �����̕`��
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
     * scene��ԋp���܂��B
     * @return scene.
     */
    public Scene getScene() {
        return scene;
    }
}
