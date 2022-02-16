import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MachineGunFireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScatterShotFireball extends Actor
{
    /**
     * Act - do whatever the MachineGunFireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int increasex;
    public int increasey;
    public ScatterShotFireball(int x,int y){
        increasex=x;
        increasey=y;
    }
    public void act() 
    {
        setLocation(getX()+increasex,(getY()-10)+increasey);
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
