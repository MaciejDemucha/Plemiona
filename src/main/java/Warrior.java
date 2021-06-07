public class Warrior extends Human{
    private int strenght;
    
    public void attack(){
        
    }
    public Warrior(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, int tribeIndex, int strenght){
        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;
        this.strenght = strenght;
        this.tribeIndex = tribeIndex;
        
    }
}
