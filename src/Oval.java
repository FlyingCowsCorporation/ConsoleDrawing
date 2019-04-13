public class Oval extends Shape{

    public Oval(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
    }

    private static double offCenter(double center, int size, int pixel) {

        return 2 * (pixel + 0.5 - center) / size;
    }

    @Override
    public void fill() {
        double xCenter = sizeX / 2.0;
        double yCenter = sizeY / 2.0;

        for (int xPixel = 0; xPixel < sizeX; xPixel++) {
            double xOffCenter = offCenter(xCenter, sizeX, xPixel);
            for (int yPixel = 0; yPixel < sizeY; yPixel++) {
                double yOffCenter = offCenter(yCenter, sizeY, yPixel);
                if (xOffCenter * xOffCenter + yOffCenter * yOffCenter <= 1) {
                    fillPixel(xPixel, yPixel);
                }
            }
        }
    }
}
