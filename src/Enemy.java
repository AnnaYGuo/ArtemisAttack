import java.awt.image.BufferedImage;

public class Enemy implements Sprite{
    private Game game;
    private int x;
    private int y;
    private int speed;

    /**Enemy constructor: randomly generates off-screen enemy*/
    Enemy(Game game){
        this.game = game;
        //up/down v left/right
        if((int)(Math.random()*2) == 1){
            //up/down
            x = (int) (Math.random() * Config.screenWidth);

            if((int)(Math.random()*2) == 1){
                //up
                y =  - Config.enemyHeight/2;
            }
            //down
            y = Config.screenHeight + Config.enemyHeight/2;
        }
        else{
            //left/right
            y = (int) (Math.random() * Config.screenHeight);
            if((int)(Math.random()*2) == 1){
                //left
                x = - Config.enemyWidth/2;
            }
            //right
            x = Config.screenWidth + Config.enemyWidth/2;
        }
    }

    public BufferedImage print(){
        return Config.enemyImageSheet; //TODO
    }
    /**Update enemy position, check if within circle*/
    public void update(int targetX, int targetY){
        double yTemp = targetY - y;
        double xTemp = targetX - x;
        double denominator = Math.sqrt(xTemp*xTemp + yTemp*yTemp);
        y = (int) (y + yTemp*Config.unit/denominator);
        x = (int) (x + xTemp*Config.unit/denominator);
    }
    public void death(){
        //TODO
    }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public int getWidth(){ return Config.enemyWidth; }
    public int getHeight(){ return Config.enemyHeight; }
}
