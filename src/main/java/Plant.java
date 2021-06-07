public class Plant extends Objects{
    private int regrowTime;
    
    public Plant(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, int regrowTime){
        this.regrowTime = regrowTime;
        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;
        
    }
}
