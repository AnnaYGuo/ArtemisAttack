import java.awt.image.BufferedImage;

public class Arrow implements Sprite{
    private Game game;
    private int x;
    private int y;
    private int dir; //0: left, 1: up, 2: right, 3: down

    /**Arrow constructor: initialize variables, call update once*/
    Arrow(Game game, int x, int y, int dir){
        this.game = game;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public BufferedImage print(){
        return Config.enemyImageSheet; //TODO
    }
    private boolean isOffScreen(){
        return false; //TEMP
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
                return true;
            }
        }
        return false; //TEMP
    }
    /**Update arrow position, check collisions, check off-screen*/
    public void update(){
        //update collisions
        if(dir == 0){ x -= Config.unit; }
        if(dir == 1){ y -= Config.unit; }
        if(dir == 2){ x -= Config.unit; }
        if(dir == 3){ y += Config.unit; }

        //erase and then print
        if(!collideEnemy()){
            print();
        }
        else{
            //TODO: potential erase screen function
            game.getArrows().remove(this);
        }
    }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public int getWidth(){ return Config.arrowWidth; }
    public int getHeight(){ return Config.arrowHeight; }
}
