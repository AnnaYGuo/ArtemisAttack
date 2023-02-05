import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean[] signal;
    public int dir;

    KeyHandler(){
        signal = new boolean[5];
        dir = 0;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        //intentionally empty for now
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("PRESS");
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
        /*int code = e.getKeyCode();
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
        }*/
        signal[4] = false;
    }
}
