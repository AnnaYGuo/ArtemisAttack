import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Config {
    public static final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static final int centerX = screenWidth/2;
    public static final int centerY = screenHeight/2;
    public static final int unit = 10;
    public static final Image backgroundImage = (new ImageIcon("map.png")).getImage().getScaledInstance(Config.screenWidth, Config.screenHeight, java.awt.Image.SCALE_SMOOTH);
    public static final BufferedImage enemyImageSheet;
    static {
        try {
            enemyImageSheet = ImageIO.read(new File("enemy.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //(new ImageIcon("enemy.png")).getImage().getScaledInstance(Config.screenWidth, Config.screenHeight, java.awt.Image.SCALE_SMOOTH);
    public static final int enemyHeight = 100; //even number
    public static final int enemyWidth = 100; //even number
    public static final int arrowHeight = 100; //even number
    public static final int arrowWidth = 100; //even number
    public static final int avatarHeight = 100;
    public static final int avatarWidth = 100;
}
