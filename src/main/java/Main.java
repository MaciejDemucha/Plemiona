
public class Main {

    public static void main(String[] args) {
        //WARTOŚCI DO ZMIANY
        Randomizer random = new Randomizer(100, 10, 10, 10, 10);
        Map map = new Map(random);
        map.createObjects();
        map.refresh();
       //System.out.print("Test");
      //System.out.println("cls");
       map.drawOnMap();
       map.refresh();
       map.refresh();
       map.refresh();
       map.refresh();
       System.out.println("");
       map.drawOnMap();
       
    }
    
}
