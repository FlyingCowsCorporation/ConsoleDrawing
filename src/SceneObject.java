public class SceneObject {

    private Shape shape;
    private int x;
    private int y;

    public SceneObject(Shape shape, int x, int y){

        this.shape = shape;
        this.x = x;
        this.y = y;
    }

    public Shape getShape() {
        return shape;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int dX, int dY){
        this.x += dX;
        this.y += dY;
    }
}
