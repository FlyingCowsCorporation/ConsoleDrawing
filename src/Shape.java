import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    private String pixels[][];

    protected int sizeX;
    protected int sizeY;
    private static final String FILLED = "*";
    private static final String EMPTY  = " ";

    public Shape(int sizeX, int sizeY) {
        if (sizeX <= 0 || sizeY <= 0) {
            throw new IllegalArgumentException("Illegal size of shape");
        }
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        initializePixels();
    }

    protected void initializePixels(){
        pixels = new String[sizeX][sizeY];
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                clearPixel(x, y);
            }
        }
        fill();
    }

    public int getWidth() {
        return sizeX;
    }

    public int getHeight() {
        return sizeY;
    }

    public void setWidth(int width) {
        if(width<0) width = 0;
        this.sizeX = width;
        initializePixels();
    }

    public void setHeight(int height) {
        if(height<0) height = 0;
        this.sizeY = height;
        initializePixels();
    }

    public abstract void fill();

    public void fillPixel(int x, int y) {
        pixels[x][y] = FILLED;
    }

    public void clearPixel(int x, int y) {
        pixels[x][y] = EMPTY;
    }

    public boolean isFilledPixel(int x, int y) {
        return (pixels[x][y].equals(FILLED));
    }

    public void makeOutline(){

        List<Integer> clearX = new ArrayList<>();
        List<Integer> clearY = new ArrayList<>();

        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                if(isSurrounded(x, y)){
                    clearX.add(x);
                    clearY.add(y);
                }
            }
        }

        for(int i = 0; i < clearX.size(); i++){
            clearPixel(clearX.get(i), clearY.get(i));
        }
    }

    private boolean isSurrounded(int x, int y){
        // Edge pixels are never fully surrounded.
        if((x <= 0) || (y <= 0) || (x >= sizeX - 1) || (y >= sizeY - 1)){
            return false;
        }

        return (isFilledPixel(x-1,y)
                && isFilledPixel(x+1, y)
                && isFilledPixel(x, y-1)
                && isFilledPixel(x, y+1));
    }

    public String toString() {
        String output = "";
        for (int y = sizeY - 1; y >= 0; y--) {
            for (int x = 0; x < sizeX; x++) {
                output += pixels[x][y];
            }
            output += "\n";
        }
        return output;
    }
}
