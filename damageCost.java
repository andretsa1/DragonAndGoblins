import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class damageCost extends Text
{
    /**
     * Act - do whatever the Cost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public void act() 
    {
       GreenfootImage image = new GreenfootImage(""+Upgrade.price, 43, Color.WHITE, transparent);
       setImage(image);
    }    
}
