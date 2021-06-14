
public class Main {

    public static void main(String[] args) {
        //WARTOŚCI DO ZMIANY
        Randomizer random = new Randomizer(100, 10, 100, 10, 10);
        Map map = new Map(random);
        map.createObjects();
       int counter = 0;
       while(!map.isWon()){
           map.refresh();
           System.out.println("COUNTER"+counter);
           counter++;
       }
       System.out.println("");
       //map.drawOnMap();
       
    }
    
}
