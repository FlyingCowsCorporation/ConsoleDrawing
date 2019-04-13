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
        menuPanel.setPreferredSize(new Dimension(135,280));

        //buttons
        ArrayList<JButton> buttons = new ArrayList<>();
        JButton squareButton = new JButton("Add Square");
        buttons.add(squareButton);
        JButton ovalButton = new JButton("Add Oval");
        buttons.add(ovalButton);
        JButton triangleButton = new JButton("Add Triangle");
        buttons.add(triangleButton);
        JButton hollowButton = new JButton("Make hollow");
        buttons.add(hollowButton);
        JButton upButton =  new JButton("Move Up");
        buttons.add(upButton);
        JButton downButton =  new JButton("Move down");
        buttons.add(downButton);
        JButton rightButton =  new JButton("Move right");
        buttons.add(rightButton);
        JButton leftButton =  new JButton("Move left");
        buttons.add(leftButton);
        JButton clearButton = new JButton("Clear canvas");
        buttons.add(clearButton);
        JButton clearLastButton = new JButton("Clear last object");
        buttons.add(clearLastButton);
        for(JButton button:buttons){
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

                default:
                    System.out.println("Buttons does not exist");
        }
    }

    private void renderCanvas() {
        canvasTextArea.setText(canvas.toString());

    }
}
