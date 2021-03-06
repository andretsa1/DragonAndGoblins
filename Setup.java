import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Setup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Setup extends World
{
    /**
     * Constructor for objects of class Setup.
     * 
     */
    public Setup()
    {    
        super(600, 400, 1); 
        Money.money=0;
        Upgrade.price=150;
        Highscore.highscore=0;
        Greenfoot.setSpeed(50);
        Sound.stopsound=false;
        MagnetAura.invisible=true;
        Player.moneymultiplier=false;
        Player.shootspeed=5;
        Player.scattershot=false;
        Player.damage=2;
        MenuStuff.playsound=true;
        Coin.magnetpowerup=false;
        Greenfoot.setWorld(new Menu());
    }
}
