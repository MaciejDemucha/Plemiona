
abstract class Human extends Creature {

    protected int itemLevel;
    protected Tribe tribe;

    @Override
    protected void eat() {
        if (tribe.checkResources(3) > 4) {
            this.hungerPoints += 5;
            tribe.removeResources(3, 5);
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
}
