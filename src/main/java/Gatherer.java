
public class Gatherer extends Human {

    private int LiftingCapacity;
    private int gatheringResourceIndex;

    public void gather() {

    }

    public Gatherer(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, int tribeIndex) {
        //DO ZMIANY
        this.LiftingCapacity = 10;

        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;
        this.tribeIndex = tribeIndex;

    }

    @Override
    public int findTargetIndex(int[][] table) {
        int lowestDistance = 100;
        int distance;
        int index = 0;
        for (int i = 0; i < table[0].length; i++) {
            distance = Math.abs(table[i][0] - positionX) + Math.abs(table[i][1] - positionY);
            if (distance < lowestDistance) {
                lowestDistance = distance;
                index = i;
            }

        }
        return index;
    }

    public int[][] choseResourceIndex(int[] resources, int[][] rock, int[][] iron, int[][] wood, int[][] food) {

        int lowestAmount = 101;
        int lowestAmountIndex = gatheringResourceIndex;
        if (targetIndex!=101) {
            for (int i = 0; i < 4; i++) {
                if (resources[i] < lowestAmount) {
                    lowestAmount = resources[i];
                    lowestAmountIndex = i;
                }
            }
        }
        if (lowestAmountIndex == 0) {
            return rock;
        } else if (lowestAmountIndex == 1) {
            return iron;
        } else if (lowestAmountIndex == 2) {
            return wood;
        } else if (lowestAmountIndex == 3) {
            return food;
        }
        return null;

    }

    public void doAction(int[][] table) {
        if (targetIndex != 101) {
            if (isInRange(positionX, positionY, table[targetIndex][0], table[targetIndex][1])) {
                gather();
                targetIndex=101;
            } else {
                moveToTarget();
            }
        } else if (hungerPoints < 6) {
            eat();
        } else if (targetIndex==101){
            findTargetIndex(table);
        }
    }
}
