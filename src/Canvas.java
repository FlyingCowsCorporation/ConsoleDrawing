import java.util.ArrayList;
import java.util.List;

public class Canvas {

    private List<SceneObject> scene = new ArrayList<>();

    private int width;
    private int height;

    private char filledChar = '#';
    private char emptyChar = '.';

    public Canvas(int width, int height){

        this.width = width;
        this.height = height;
    }

    public void addObject(SceneObject obj){
        scene.add(obj);
    }

    public void addShape(Shape shape, int x, int y){
        addObject(new SceneObject(shape, x, y));
    }

    private boolean testPixel(SceneObject obj, int x, int y){
        int relX = x - obj.getX();
        int relY = y - obj.getY();

        if( relX < 0 || relY < 0) {
            return false;
        }
        if( relX >= obj.getShape().SIZEX || relY >= obj.getShape().SIZEY) {
            return false;
        }
        return obj.getShape().isFilledPixel(relX, relY);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                boolean filled = false;

                for(SceneObject obj : scene){
                    filled = filled || testPixel(obj, x, y);
                }

                sb.append(filled ? filledChar : emptyChar);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
