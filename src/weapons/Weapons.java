package weapons;

public class Weapons {
    private String name;
    private int numBullet;
    private int fireRange;
    private int power;


    public Weapons(String name, int numBullet, int fireRange, int power){
        this.name = name;
        this.numBullet = numBullet;
        this.fireRange = fireRange;
        this.power = power;
    }


    public String getName() {
        return name;
    }

    public int getNumBullet() {
        return numBullet;
    }

    public int getFireRange() {
        return fireRange;
    }

    public int getPower() {
        return power;
    }

}
