public class CanvasTests {
    public static void main(String... args){

        var canvas = new Canvas(100, 50);
        canvas.addShape(new Triangle(10, 5), 10, 10);
        canvas.addShape(new Oval(20, 30), 20, 15);
        canvas.addShape(new Rectangle(15, 3), 90, 3);

        var canvasString = canvas.toString();
        System.out.println(canvasString);
    }
}
