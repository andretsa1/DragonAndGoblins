import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Store here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Store extends Text
{
    /**
     * Act - do whatever the Store wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public void act() 
    {
       if(Greenfoot.mouseMoved(this)){
           setImage("button_2.png");
       }
       if(Greenfoot.mouseMoved(null)&&!Greenfoot.mouseMoved(this)){
            setImage("button_1.png");
       }
       GreenfootImage image = new GreenfootImage(getImage());
       GreenfootImage text = new GreenfootImage("Store", 43, Color.WHITE, transparent, Color.BLACK);
       image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
                        setImage(image);
       if(Greenfoot.mousePressed(this)){
           Greenfoot.setWorld(new Shop());
       }
    } 
}
