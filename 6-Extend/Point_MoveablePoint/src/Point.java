
import java.util.Arrays;

public class Point {
    private double x = 1.0;
    private double y = 1.0;
    public Point(){}
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double[] getXY(){
        return new double[]{x, y};
    }
    @Override
    public String toString(){
        return "Point: x = "
                + getX()
                +", y = "
                + getY()
                +", xy = "
                + Arrays.toString(getXY());
    }
}
