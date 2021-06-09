
abstract class Creature extends Objects {

    protected int hungerPoints;
    protected int movementSpeed;
    protected int respawnTime;
    protected int targetIndex;

    abstract int findTargetIndex(int[][] table);

    //abstract void eat();

    abstract void doAction(int[][] table);

    public void moveToTarget() {

    }

    protected boolean isInRange(int x, int y, int objectX, int objectY) {
        return Math.abs(objectX - x) + Math.abs(objectY - y) == 1;
    }
}
