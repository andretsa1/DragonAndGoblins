import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Store here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World
{
    /**
     * Constructor for objects of class Store.
     * 
     */
    public Shop()
    {
        super(400,700,1);
        Money.money+=1000;
        Upgrade upgrade=new Upgrade();
        addObject(upgrade,300,480);
        Money money=new Money();
        addObject(money,200,160);
        Next next=new Next();
        addObject(next,300,600);
        StoreTitle storetitle=new StoreTitle();
        addObject(storetitle,150,60);
        damageCost dmgCost=new damageCost();
        addObject(dmgCost, 180, 480);
    }
}
