import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Driver{
    private static JFrame frame;
    private static void printBackground(){
        frame = new JFrame();
        frame.setTitle("Artemis Attack");
        frame.setSize(Config.screenWidth, Config.screenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException {

        printBackground();
        Game game = new Game();
        JLabel background=new JLabel(new ImageIcon(Config.backgroundImage));

        JLayeredPane mapLayer = new JLayeredPane();
        background.setOpaque(true);
        background.setBounds(0, 0, Config.screenWidth, Config.screenHeight);
        mapLayer.add(background, 1);

        frame.add(mapLayer);
        //frame.add(background);
        //frame.add(game);
        //frame.pack();
        game.getAvatar().setOpaque(true);
        game.getAvatar().setBounds(Config.centerX, Config.centerY, 32, 32);
        mapLayer.add(game.getAvatar(), 40);
        frame.setVisible(true);
        game.start(mapLayer, frame);
        //while(true);
        /*JButton button = new JButton("Click Me!");
        button.addActionListener(this);


        frame.add(panel);
        frame.setVisible(true);*/
    }

}
