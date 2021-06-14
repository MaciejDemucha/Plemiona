
public class Plant extends Objects {

    private int regrowTime;

    public Plant(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, int regrowTime) {
        super();
        this.regrowTime = regrowTime;
        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;

    }

    protected void regrow() {
        if (isAlive && regrowTime < 1) {
            this.isAlive = true;
            this.healthPoints = 10;

        }

    }

}
