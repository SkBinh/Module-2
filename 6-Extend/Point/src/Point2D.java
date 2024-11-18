import java.lang.reflect.Array;
import java.util.Arrays;

public class Point2D {
    private double x = 1.0;
    private double y = 1.0;
    public Point2D(){}
    public Point2D(double x, double y){
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
        return "Point 2D: x = "
                + getX()
                +", y = "
                + getY()
                +", xy = "
                + Arrays.toString(getXY());
    }
}
