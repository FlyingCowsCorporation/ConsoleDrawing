
public class TriangleAlt2 extends Shape {
    public TriangleAlt2(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
        fill();
    }

    @Override
    public void fill() {
        // TODO
        int half = sizeX / 2;
        int offSet = 0;


        for (int y = sizeY - 1; y >= 0; y--) {

            for (int x = half - offSet; x < half + 1 + offSet; x++) {

                fillPixel(x, y);
            }

            offSet++;
        }
    }
}

