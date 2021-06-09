
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

    private int[][] herbivorousList = new int[5][2];
    private int[][] carnivorceList = new int[5][2];
    private int[][] plantList = new int[5][2];
    private int[][] treeList = new int[5][2];
    private int[][] rockList = new int[2][2];
    private int[][] ironList = new int[2][2];
    private int[][] humanList = new int[10][2];

    public void refresh() {
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
        while (!isEmpty(x, y) && x != 101) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        //ROCK MA MIEĆ USTALONE HP I DROPAMOUNT - DO ZMIANY
        mapItems[x][y] = new Rock(x, y, 10, resourceIndex, 10);
        if (resourceIndex == 0) {
            inputToTable(x, y, rockList);
        } else {
            inputToTable(x, y, ironList);
        }

    }

    private void createPlant(int resourceIndex, int regrowTime) {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y) && x != 101) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Plant(x, y, random.randomizeHealthPoints(), resourceIndex, random.randomizeDropAmount(), regrowTime);
        if (resourceIndex == 2) {
            inputToTable(x, y, treeList);
        } else {
            inputToTable(x, y, plantList);
        }
    }

    private void createCarnivorous() {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y) && x != 101) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Carnivorous(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), random.randomizeStrenght());
        inputToTable(x, y, carnivorceList);
    }

    private void createHerbivorous() {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y) && x != 101) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Herbivorous(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), random.randomizePerception());
        inputToTable(x, y, herbivorousList);
    }

    private void createWarrior(int tribeIndex) {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y) && x != 101) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Warrior(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), tribeIndex, random.randomizeStrenght());
        inputToTable(x, y, humanList);
    }

    private void createGatherer(int tribeIndex) {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y) && x != 101) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Gatherer(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), tribeIndex);
        inputToTable(x, y, humanList);
    }

    public Map(Randomizer random) {
        this.random = random;
        for (int i = 0; i < 5; i++) {
            herbivorousList[i][0] = 101;
            carnivorceList[i][0] = 101;
            plantList[i][0] = 101;
            treeList[i][0] = 101;
        }
        for (int i = 0; i < 2; i++) {
            rockList[i][0] = 101;
            ironList[i][0] = 101;
        }
        for (int i = 0; i < 10; i++) {
            humanList[i][0] = 101;
        }
    }

    private void inputToTable(int x, int y, int[][] table) {
        int i = 0;
        while (table[i][0] != 101) {
            i++;
        }
        table[i][0] = x;
        table[i][1] = y;
    }

}
