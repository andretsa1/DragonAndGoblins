import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    /**
     * Constructor for objects of class Menu.
     * 
     */
    private GreenfootSound music = new GreenfootSound("backgroundPlay.mp3");
    public Menu()
    {     
        super(400,700,1);
        Player player=new Player();
        addObject(player, 200, 600);
        MagnetAura magnetaura=new MagnetAura();
        addObject(magnetaura, 200, 600);
        Money money=new Money();
        addObject(money,100,50);
        MenuStuff menustuff=new MenuStuff();
        addObject(menustuff, 200, 350);
        Sound sound=new Sound();
        addObject(sound, 300, 50);
        Money.moneyIncrease=1;
        Player.moneymultiplier=false;
        Player.shootspeed=5;
        Player.scattershot=false;
        MagnetAura.invisible=true;
        if(MenuStuff.playsound==true){
            //music.playLoop();
            MenuStuff.playsound=false;
        }
    }
    public void act(){
        if(Sound.stopsound==true){
            music.pause();
        }
        else if(Sound.stopsound==false){
            //music.playLoop();
        }
    }
}
