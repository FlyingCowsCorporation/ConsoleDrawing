public class Triangle extends Shape {
    public Triangle(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
        fill();
    }

    @Override
    public void fill() {
        double halfwayPoint = SIZEX / 2.0;

        for(int i = 0; i < SIZEY; i++){
            double offset = calculatePixelOffset(SIZEY - i - 1);

            int startingPoint = (int)Math.round(halfwayPoint - offset);
            int endPoint = (int)Math.round(halfwayPoint + offset);

            for(int j = startingPoint; j < endPoint; j++) {
                fillPixel(j, i);
            }
        }
    }

    private double calculatePixelOffset(int yPosition){
        return yPosition / (double)SIZEY * SIZEX * 0.5;
    }
}
