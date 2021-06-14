
public class Carnivorous extends Creature {
    
    private int strenght;
    
    public void attack() {
        target.takeDamage(strenght);
        if (!target.isAlive) {
            eat();
        }
        this.target = null;
    }
    
    public Carnivorous(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, int strenght) {
        super();
        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;
        this.strenght = strenght;
        this.target = null;
        
    }
    
    @Override
    public void eat() {
        this.hungerPoints += target.checkDropAmount();
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
            } else if (target == null && hungerPoints < 300) {
                findTarget(table);
            }
            hungerPoints--;
            if (hungerPoints < 1) {
                takeDamage(1);
            }
        }
    }
}
