import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Avatar extends JPanel implements Sprite{
    private Game game;
    private int x;
    private int y;
    private int dir; //0: left, 1: up, 2: right, 3: down
    private boolean[] signal = new boolean[5]; //last index = shoot
    private KeyHandler keyHandler;
    private int arrow = 0;

    private final Image test = (ImageIO.read(new File("mc.png"))).getScaledInstance(128, 128, Image.SCALE_SMOOTH);
    private final Image flip = (ImageIO.read(new File("mcflip.png"))).getScaledInstance(128, 128, Image.SCALE_SMOOTH);

    /**Avatar constructor, initialize to center*/
    Avatar(Game game) throws IOException {
        keyHandler = new KeyHandler();
        this.x = Config.centerX - 64;
        this.y = Config.centerY - 64;
        this.dir = 0;
        this.game = game;
        this.keyHandler = keyHandler;
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHandler);

    }
    public BufferedImage print(){
        BufferedImage test = Config.enemyImageSheet.getSubimage(0, 0, 32, 32);
        return test;
    }
    /**parse input commands, move avatar, create arrows if needed*/
    public void update(){
        signal = keyHandler.signal;
        dir = keyHandler.dir;
        if(signal[0]){ x -= Config.unit; keyHandler.signal[0] = false; }
        if(signal[1]){ y -= Config.unit; keyHandler.signal[1] = false; }
        if(signal[2]){ x += Config.unit; keyHandler.signal[2] = false; }
        if(signal[3]){ y += Config.unit; keyHandler.signal[3] = false; }
        if(signal[4]) {

            //System.out.println(game.getArrows().size());

            int tempX = x;
            int tempY = y;
            if(dir == 0){ tempX -=15; tempY += 57; }
            else if(dir == 1){ tempX += 57; tempY -= 15; }
            else if(dir == 2){ tempX += 133; tempY += 57; }
            else if(dir == 3){ tempX += 57; tempY += 133; }
            Arrow addArrow = new Arrow(game, tempX, tempY, dir);
            game.getArrows().add(addArrow);
            addArrow.setOpaque(true);
            addArrow.setBounds(tempX, tempY, 10, 10);
            game.getLayer().add(addArrow, 3 + ((arrow++)%20));

            addArrow.update();
            //keyHandler.signal[4] = false;
        }
        repaint();
    }

    public boolean[] getSignal(){ return signal; }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public int getWidth(){ return Config.avatarWidth; }
    public int getHeight(){ return Config.avatarHeight; }
    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //System.out.println("HI");
        //g.clearRect(x, y, 128, 128);
        this.setBounds(x, y, 128, 128);
        Graphics2D g2 = (Graphics2D) g;
        if(dir == 0){
            g2.drawImage(flip, 0, 0, this);
        }
        else{
            g2.drawImage(test, 0, 0, this);
        }
        g2.dispose();
    }

    public KeyHandler getKeyHandler(){ return keyHandler; }

}
