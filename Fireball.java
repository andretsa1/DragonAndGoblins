import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(),getY()-10);
        if(getY()<=0){
            getWorld().removeObject(this);
        }
        else{
            Actor collision=getOneIntersectingObject(Enemy.class);
            if(collision!=null){
                getWorld().removeObject(this);
            }
        }
    }    
}
