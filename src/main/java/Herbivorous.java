/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kubik
 */
public class Herbivorous extends Creature{
    private int perception;
    
    public boolean isEnemyNerby(Objects mapItems[][]){
        for(int i =1;i<perception+1;i++){
           // if(mapItems[positionX+i][positionY] || )
        }
        return true;
    }
    public void runAway(Object mapItems[][]){
        
    }
    @Override
    public void eat(){
    
    }
    @Override
    public Objects findTarget(){
    
    }
    public Herbivorous(int positionX, int positionY, int healthPoints, int resourceIndex, int dropAmount, int perception){
        this.positionX = positionX;
        this.positionY = positionY;
        this.healthPoints = healthPoints;
        this.resourceIndex = resourceIndex;
        this.dropAmount = dropAmount;
        this.perception = perception;
        
    }
    
}
