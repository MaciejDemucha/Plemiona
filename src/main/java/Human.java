
abstract class Human extends Creature{
    protected int itemLevel;
    protected int tribeIndex;
    
    protected void eat(int[] resources){
        this.hungerPoints+=5;
        resources[3]-=5;
    }
}
