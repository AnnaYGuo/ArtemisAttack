import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Arrow extends JPanel implements Sprite{
    private Game game;
    private int x;
    private int y;
    private int dir; //0: left, 1: up, 2: right, 3: down

    private BufferedImage test = Config.enemyImageSheet.getSubimage(0, 0, 10, 10);

    /**Arrow constructor: initialize variables, call update once*/
    Arrow(Game game, int x, int y, int dir){
        this.game = game;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public BufferedImage print(){
        return Config.enemyImageSheet; //TODO
    }
    public boolean isOffScreen() {
        if(x < 0 || x > Config.screenWidth || y < 0 || y > Config.screenHeight){
            return true;
        }
        //game.getArrows().remove(this);
        return false;
    }
    private boolean collideEnemy(){
        for(Enemy enemy : game.getEnemies()){
            int eLeft = enemy.getX() - Config.enemyWidth/2;
            int eUp = enemy.getY() - Config.enemyHeight/2;
            int eRight = enemy.getX() + Config.enemyWidth/2;
            int eDown = enemy.getY() + Config.enemyHeight/2;

            int aLeft = x - Config.arrowWidth/2;
            int aUp = y - Config.arrowHeight/2;
            int aRight = x + Config.arrowWidth/2;
            int aDown = y + Config.arrowHeight/2;
            if(((aLeft >= eLeft && aLeft <= eRight) || (aRight >= eLeft && aRight <= eRight))
                && (aUp >= eUp && aUp <= eDown) || (aDown >= eUp && aDown <= eDown)){
                enemy.death();
                game.getEnemies().remove(enemy);
                return true;
            }
        }
        return false; //TEMP
    }
    /**Update arrow position, check collisions, check off-screen*/
    public boolean update(){
        //update collisions
        if(dir == 0){ x -= Config.unit; }
        if(dir == 1){ y -= Config.unit; }
        if(dir == 2){ x += Config.unit; }
        if(dir == 3){ y += Config.unit; }

        //erase and then print
        if(!collideEnemy()){
            repaint();
        }
        else{
            //TODO: potential erase screen function
            return true;
        }
        //repaint();

        return false;
    }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public int getWidth(){ return Config.arrowWidth; }
    public int getHeight(){ return Config.arrowHeight; }

    protected void paintComponent(Graphics g) {
        //System.out.println("WHERE");
        super.paintComponent(g);
        this.setBounds(x, y, 10, 10);

        Graphics2D g2 = (Graphics2D) g;
        //g2.drawImage(test, 0, 0, game.getFrame());
        g2.setColor(Color.white);
        g2.drawRect(x, y, 10, 10);
        g2.dispose();
    }
}
