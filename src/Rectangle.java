public class Rectangle extends Shape {
    public Rectangle(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
        fill();
    }

    @Override
    public void fill() {
        // TODO
        for(int xPixel = 0; xPixel< sizeX; xPixel ++){
            for (int yPixel = 0; yPixel< sizeY; yPixel++)
            fillPixel(xPixel, yPixel);
        }
    }
}
