import java.util.ArrayList;

public class TriangleAlt extends Shape {
    public TriangleAlt(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
        fill();
    }

    @Override
    public void fill() {

        double B = (double) sizeY;
        double D = (double) sizeX / 2;
        double factor = 0;

        ArrayList<Integer> extraStarsArray = new ArrayList<>();
        //fill left side
        for (int a = 0; a < sizeX; a++) {
            if (a < D) {
                factor = a * B / D;//calculate the factor of current pixel
                int extraStars = 0;
                for (int b = 0; b < sizeY; b++) {
                    if (b < factor) { //if pos of pixel = lower then the factor
                        extraStars++;
                        fillPixel(a, b);
                    }
                }
                extraStarsArray.add(extraStars);
            }
            //fill middle
            if (a == D) {
                for(int y = 0; y< sizeY; y++) {
                    fillPixel((int) D, y);
                }
            }
        }
        //fill right side with a copy of left side
        int counter = 0;
        for (int x = sizeX; x > sizeX /2; x--){
            for(int y =0; y<extraStarsArray.get(counter);y++){
                fillPixel(x, y);
            }
            counter++;
        }
    }
}