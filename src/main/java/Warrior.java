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
    public int findTargetIndex(int[][] table){
        int lowestDistance = 100;
        int distance;
        int index = 0;
        for(int i = 0;i<5;i++){
           distance = Math.abs(table[i][0]-positionX)+ Math.abs(table[i][1]-positionY);
           if(distance<lowestDistance){
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
        }else if(hungerPoints<6){
            eat();
        }else if(targetIndex==101){
            findTargetIndex(table);
        }
    }
    
}
