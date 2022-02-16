import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound extends Actor
{
    /**
     * Act - do whatever the Sound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static boolean stopsound;
    private int changesprite=0;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            changesprite++;
            if(changesprite>1){
                changesprite=0;
            }
        }
        switch(changesprite){
            case 0: setImage("sound_on.png"); stopsound=false; break;
            case 1: setImage("sound_off.png"); stopsound=true; break;
        }
        if(Greenfoot.mousePressed(null)&&!Greenfoot.mousePressed(this)){
            Greenfoot.setWorld(new Play());
        }
    }    
}
