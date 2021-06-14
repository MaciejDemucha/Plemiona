
abstract class Human extends Creature {

    protected int itemLevel;
    protected Tribe tribe;

    @Override
    protected void eat() {
        if (tribe.checkResources(3) > 49) {
            this.hungerPoints += 50;
            tribe.removeResources(50, 3);
        } else if (tribe.checkResources(3) > 0) {
            this.hungerPoints -= tribe.checkResources(3);
            tribe.removeResources(tribe.checkResources(3), 3);
        }
    }

    public Human(Tribe tribe) {
        super();
        this.tribe = tribe;
        this.itemLevel = 1;
    }
    public void upgradeTool(){
        if(itemLevel==1){
            if(tribe.checkResources(0)>20 && tribe.checkResources(1)>10){
                itemLevel++;
                tribe.removeResources(20, 0);
                tribe.removeResources(10, 1);
            }
        }
    }
}
