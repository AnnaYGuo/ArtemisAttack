import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
public class Game {
    private JFrame frame;
    private Avatar avatar;
    private LinkedList<Arrow> arrows;
    private LinkedList<Enemy> enemies;

    private static final Image image = (new ImageIcon("map.png")).getImage().getScaledInstance(Config.screenWidth, Config.screenHeight, java.awt.Image.SCALE_SMOOTH);
    private void addBackground(Sprite sprite, BufferedImage image){
        BufferedImage background = image.getSubimage(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

    }
    private void update(){
        avatar.update();
        for(Arrow arrow: arrows){
            arrow.update();
        }
        for(Enemy enemy: enemies){
            enemy.update(Config.centerX, Config.centerY);
        }
    }

    public void start(JFrame frame){
        this.frame = frame;
        avatar = new Avatar(this);
        arrows = new LinkedList<>();
        enemies = new LinkedList<>();
    }

    public LinkedList<Arrow> getArrows(){ return arrows; }
    public LinkedList<Enemy> getEnemies(){ return enemies; }
}
