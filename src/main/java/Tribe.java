
public class Tribe {

    private int[] resourceAmount;
    private int tribeNr;

    public boolean checkWinCondition() {
        //LICZBA SUROWCÓW DO ZMIANY
        return resourceAmount[0] == 40 && resourceAmount[1] == 20 && resourceAmount[2] == 50;
    }

    public Tribe(int tribeNr) {
        this.resourceAmount = new int[4];
        for (int i = 0; i < 4; i++) {
            resourceAmount[i] = 0;
        }
        this.tribeNr = tribeNr;
    }

    public void addResources(int amountToAdd, int resourceIndex) {
        resourceAmount[resourceIndex] += amountToAdd;
    }

    public void removeResources(int amountToRemove, int resourceIndex) {
        resourceAmount[resourceIndex] -= amountToRemove;
    }

    public int checkResources(int resourceIndex) {
        return resourceAmount[resourceIndex];
    }
    public int[] checkResources(){
        return resourceAmount;
    }

}


/*RESOURCE INDEX
0 - STONE;
1 - IRON;
2 - WOOD;
3 - MEAT;
4 - PLANT;

DLA TRIBE
3 - FOOD
4 - NONE

 */
