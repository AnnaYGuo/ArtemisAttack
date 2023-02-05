import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Avatar implements KeyListener, Sprite {
    private Game game;
    private int x;
    private int y;
    private int dir; //0: left, 1: up, 2: right, 3: down
    private boolean[] signal = new boolean[5]; //last index = shoot

    /**Avatar constructor, initialize to center*/
    Avatar(Game game){
        this.x = Config.centerX;
        this.y = Config.centerY;
        this.dir = 0;
        this.game = game;
    }
    public BufferedImage print(){
        BufferedImage test = Config.enemyImageSheet.getSubimage(0, 0, 32, 32);
        return test;
    }
    /**parse input commands, move avatar, create arrows if needed*/
    public void update(){
        if(signal[0]){ x -= Config.unit; }
        if(signal[1]){ y -= Config.unit; }
        if(signal[2]){ x -= Config.unit; }
        if(signal[3]){ y += Config.unit; }
        if(signal[4]) {
            Arrow addArrow = new Arrow(game, x, y, dir);
            game.getArrows().add(addArrow);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //intentionally empty for now
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("PRESS");
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_LEFT:
                signal[0] = true;
                dir = 0;
                break;
            case KeyEvent.VK_UP:
                signal[1] = true;
                dir = 1;
                break;
            case KeyEvent.VK_RIGHT:
                signal[2] = true;
                dir = 2;
                break;
            case KeyEvent.VK_DOWN:
                signal[3] = true;
                dir = 3;
                break;
            case KeyEvent.VK_SPACE:
                signal[4] = true;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_LEFT:
                signal[0] = false;
                break;
            case KeyEvent.VK_UP:
                signal[1] = false;
                break;
            case KeyEvent.VK_RIGHT:
                signal[2] = false;
                break;
            case KeyEvent.VK_DOWN:
                signal[3] = false;
                break;
            case KeyEvent.VK_SPACE:
                signal[4] = false;
            default:
                break;
        }
    }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public int getWidth(){ return Config.avatarWidth; }
    public int getHeight(){ return Config.avatarHeight; }
}
