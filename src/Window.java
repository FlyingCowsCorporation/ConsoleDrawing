import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;


public class Window {

    private JFrame frame = new JFrame("My Drawing");
    private JPanel canvasPanel = new JPanel();
    private JTextArea canvasTextArea = new JTextArea(40, 60);
    private SceneObject sceneObject;
    private Canvas canvas = new Canvas(canvasTextArea.getColumns(),canvasTextArea.getRows());

    public void createWindow() throws Exception {
        ///////////import font
        String fName = "fonts/square.ttf";
        FileInputStream is = new FileInputStream(fName);
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);

        ///////////init frame
        frame.setSize(880, 600);
        frame.setLocation(150, 250);
        frame.setVisible(true);
        frame.setBackground(Color.GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        ///////////menu
        JPanel menuPanel = new JPanel();

        menuPanel.setBorder(new TitledBorder(new EtchedBorder(), "Menu"));
        menuPanel.setPreferredSize(new Dimension(135,380));

        //buttons
        ArrayList<String> buttonText = new ArrayList<>();
        
        buttonText.add("Add Square");
        buttonText.add("Add Oval");
        buttonText.add("Add Triangle");
        buttonText.add("Make hollow");
        buttonText.add("Move Up");
        buttonText.add("Move down");
        buttonText.add("Move right");
        buttonText.add("Move left");
        buttonText.add("Clear canvas");
        buttonText.add("Clear last object");
        buttonText.add("Make taller");
        buttonText.add("Make shorter");
        buttonText.add("Make wider");
        buttonText.add("Make narrower");

        for(String text : buttonText){
            JButton button = new JButton(text);
            button.setPreferredSize(new Dimension(120,20));
            //add action listner
            button.addActionListener(
                    e -> {
                        buttonAction(button.getText());
                    });
            menuPanel.add(button);
        }

        ///////////canvas
        canvasPanel.setBorder(new TitledBorder(new EtchedBorder(), "Canvas"));

        canvasTextArea.setFont(font.deriveFont(10f));
        canvasTextArea.setEditable(false);

        ///////////add everything to frame
        canvasPanel.add(canvasTextArea);
        frame.getContentPane().add(menuPanel);
        frame.getContentPane().add(canvasPanel);

    }

    private void buttonAction(String text) {
        switch (text) {
            case "Add Square":
                sceneObject = new SceneObject(new Rectangle(10,10),10,10);
                canvas.addObject(sceneObject);
                renderCanvas();
                break;

            case "Add Oval":
                sceneObject = new SceneObject(new Oval(10,10),10,10);
                canvas.addObject(sceneObject);
                renderCanvas();
                break;

            case "Add Triangle":
                sceneObject = new SceneObject(new Triangle(10,10),10,10);
                canvas.addObject(sceneObject);
                renderCanvas();
                break;

            case "Make hollow":
                sceneObject.getShape().makeOutline();
                renderCanvas();
                break;

            case "Move Up":
                sceneObject.move(0, -1);
                renderCanvas();
                break;

            case "Move down":
                sceneObject.move(0, 1);
                renderCanvas();
                break;

            case "Move right":
                sceneObject.move(1, 0);
                renderCanvas();
                break;

            case "Move left":
                sceneObject.move(-1, 0);
                renderCanvas();
                break;

            case "Clear canvas":
                canvas.clear();
                renderCanvas();
                break;

            case "Clear last object":
                canvas.clearLastObject();
                renderCanvas();
                break;

            case "Make taller":
                sceneObject.scale(0,1);
                renderCanvas();
                break;

            case "Make shorter":
                sceneObject.scale(0,-1);
                renderCanvas();
                break;

            case "Make wider":
                sceneObject.scale(1,0);
                renderCanvas();
                break;

            case "Make narrower":
                sceneObject.scale(-1,0);
                renderCanvas();
                break;


            default:
                    System.out.println("Buttons does not exist");
        }
    }

    private void renderCanvas() {
        canvasTextArea.setText(canvas.toString());

    }
}
