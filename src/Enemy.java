public class Enemy {
    private int x;
    private int y;
    private int speed;

    /**Enemy constructor: randomly generates off-screen enemy*/
    Enemy(){
    }

    /**Update enemy position, check if within circle*/
    public void update(int targetX, int targetY){

    }
    private void death(){

    }
    private boolean isHit(){
        return false; //TEMP
    }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
}
