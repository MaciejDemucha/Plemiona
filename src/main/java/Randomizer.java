import java.util.Random;

public class Randomizer {
    
    private int mapSize;
    private int maxHealthPoints;
    private int maxDropAmount;
    private int maxStrenght;
    private int maxPerception;
    
    private  Random rand;
    
    
    public int randomizeLocation(){
        int randomLocation = rand.nextInt(mapSize);
        return randomLocation;
    }
    public int randomizeHealthPoints(){
        int HealthPoints = rand.nextInt(maxHealthPoints);
        return HealthPoints;
    }
    public int randomizeDropAmount(){
        int DropAmount = rand.nextInt(maxDropAmount);
        return DropAmount;
    }
    public int randomizeStrenght(){
        int strenght = rand.nextInt(maxStrenght);
        return strenght;
    }
    public int randomizePerception(){
        int perception = rand.nextInt(maxPerception);
        return perception;
    }
    public Randomizer(int mapSize, int maxHealthPoints, int maxDropAmount, int maxStrenght, int maxPerception){
        
        this.rand =  new Random();
        this.mapSize = mapSize;
        this.maxHealthPoints = maxHealthPoints;
        this.maxDropAmount = maxDropAmount;
        this.maxStrenght = maxStrenght;
        this.maxPerception = maxPerception;
    }
}
