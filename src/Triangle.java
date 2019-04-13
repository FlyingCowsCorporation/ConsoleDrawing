public class Triangle extends Shape {
    public Triangle(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
    }

    @Override
    public void fill() {
        double halfwayPoint = sizeX / 2.0;

        for(int y = 0; y < sizeY; y++){
            double offset = calculatePixelOffset(y);

            int startingPoint = (int)Math.round(halfwayPoint - offset);
            int endPoint = (int)Math.round(halfwayPoint + offset);

            for(int x = startingPoint; x < endPoint; x++) {
                fillPixel(x, y);
            }
        }
    }

    private double calculatePixelOffset(int yPosition){
        return yPosition / (double) sizeY * sizeX * 0.5;
    }
}
