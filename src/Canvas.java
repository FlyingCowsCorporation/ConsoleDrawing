import java.util.ArrayList;
import java.util.List;

public class Canvas {

    private List<SceneObject> scene = new ArrayList<>();

    private int width;
    private int height;

    public Canvas(int width, int height){

        this.width = width;
        this.height = height;
    }

    public void addObject(SceneObject obj){

    }

    @Override
    public String toString(){
        return "";
    }
}
