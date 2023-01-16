package characters;

public class Alien extends Species{
    private static String ability;
    private static String species;
    public Alien(String name, int health, int attack, String species,String ability){
        super(name,health,attack);
        this.ability = ability;
        this.species = species;
    }

    @Override
    public void heal(int amount){
        if(health+amount>250){
            health=250;
        }else{
            super.heal(amount);
            speak("I use my genetic to heal myself !");
        }
    }

    public void mutate(){
        if(attack<10){
            attack+=2;

            if(attack>=10){
                attack=10;
            }
            speak("I mutate myself and I feel more stronger !");
        }
        else {
            speak("I can't mutate myself anymore !");
        }
    }



}
