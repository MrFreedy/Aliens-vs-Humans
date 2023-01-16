package characters;

public class Human extends Species{
    private static String skills;
    private static String weapon;
    private static int armor;
    public Human(String name, int health, int attack, String skills, String weapon,int armor){
        super(name, health, attack);
        this.skills = skills;
        this.weapon = weapon;
        this.armor = armor;
    }

    public String getSkills(){
        return skills;
    }
    public int getArmor(){
        return armor;
    }
    public void setArmor(int amount){
        armor+=amount;
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
        if(health+amount>100){
            health = 100;
        }else {
            super.heal(amount);
            speak("I heal myself !");
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
