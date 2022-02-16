import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Warning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warning extends Actor
{
    /**
     * Act - do whatever the Warning wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timer=75;
    public void act() 
    {
        MouseInfo mouse=Greenfoot.getMouseInfo();
        if(mouse!=null){
        if(getX()<Greenfoot.getMouseInfo().getX()){
            setLocation(getX()+1,getY());
        }
        else if(getX()>Greenfoot.getMouseInfo().getX()){
            setLocation(getX()-1,getY());
        }
        }
        if(timer<=0){
            getWorld().addObject(new Meteor(),getX(),0);
            getWorld().removeObject(this);
        }
        else{
            timer--;
        }
    }
}
