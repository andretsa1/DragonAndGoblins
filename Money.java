import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Money extends Text
{
    /**
     * Act - do whatever the Money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public static int money=0;
    public static int moneyIncrease=1;
    public void act() 
    {
        GreenfootImage image=new GreenfootImage("Money: "+money, 43, Color.WHITE, transparent);
        setImage(image); 
    }    
}
