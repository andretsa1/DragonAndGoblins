import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Upgrade extends Text
{
    /**
     * Act - do whatever the Buy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public static int price;
    public void act() 
    {
        if(Greenfoot.mouseMoved(this)){
           setImage("button_2.png");
       }
       if(Greenfoot.mouseMoved(null)&&!Greenfoot.mouseMoved(this)){
            setImage("button_1.png");
       }
       GreenfootImage image = new GreenfootImage(getImage());
       GreenfootImage text = new GreenfootImage("+dmg", 43, Color.WHITE, transparent, Color.BLACK);
       image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);

        setImage(image);
       if(Greenfoot.mousePressed(this)&&Money.money>=price){
           Player.damage+=0.5;
           Money.money-=price;
           price+=(price*0.6)*1.5;
       }
    }
}
