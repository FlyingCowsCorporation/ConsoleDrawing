import javax.swing.*;
import java.sql.SQLOutput;

public class ConsoleDrawing {
    public static void main(String[] args) {

        JFrame frame = new JFrame("My Drawing");
        JPanel pannel = new JPanel();
        JTextArea textArea = new JTextArea();
        frame.pack();
        frame.setSize(400,400);
        frame.add(pannel);
        textArea.setSize(200,200);
        pannel.add(textArea);

        frame.setVisible(true);


        System.out.println("Opdracht 1-3");
        System.out.println();

        Rectangle myRectangle = new Rectangle(15, 7);
        myRectangle.makeOutline();
        System.out.println(myRectangle);

        Oval myOval = new Oval(15, 7);
        myOval.makeOutline();
        System.out.println(myOval);

        Triangle myTriangle = new Triangle(15, 7);
        myTriangle.makeOutline();
        System.out.println(myTriangle);

//        System.out.println();
//        System.out.println("Opdracht 2-3");
//        System.out.println();
//
//        TODO: complete this code
//
//        Canvas myCanvas = new Canvas(...)
//        myCanvas.add(myRectangle, ...)
//        myCanvas.add(myRectangle, ...)
//        myCanvas.add(myRectangle, ...)
//        myCanvas.fill(); // is dat nodig, of kan dat slimmer?
//        System.out.println(myCanvas);
//
//        todo (end)

//        System.out.println();
//        System.out.println("Opdracht 2-4");
//        System.out.println();
//
//        TODO: complete this code
//
//        Shape linkervoet = ...
//        Shape rechtervoet = ...
//        Shape linkerbeen = ...
//        Shape rechterbeen = ...
//        Shape linkerarm = ...
//        Shape rechterarm = ...
//        Shape romp = ...
//        Shape hoofd = ...
//        Shape extra1 = ... - bedenk zelf iets dat je poppetje uniek maakt
//        Shape extra2 = ... - bedenk zelf iets dat je poppetje uniek maakt
//
//        Canvas papier = ...
//        papier.add(...) voeg al je Shapes toe aan het papier
//        papier.fill(); // is dat nodig, of kan dat slimmer?
//        System.out.println(papier);
//
//        todo (end)

//        System.out.println();
//        System.out.println("Opdracht 2-5");
//        System.out.println();
//
//        TODO: verplaats alle shapes zodat je een 'exploded view' krijgt en teken dan het resultaat
//
    }
}
