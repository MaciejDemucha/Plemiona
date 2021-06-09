
public class Carnivorous extends Creature {

    private int strenght;

    public void attack() {

    }

    public Carnivorous(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, int strenght) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;
        this.strenght = strenght;
        this.targetIndex = 101;

    }

    @Override
    public void eat() {

    }

    @Override
    public int findTargetIndex(int[][] table) {
        int lowestDistance = 100;
        int distance;
        int index = 0;
        for (int i = 0; i < 5; i++) {
            distance = Math.abs(table[i][0] - positionX) + Math.abs(table[i][1] - positionY);
            if (distance < lowestDistance) {
                lowestDistance = distance;
                index = i;
            }

        }
        return index;
    }

    @Override
    public void doAction(int[][] table) {
        if(targetIndex!=101){
            if(isInRange(positionX,positionY,table[targetIndex][0],table[targetIndex][1])){
                attack();
            }else{
                moveToTarget();
            }
        }else if(targetIndex==101 && hungerPoints<6){
            findTargetIndex(table);
        }
    }
}
