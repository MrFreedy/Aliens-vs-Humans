package characters;

public class Species {
    public int health;
    public int attack;
    private String name;

    public Species(String name, int health, int attack){
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getAttack(){
        return attack;
    }

    public void heal(int amount){
        health += amount;
    }

    public void speak(String message){
        System.out.printf("%s: %s",getName(),message);
    }

    public void attack(Species opponent){
        opponent.health -= attack;
    }

    public void takeDamage(int amount){
        health -= amount;
    }


}
