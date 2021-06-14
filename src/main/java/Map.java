/*import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
*/
/*RESOURCE INDEX
0 - STONE;
1 - IRON;
2 - WOOD;
3 - MEAT;
4 - PLANT;
 */
public class Map /*extends Canvas*/ {
    
    private Objects[][] mapItems;
    private Tribe[] tribeList;
    private Randomizer random;
    
    private Herbivorous[] herbivorousList = new Herbivorous[5];
    private Carnivorous[] carnivorceList = new Carnivorous[5];
    private Plant[] plantList = new Plant[5];
    private Plant[] treeList = new Plant[5];
    private Rock[] stoneList = new Rock[2];
    private Rock[] ironList = new Rock[2];
    private Gatherer[] gathererList = new Gatherer[6];
    private Warrior[] warriorList= new Warrior[4];
    
    public void refresh() {
        regrowPlants();
        respawnObjects();
        doActions();
        
    }
    public void drawOnMap(){
        for(int i = 0;i<100;i++){
             for(int j = 0;j<100;j++){
                 if(mapItems[j][i]==null){
                     System.out.print("_");
                 } else if(mapItems[j][i] instanceof Carnivorous){
                     System.out.print("1");
                 } else if(mapItems[j][i] instanceof Gatherer){
                     System.out.print("2");
                 } else if(mapItems[j][i] instanceof Warrior){
                     System.out.print("3");
                 } else if(mapItems[j][i] instanceof Herbivorous){
                     System.out.print("4");
                 } else if(mapItems[j][i] instanceof Plant){
                     System.out.print("5");
                 } else if(mapItems[j][i] instanceof Rock){
                     System.out.print("6");
                 }
        }
             System.out.println("");
        }
    }

    private void doActions() {
        for (int i = 0; i < 5; i++) {
            herbivorousList[i].doAction(plantList, mapItems);
            carnivorceList[i].doAction(herbivorousList, mapItems);
            
        }
        for (int i = 0; i < 4; i++) {
            warriorList[i].doAction(herbivorousList, mapItems);
        }
        for (int i = 0; i < 6; i++) {
            gathererList[i].doAction(gathererList[i].choseResource(gathererList[i].tribe.checkResources(), stoneList, ironList, treeList, plantList),mapItems);
        }
    }
    
    public void createObjects() {
        
        tribeList = new Tribe[2];
        
        tribeList[0] = new Tribe(1);
        tribeList[1] = new Tribe(2);
        
        mapItems = new Objects[100][100];

        //mapItems[1][1] = new Carnivorous(1, 1, 10, 3, 10, 10);
        for (int i = 0; i < 2; i++) {
            createRock(0);
            createRock(1);
        }
        
        for (int i = 0; i < 5; i++) {
            createPlant(2, 10);
            createPlant(4, 5);
            createCarnivorous();
            createHerbivorous();
        }
        
        for (int i = 0; i < 3; i++) {
            createGatherer(tribeList[0]);
            createGatherer(tribeList[1]);
        }
        
        for (int i = 0; i < 2; i++) {
            createWarrior(tribeList[0]);
            createWarrior(tribeList[1]);
        }
        
    }
    
    public boolean isEmpty(int x, int y) {
        return mapItems[x][y] == null;
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
            inputToTable(mapItems[x][y], stoneList);
        } else {
            inputToTable(mapItems[x][y], ironList);
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
            inputToTable(mapItems[x][y], treeList);
        } else {
            inputToTable(mapItems[x][y], plantList);
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
        inputToTable(mapItems[x][y], carnivorceList);
    }
    
    private void createHerbivorous() {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y) && x != 101) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Herbivorous(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), random.randomizePerception());
        inputToTable(mapItems[x][y], herbivorousList);
    }
    
    private void createWarrior(Tribe tribe) {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y) && x != 101) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Warrior(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), tribe, random.randomizeStrenght());
        inputToTable(mapItems[x][y], warriorList);
    }
    
    private void createGatherer(Tribe tribe) {
        int x = random.randomizeLocation();
        int y = random.randomizeLocation();
        while (!isEmpty(x, y) && x != 101) {
            x = random.randomizeLocation();
            y = random.randomizeLocation();
        }
        mapItems[x][y] = new Gatherer(x, y, random.randomizeHealthPoints(), 3, random.randomizeDropAmount(), tribe);
        inputToTable(mapItems[x][y], gathererList);
    }
    
    public Map(Randomizer random) {
        this.random = random;
        for (int i = 0; i < 5; i++) {
            herbivorousList[i] = null;
            carnivorceList[i] = null;
            plantList[i] = null;
            treeList[i] = null;
        }
        for (int i = 0; i < 2; i++) {
            stoneList[i] = null;
            ironList[i] = null;
        }
        for (int i = 0; i < 6; i++) {
            gathererList[i] = null;
        }
        for (int i = 0; i < 4; i++) {
            warriorList[i] = null;
        }
    }
    
    private void inputToTable(Objects object, Objects[] table) {
        int i = 0;
        while (table[i] != null) {
            i++;
        }
        table[i] = object;
        
    }
    
    private void respawnObjects() {
        for (int i = 0; i < 6; i++) {
            gathererList[i].respawn(random, mapItems);
        }
        for(int i = 0;i<4;i++){
            warriorList[i].respawn(random, mapItems);
        }
        for (int i = 0; i < 5; i++) {
            carnivorceList[i].respawn(random, mapItems);
            herbivorousList[i].respawn(random, mapItems);
            
        }
    }
    
    private void regrowPlants() {
        for (int i = 0; i < 5; i++) {
            plantList[i].regrow();
        }
    }
    
}
