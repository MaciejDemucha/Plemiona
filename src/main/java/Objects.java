
abstract class Objects {

    protected int positionX;
    protected int positionY;
    protected int healthPoints;
    protected int resourceIndex;
    protected int dropAmount;
    protected boolean isAlive;

    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints < 0) {
            this.isAlive = false;
            this.positionX = 101;
            this.positionY = 101;
        }
    }

    public int[] checkLocation() {

        int[] location = new int[2];
        location[0] = positionX;
        location[1] = positionY;

        return location;
    }
    public int checkDropAmount(){
        return dropAmount;
    }
    public boolean isAlive(){
        return isAlive;
    }
    public Objects() {
        this.isAlive = true;
        
    }
}
