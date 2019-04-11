public class Triangle extends Shape {
    public Triangle(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
        fill();
    }

    @Override
    public void fill() {
        double halfwayPoint = SIZEX / 2.0;

        for(int y = 0; y < SIZEY; y++){
            double offset = calculatePixelOffset(SIZEY - y - 1);

            int startingPoint = (int)Math.round(halfwayPoint - offset);
            int endPoint = (int)Math.round(halfwayPoint + offset);

            for(int x = startingPoint; x < endPoint; x++) {
                fillPixel(x, y);
            }
        }
    }

    private double calculatePixelOffset(int yPosition){
        return yPosition / (double)SIZEY * SIZEX * 0.5;
    }
}
