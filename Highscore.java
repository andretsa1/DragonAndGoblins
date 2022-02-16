import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Highscore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Highscore extends Text
{
    /**
     * Act - do whatever the Highscore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public static int highscore=0;
    public void act() 
    {
       GreenfootImage image = new GreenfootImage("Highscore: "+highscore, 43, Color.WHITE, transparent);
       setImage(image);
    }    
}
