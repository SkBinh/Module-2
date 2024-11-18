import java.util.Arrays;

public class Point3D extends Point2D{
    private double z = 1.0;
    public Point3D(){}
    public Point3D(double x, double y, double z){
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public void setXYZ(double x, double y, double z){
        super.setXY(x, y);
        this.z = z;
    }
    public double[] getXYZ(){
        return new double[]{getX(), getY(), z};
    }
    @Override
    public String toString(){
        return "Point 3D: x = "
                + getX()
                +", y = "
                + getY()
                +", z = "
                + getZ()
                +", xyz = "
                + Arrays.toString(getXYZ());
    }
}
