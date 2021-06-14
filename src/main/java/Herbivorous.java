
import java.lang.Math;

public class Herbivorous extends Creature {
    
    @Override
    public void eat() {
        this.hungerPoints += target.checkDropAmount();
        target.takeDamage(10);
        
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
    
    public Herbivorous(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, int perception) {
        super();
        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;
        
    }
    
    @Override
    public void doAction(Objects[] table, Objects[][] mapItems) {
        if (isAlive) {
            if (target != null) {
                if (target.isAlive()) {
                    targetLocation = target.checkLocation();
                    if (isInRange(positionX, positionY, targetLocation[0], targetLocation[1])) {
                        eat();
                    } else {
                        moveToTarget(mapItems, targetLocation[0], targetLocation[1]);
                    }
                } else {
                    findTarget(table);
                }
            } else if (target == null && hungerPoints < 200) {
                findTarget(table);
            }
            hungerPoints--;
            if (hungerPoints < 1) {
                takeDamage(1);
            }
        }
    }
    
}
