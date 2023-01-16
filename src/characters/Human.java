package characters;

public class Human extends Species{
    public static String weapon;
    public static int armor;

    public static String getWeapon() {
        return weapon;
    }

    public Human(String name, int health, int attack, String weapon, int armor){
        super(name, health, attack);
        this.weapon = weapon;
        this.armor = armor;
    }

    public int getArmor(){
        return armor;
    }

    public void equipWeapon(String weapon){
        this.weapon=weapon;
    }

    @Override
    public void attack(Species opponent){
        if(weapon.equals("AR-15")){
            attack=20;
            super.attack(opponent);
        }else{
            attack=5;
            super.attack(opponent);
        }
    }

    @Override
    public void takeDamage(int damage){
        if(armor > 0){
            armor -= damage;

            if(armor < 0){
                health += armor;
                armor = 0;
                speak("Shit ! You destroy my shield and you hurt me !");
            }else {
                speak("HAHA ! Nice try but my armor took the damage !");
            }
        }else{
            super.takeDamage(damage);
            speak("Argh... You hurt me !");
        }
        if(health<=0){
            speak("GG you got me !");
        }
    }

    @Override
    public void heal(int amount){
        if(health!=100){
            if(health+amount>100){
                health = 100;
            }else {
                super.heal(amount);
                speak("I heal myself !");
            }
        }else{
            speak("I feel good ! I don't need to heal me");
        }
    }


    public void eat(){
        if(attack<10){
            attack+=1;
            speak("Hmmm...That's was delicious. I feel more stronger !!!");
        }else{
            speak("I have already eaten enough !");
        }

    }

}
