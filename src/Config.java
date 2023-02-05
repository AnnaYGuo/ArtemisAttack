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
    public static final int eUnit = 1;
    public static final Image backgroundImage = (new ImageIcon("map.png")).getImage().getScaledInstance(Config.screenWidth, Config.screenHeight, java.awt.Image.SCALE_SMOOTH);
    public static final BufferedImage enemyImageSheet;
    static {
        try {
            enemyImageSheet = ImageIO.read(new File("enemy.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Image[] death = {
        Config.enemyImageSheet.getSubimage(32*0, 32*3, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH),
        Config.enemyImageSheet.getSubimage(32*1, 32*3, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH),
        Config.enemyImageSheet.getSubimage(32*2, 32*3, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH),
        Config.enemyImageSheet.getSubimage(32*3, 32*3, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH),
        Config.enemyImageSheet.getSubimage(32*4, 32*3, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH),
        Config.enemyImageSheet.getSubimage(32*5, 32*3, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH),
        Config.enemyImageSheet.getSubimage(32*6, 32*3, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH),
        Config.enemyImageSheet.getSubimage(32*7, 32*3, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH),
        Config.enemyImageSheet.getSubimage(32*8, 32*3, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH)
    };
    //(new ImageIcon("enemy.png")).getImage().getScaledInstance(Config.screenWidth, Config.screenHeight, java.awt.Image.SCALE_SMOOTH);
    public static final int enemyHeight = 128; //even number
    public static final int enemyWidth = 128; //even number
    public static final int arrowHeight = 10; //even number
    public static final int arrowWidth = 10; //even number
    public static final int avatarHeight = 128;
    public static final int avatarWidth = 128;
}
