public class Enemy {
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
            x = (int) (Math.random() * Config.rightBound);

            if((int)(Math.random()*2) == 1){
                //up
                y = Config.upperBound - Config.enemyHeight/2;
            }
            //down
            y = Config.lowerBound + Config.enemyHeight/2;
        }
        else{
            //left/right
            y = (int) (Math.random() * Config.lowerBound);
            if((int)(Math.random()*2) == 1){
                //left
                x = Config.leftBound - Config.enemyWidth/2;
            }
            //right
            x = Config.rightBound + Config.enemyWidth/2;
        }
    }

    private void print(){

    }
    /**Update enemy position, check if within circle*/
    public void update(int targetX, int targetY){

    }
    public void death(){
        //TODO
    }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
}
