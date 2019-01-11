import javafx.geometry.Point2D;


public class Circle {
    private Point2D center;  // 円の中心点
    private double radius;      // 半径

    /**
     * Circleクラスのコンストラクタです。
     * 円の中心点座標と半径を設定します.
     * @param x 円の中心点座標xが渡されます。
     * @param y 円の中心点座標yが渡されます。
     * @param r 円の半径が渡されます。
     */
    public Circle(double x, double y, double r) {
        setCenter(x, y);
        setRadius(r);
    }

    /*
     * 円の半径を設定します。
     * このメソッドはコンストラクタからのみ呼び出されます。
     * @param r 円の半径が渡されます。
     */
    private void setRadius(double r) {
        radius = r;
    }

    /**
     * 円の中心点座標を設定します。
     * @param x 円の中心座標xが渡されます。
     * @param y 円の中心座標yが渡されます。
     */
    public void setCenter(double x, double y) {
        center = new Point2D(x, y);
    }

    /**
     * 円の中心座標xの値を返却します。
     * @return 円の中心座標x。
     */
    public double getX() {
        return center.getX();
    }

    /**
     * 円の中心座標yの値を返却します。
     * @return 円の中心座標y。
     */
    public double getY() {
        return center.getY();
    }

    /**
     * マウスでクリックした場所が、円の範囲内かを判定するメソッドです。
     * @param x マウスでクリックした場所のx座標が渡されます。
     * @param y マウスでクリックした場所のy座標が渡されます。
     * @return マウスでクリックした場所が円の範囲内であればtrueが返され、<br>
     *         そうでなければfalseが返されます。
     */
    public boolean isContains(double x, double y) {
        return center.distance(x, y) < radius;
    }

    /**
     * 円の半径の長さを返却します。
     * @return 円の半径。
     */
    public double getRadius() {
        return radius;
    }
}
