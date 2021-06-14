
public class Warrior extends Human {

    private int strenght;

    public void attack() {
        //System.out.println("WARRIOR ATTACKED");
        target.takeDamage(strenght);
        if (!target.isAlive) {
            tribe.addResources(target.checkDropAmount(), 3);
            //System.out.println("WARRIOR KILLED GATHER: "+target.checkDropAmount());
        }
        this.target = null;
    }

    public Warrior(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, Tribe tribe, int strenght) {
        super(tribe);
        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;
        this.strenght = strenght;

    }

    @Override
    public void findTarget(Objects[] table) {
        int lowestDistance = 100;
        int distance;
        int index = 0;
        for (int i = 0; i < 5; i++) {
            targetLocation = table[i].checkLocation();
            distance = Math.abs(targetLocation[0] - positionX) + Math.abs(targetLocation[1] - positionY);
            if (distance < lowestDistance && table[i].isAlive()) {
                lowestDistance = distance;
                index = i;
            }

        }
        this.target = table[index];
    }

    @Override
    public void doAction(Objects[] table, Objects[][] mapItems) {
        if (isAlive) {
            if (target != null) {
                if (target.isAlive()) {
                    targetLocation = target.checkLocation();
                    if (isInRange(positionX, positionY, targetLocation[0], targetLocation[1])) {
                        attack();
                    } else {
                        moveToTarget(mapItems, targetLocation[0], targetLocation[1]);
                    }
                } else {
                    findTarget(table);
                }
            } else if (target == null) {
                findTarget(table);
                //System.out.println("Warrior found target ");
            }
            if(hungerPoints<100){
                eat();
            }
            this.hungerPoints--;
            if (hungerPoints < 1) {
                this.takeDamage(1);
            }
        }
    }

}
