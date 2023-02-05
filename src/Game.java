import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Game extends JPanel implements Runnable{
    private JLayeredPane layer;
    private JFrame frame;
    private Thread cry;
    private Avatar avatar;
    private LinkedList<Arrow> arrows;
    private LinkedList<Enemy> enemies;

    Game(){
        //KeyHandler keyHandler = new KeyHandler();
        //this.addKeyListener(keyHandler);
        avatar = new Avatar(this);
        arrows = new LinkedList<>();
        enemies = new LinkedList<>();

        this.setDoubleBuffered(true);
        this.setFocusable(true);

        //avatar.setOpaque(true);
        //avatar.setBounds(Config.centerX, Config.centerY, 32, 32);
    }
    private void addBackground(Sprite sprite, BufferedImage image){

        BufferedImage background = image.getSubimage(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

    }
    private void update(){
        //layer.moveToFront(avatar);
        avatar.update();
        for(Arrow arrow: arrows){
            //System.out.println("ARROWS");
            if(arrow.update() || arrow.isOffScreen()){
                arrows.remove(arrow);
                break;
            }
        }
        for(Enemy enemy: enemies){
            enemy.update(Config.centerX - 64, Config.centerY - 64);
        }
    }
    private void reprint(){
        avatar.repaint();
        for(Arrow arrow: arrows){
            //System.out.println("ARROWS");
            if(!arrow.isOffScreen() && !arrow.update()) {
                arrow.repaint();
            }
            else{
                arrows.remove(arrow);
                break;
            }
        }
        for(Enemy enemy: enemies){
            enemy.repaint();
        }
    }
    public void start(JLayeredPane layer, JFrame frame){
        this.layer = layer;
        this.frame = frame;
        //layer.add(avatar, 2);
        /*JPanel avatarPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                //super.paintComponent(g);
                g.drawImage(avatar.print(), avatar.getX(), avatar.getY(), frame);
            }
        };

        avatarPanel.addKeyListener(avatar);
        frame.add(avatarPanel);*/
        //frame.setVisible(true);
        ;
        //Timer t = new Timer(50, null);
        //t.start();
        //frame.setVisible(true);
        //frame.requestFocusInWindow();

        cry = new Thread(this);
        cry.start();
    }


    public LinkedList<Arrow> getArrows(){ return arrows; }
    public LinkedList<Enemy> getEnemies(){ return enemies; }
    /*private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            avatar.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            avatar.keyPressed(e);
        }
    }*/
    public void run(){
        double printTime = 1000000000/240; //FPS
        double nextTime = System.nanoTime() + printTime;
        int count = 0;
        int time = 0;
        boolean wait = false;
        //long lastTime = System.nanoTime();
        while(cry != null){
            // try{
                //System.out.println(avatar.getX() + ", " + avatar.getY());
                /*long temp = System.nanoTime();
                if(temp - lastTime > (long) 100){
                    lastTime = temp;
                    update();
                }*/
                update();
                //repaint();
                try{
                    double sleepTime = (nextTime - System.nanoTime())/1000000;
                    if(time > 1000 && !wait){
                        Enemy e = new Enemy(this);
                        enemies.add(e);
                        e.setOpaque(true);
                        e.setBounds(e.getX(), e.getY(), 128, 128);
                        this.getLayer().add(e, 25 + ((count++)%20));
                        time = 0;
                        wait = true;
                    }
                    if(sleepTime > 0){ Thread.sleep((long) sleepTime); }

                    nextTime = System.nanoTime() + printTime;
                    time++;

                }
                catch(Exception e){
                    System.out.println(e);
                }
                //avatar.update();
                //repaint();
       //         Thread.sleep(0,1);
                //avatar.print();
            /*}
            catch(InterruptedException e){
                System.out.println(e);
            }*/
        }
    }
    /*

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBounds(avatar.getX(), avatar.getY(), 32, 32);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(avatar.print(), 0, 0, frame);
        g2.dispose();
    }
*/
    public JFrame getFrame(){ return frame; }
    public Avatar getAvatar(){ return avatar; }
    public JLayeredPane getLayer(){ return layer; }
}
