
abstract class Creature extends Objects {

    protected int hungerPoints;
    protected int movementSpeed;
    protected int respawnTime;
    protected Objects target;
    protected int[] targetLocation;

    abstract void findTarget(Objects[] table);

    abstract void eat();

    abstract void doAction(Objects[] table, Objects[][] mapItems);

    public void moveToTarget(Objects[][] mapItem, int xTarget, int yTarget) {

        if (positionX > xTarget) {
            changeOnMapLocation(mapItem, -1, 0);
        }else if(positionX < xTarget){
            changeOnMapLocation(mapItem, 1, 0);
        }
        
         if (positionY > yTarget) {
            changeOnMapLocation(mapItem, 0, -1);
        }else if(positionY < yTarget){
            changeOnMapLocation(mapItem, 0, 1);
        }

        /*if (positionX == xTarget) {
            if (positionY > yTarget) {               
                changeOnMapLocation(mapItem, 0, -1);
            } else if (positionY < yTarget) {
                changeOnMapLocation(mapItem, 0, 1);
            }
        } else if (positionY == yTarget) {
            if (positionX > xTarget) {
                changeOnMapLocation(mapItem, -1, 0);
            } else if (positionX < xTarget) {
                changeOnMapLocation(mapItem, 1, 0);
            }
        } else {
            if (positionX < xTarget && positionY < yTarget) {
                changeOnMapLocation(mapItem, 1, 1);
            } else if (positionX < xTarget && positionY > yTarget) {
                changeOnMapLocation(mapItem, 1, -1);
            } else if (positionX > xTarget && positionY > yTarget) {
                changeOnMapLocation(mapItem, -1, -1);
            } else if (positionX > xTarget && positionY < yTarget) {
                changeOnMapLocation(mapItem, -1, 1);
            }
        }*/
    }

    public void changeOnMapLocation(Objects[][] mapItem, int x, int y) {
        if(positionX+x>99 || positionY+y>99 || positionX+x<0 || positionY+y<0){
            targetLocation = target.checkLocation();
            System.out.println("IS TARGET alive"+ target.isAlive());
            System.out.println("TAAAAAAAARGET SHITED LOCATION: " +targetLocation[0]+" " + targetLocation[1] );
            System.out.println("object SHITED LOCATION: " +positionX+" " + positionY );
            System.out.println("x and y" +x+" " + y );
            
        }
        mapItem[positionX + x][positionY + y] = mapItem[positionX][positionY];
        mapItem[positionX][positionY] = null;
        this.positionX += x;
        this.positionY += y;
    }

    protected boolean isInRange(int x, int y, int objectX, int objectY) {
        return Math.abs(objectX - x) + Math.abs(objectY - y) == 1;
    }

    protected void respawn(Randomizer random, Objects[][] mapItem) {
        if (!isAlive && respawnTime < 1) {
            int x = random.randomizeLocation();
            int y = random.randomizeLocation();
            this.healthPoints = random.randomizeHealthPoints();
            this.dropAmount = random.randomizeDropAmount();
            this.hungerPoints = 300;
            this.isAlive = true;
            while (mapItem[x][y] != null) {
                x = random.randomizeLocation();
                y = random.randomizeLocation();
            }
            mapItem[x][y] = this;
            positionX = x;
            positionY =y;
            System.out.println(" RESPAWNED OBJECT"+ mapItem[x][y]);
        }else
            respawnTime--;

    }

    public Creature() {
        super();
        this.targetLocation = new int[2];
        target = null;
        this.hungerPoints = 500;
        this.movementSpeed = 1;
        this.respawnTime = 10;
    }
}
