public class Gatherer extends Human{
    private int LiftingCapacity;
    
    public void gather(){
    
    }
   public Gatherer(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount,int tribeIndex){
       //DO ZMIANY
        this.LiftingCapacity = 10;
        
        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;
        this.tribeIndex = tribeIndex;
        
    }
}
