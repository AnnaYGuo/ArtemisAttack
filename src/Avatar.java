import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Avatar implements KeyListener {
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
    private void print(){

    }
    /**parse input commands, move avatar, create arrows if needed*/
    public void update(){
        if(signal[0]){ x -= Config.unit; }
        if(signal[1]){ y -= Config.unit; }
        if(signal[2]){ x -= Config.unit; }
        if(signal[3]){ y += Config.unit; }
        if(signal[4]){
            Arrow addArrow = new Arrow(game, x, y, dir);
        } //TODO: wait for game file to call LL, then add
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //intentionally empty for now
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_LEFT:
                signal[0] = true;
                break;
            case KeyEvent.VK_UP:
                signal[1] = true;
                break;
            case KeyEvent.VK_RIGHT:
                signal[2] = true;
                break;
            case KeyEvent.VK_DOWN:
                signal[3] = true;
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
}
