import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
public class Game implements KeyListener {
    private JFrame frame;
    private Avatar avatar;
    private LinkedList<Arrow> arrows;
    private LinkedList<Enemy> enemies;
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

        avatar.update();
        JPanel jPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                //super.paintComponent(g);
                g.drawImage(avatar.print(), avatar.getX(), avatar.getY(), frame);
            }
        };
        frame.add(jPanel);
        frame.setVisible(true);
        while(true){
            avatar.update();
            //avatar.print();
            System.out.println(avatar.getX() + ", " + avatar.getY());
        }
    }


    public LinkedList<Arrow> getArrows(){ return arrows; }
    public LinkedList<Enemy> getEnemies(){ return enemies; }

    @Override
    public void keyTyped(KeyEvent e) {
        avatar.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        avatar.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        avatar.keyReleased(e);
    }
}
