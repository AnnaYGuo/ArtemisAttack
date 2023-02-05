import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends JPanel implements Sprite{
    private Game game;
    private int x;
    private int y;
    private int speed;
    private Image test = Config.enemyImageSheet.getSubimage(0, 0, 32, 32).getScaledInstance(128, 128, Image.SCALE_SMOOTH);

    private boolean dead = false;
    private int deadInt;
    /**Enemy constructor: randomly generates off-screen enemy*/
    Enemy(Game game){
        this.game = game;
        //up/down v left/right
        if((Math.random()*2) >= 1){
            //up/down
            x = (int) (Math.random() * Config.screenWidth);

            if((Math.random()*2) >= 1){
                //up
                y =  - Config.enemyHeight/2;
            }
            //down
            y = Config.screenHeight + Config.enemyHeight/2;
        }
        else{
            //left/right
            y = (int) Math.round(Math.random() * Config.screenHeight);
            if((Math.random()*2) >= 1){
                //left
                x = - Config.enemyWidth/2;
            }
            //right
            x = Config.screenWidth + Config.enemyWidth/2;
        }
        //System.out.println(x +", " + y);
    }

    public BufferedImage print(){
        BufferedImage test = Config.enemyImageSheet.getSubimage(0, 0, 32, 32);
        return test;
    }
    /**Update enemy position, check if within circle*/
    public void update(int targetX, int targetY){
        double yTemp = targetY - y;
        double xTemp = targetX - x;
        double denominator = Math.sqrt(xTemp*xTemp + yTemp*yTemp);
        y = (int) (y + yTemp*Config.eUnit/denominator);
        x = (int) (x + xTemp*Config.eUnit/denominator);
        if(x == 0 && y == 0){
            x = targetX;
            y = targetY;
        }
        repaint();
    }
    public void death(){
        //TODO
        dead = true;
        for(int deadInt = 0; deadInt < 9; deadInt++){;
            repaint();
            //g.drawImage(test, 0, 0, game.getFrame());
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        //super.paintComponent(this.getGraphics());
    }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public int getWidth(){ return Config.enemyWidth; }
    public int getHeight(){ return Config.enemyHeight; }

    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //g =this.getComponentGraphics(g);
        g.clearRect(x, y, 128, 128);

        this.setBounds(x, y, 128, 128);
        if(dead){
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(Config.death[deadInt], 0, 0, game.getFrame());
            g2.dispose();
            System.out.println("loopDEATH");
        }
        else {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(Config.death[5], 0, 0, game.getFrame());
            g2.dispose();
        }
    }
}
