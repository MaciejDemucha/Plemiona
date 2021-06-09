
public class Tribe {

    private int[] resourceAmount;
    private int tribeNr;

    public boolean checkWinCondition() {
        //LICZBA SUROWCÓW DO ZMIANY
        if (resourceAmount[0] == 40 && resourceAmount[1] == 20 && resourceAmount[2] == 50) {
            return true;
        } else {
            return false;
        }
    }
     public boolean isEnoughFood(){
        return resourceAmount[3]>50;
    }
}


/*RESOURCE INDEX
0 - STONE;
1 - IRON;
2 - WOOD;
3 - MEAT;
4 - PLANT;
 */
