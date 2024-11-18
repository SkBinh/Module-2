public class MovablePoint extends Point {
    private double xSpeed = 0.0f;
    private double ySpeed = 0.0f;
    public MovablePoint(double x, double y, double xSpeed, double ySpeed){
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MovablePoint(double xSpeed, double ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MovablePoint(){}

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(double xSpeed, double ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public double[] getSpeed(){
        return new double[]{getxSpeed(), getySpeed()};
    }
    public void move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }
    public void accelerate(double deltaX, double deltaY) {
        this.xSpeed += deltaX;
        this.ySpeed += deltaY;
    }
    @Override
    public String toString() {
        return "MovablePoint("
                + getX()
                + ", "
                + getY()
                + ", speed= (" + xSpeed + ", " + ySpeed + "))";
    }
}

