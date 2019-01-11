import javafx.geometry.Point2D;


public class Circle {
    private Point2D center;  // �~�̒��S�_
    private double radius;      // ���a

    /**
     * Circle�N���X�̃R���X�g���N�^�ł��B
     * �~�̒��S�_���W�Ɣ��a��ݒ肵�܂�.
     * @param x �~�̒��S�_���Wx���n����܂��B
     * @param y �~�̒��S�_���Wy���n����܂��B
     * @param r �~�̔��a���n����܂��B
     */
    public Circle(double x, double y, double r) {
        setCenter(x, y);
        setRadius(r);
    }

    /*
     * �~�̔��a��ݒ肵�܂��B
     * ���̃��\�b�h�̓R���X�g���N�^����̂݌Ăяo����܂��B
     * @param r �~�̔��a���n����܂��B
     */
    private void setRadius(double r) {
        radius = r;
    }

    /**
     * �~�̒��S�_���W��ݒ肵�܂��B
     * @param x �~�̒��S���Wx���n����܂��B
     * @param y �~�̒��S���Wy���n����܂��B
     */
    public void setCenter(double x, double y) {
        center = new Point2D(x, y);
    }

    /**
     * �~�̒��S���Wx�̒l��ԋp���܂��B
     * @return �~�̒��S���Wx�B
     */
    public double getX() {
        return center.getX();
    }

    /**
     * �~�̒��S���Wy�̒l��ԋp���܂��B
     * @return �~�̒��S���Wy�B
     */
    public double getY() {
        return center.getY();
    }

    /**
     * �}�E�X�ŃN���b�N�����ꏊ���A�~�͈͓̔����𔻒肷�郁�\�b�h�ł��B
     * @param x �}�E�X�ŃN���b�N�����ꏊ��x���W���n����܂��B
     * @param y �}�E�X�ŃN���b�N�����ꏊ��y���W���n����܂��B
     * @return �}�E�X�ŃN���b�N�����ꏊ���~�͈͓̔��ł����true���Ԃ���A<br>
     *         �����łȂ����false���Ԃ���܂��B
     */
    public boolean isContains(double x, double y) {
        return center.distance(x, y) < radius;
    }

    /**
     * �~�̔��a�̒�����ԋp���܂��B
     * @return �~�̔��a�B
     */
    public double getRadius() {
        return radius;
    }
}
