
import java.util.Random;

/*RESOURCE INDEX
0 - STONE;
1 - IRON;
2 - WOOD;
3 - MEAT;
4 - PLANT;
 */
public class Map {

    private Objects[][] mapItems;
    private Tribe[] tribeList;
    private Randomizer random;

    public void refresh() {
        
        

        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
               if(mapItems[i][j] instanceof Creature){
                   //System.out.print(mapItems[i][j].getClass().toString()+" ");
                   mapItems[i][j].findTarget();
                
                }
            }
        }
  
    }

    public void createObjects() {
        
        mapItems = new Objects[100][100];
        
        //mapItems[1][1] = new Carnivorous(1, 1, 10, 3, 10, 10);
        
        

        createRock(0);
        createRock(0);
        createRock(1);
        createRock(1);

        for (int i = 0; i < 5; i++) {
            createPlant(2, 10);
            createPlant(4, 5);
            createCarnivorous();
            createHerbivorous();
        }

        for (int i = 0; i < 3; i++) {
            createGatherer(0);
            createGatherer(1);
        }

        for (int i = 0; i < 2; i++) {
            createWarrior(0);
            createWarrior(1);
        }

    }

    public boolean isEmpty(int x, int y) {
        if (mapItems[x][y] == null) {
            return true;
        } else {
            return false;
        }
    }

    private void createRock(int resourceIndex) {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y)) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        //ROCK MA MIEĆ USTALONE HP I DROPAMOUNT - DO ZMIANY
        mapItems[x][y] = new Rock(x, y, 10, resourceIndex, 10);
    }

    private void createPlant(int resourceIndex, int regrowTime) {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y)) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Plant(x, y, random.randomizeHealthPoints(), resourceIndex, random.randomizeDropAmount(), regrowTime);
    }

    private void createCarnivorous() {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y)) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Carnivorous(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), random.randomizeStrenght());
    }

    private void createHerbivorous() {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y)) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Herbivorous(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), random.randomizePerception());
    }

    private void createWarrior(int tribeIndex) {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y)) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Warrior(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), tribeIndex, random.randomizeStrenght());
    }

    private void createGatherer(int tribeIndex) {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y)) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Gatherer(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), tribeIndex);
    }
    public Map(Randomizer random){
        this.random = random;
    }

}
