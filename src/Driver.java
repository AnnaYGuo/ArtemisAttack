import javax.swing.*;
import java.awt.*;

public class Driver{
    private static JFrame frame;
    private static void printBackground(){
        frame = new JFrame();
        frame.setTitle("Artemis Attack");
        frame.setSize(Config.screenWidth, Config.screenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("map.png");
        Image image = imageIcon.getImage().getScaledInstance(Config.screenWidth, Config.screenHeight, java.awt.Image.SCALE_SMOOTH);
        JLabel background=new JLabel(new ImageIcon(image));

        frame.add(background);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        printBackground();
        Game game = new Game();
        game.start(frame);
        //while(true);
        /*JButton button = new JButton("Click Me!");
        button.addActionListener(this);


        frame.add(panel);
        frame.setVisible(true);*/
    }

}
