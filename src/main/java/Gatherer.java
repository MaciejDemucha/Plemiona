
public class Gatherer extends Human {

    private int LiftingCapacity;
    private int gatheringResourceIndex;

    public void gather() {
        target.takeDamage(10);
        tribe.addResources(target.checkDropAmount()*itemLevel, gatheringResourceIndex );
        System.out.println("GATHERED " + target.checkDropAmount() + " RESOURCE INDEX " + gatheringResourceIndex);
        if (target.isAlive()) {
            target = null;
        }
    }

    public Gatherer(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, Tribe tribe) {
        super(tribe);
        //DO ZMIANY
        this.LiftingCapacity = 10;

        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;

    }

    @Override
    public void findTarget(Objects[] table) {
        int lowestDistance = 100;
        int distance;
        int index = 0;
        for (int i = 0; i < table.length; i++) {
            targetLocation = table[i].checkLocation();
            distance = Math.abs(targetLocation[0] - positionX) + Math.abs(targetLocation[1] - positionY);
            if (distance < lowestDistance && table[i].isAlive()) {
                lowestDistance = distance;
                index = i;

            }
            target = table[i];
        }

    }

    public Objects[] choseResource(int[] resources, Objects[] rock, Objects[] iron, Objects[] wood, Objects[] food) {

        int lowestAmount = tribe.checkResources(gatheringResourceIndex);
        int lowestAmountIndex = gatheringResourceIndex;
        if (target != null) {
            for (int i = 0; i < 4; i++) {
                if (resources[i] < lowestAmount) {
                    lowestAmount = resources[i];
                    lowestAmountIndex = i;
                }
            }
        }
        if (lowestAmountIndex == 0) {
            gatheringResourceIndex = 0;
            return rock;
        } else if (lowestAmountIndex == 1) {
            gatheringResourceIndex = 1;
            return iron;
        } else if (lowestAmountIndex == 2) {
            gatheringResourceIndex = 2;
            return wood;
        } else if (lowestAmountIndex == 3) {
            gatheringResourceIndex = 3;
            return food;
        }
        return null;

    }

    public void doAction(Objects[] table, Objects[][] mapItems) {
        if (isAlive) {
            if (target != null) {
                if (target.isAlive()) {
                    targetLocation = target.checkLocation();
                    if (isInRange(positionX, positionY, targetLocation[0], targetLocation[1])) {
                        gather();
                    } else {
                        moveToTarget(mapItems, targetLocation[0], targetLocation[1]);
                    }
                } else {
                    findTarget(table);
                }
            } else if (target == null) {
                System.out.println("ZNALAZŁ CEL");
                findTarget(table);
            }
            if (hungerPoints < 100) {
                eat();
            }
            hungerPoints--;
            if (hungerPoints < 1) {
                takeDamage(1);
            }
            upgradeTool();
        }
    }
}
