import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasure extends Mobs
{
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int faster;
    public Treasure(int tmp){
        faster=tmp; 
    }

    public void act() 
    {
        setLocation(getX(),getY()+faster);
        if(getY()>=699){
            getWorld().removeObject(this);
        }
        else{
            Actor collision=getOneIntersectingObject(Player.class);
            if(collision!=null){
                getWorld().addObject(new Jewel(direction()),getX(),getY());
                getWorld().removeObject(this);
            }
            else{
                if(!getWorld().getObjects(ScatterShotFireball.class).isEmpty()){
                    List players2 = getObjectsInRange(87, ScatterShotFireball.class);
                    if (!players2.isEmpty()){
                        Actor fireball2 = (Actor) players2.get(0);
                        if(fireball2.getX()>getX()-60&&fireball2.getX()<getX()+60){
                            getWorld().removeObject(fireball2);
                            getWorld().addObject(new Jewel(direction()),getX(),getY());
                            getWorld().removeObject(this);
                        }
                    }
                }
                else{
                    List players = getObjectsInRange(87, Fireball.class);
                    if (!players.isEmpty()){
                        Actor fireball = (Actor) players.get(0);
                        if(fireball.getX()>getX()-65&&fireball.getX()<getX()+65){
                            getWorld().removeObject(fireball);
                            getWorld().addObject(new Jewel(direction()),getX(),getY());
                            getWorld().removeObject(this);
                        }
                    }
                }
            }
        }
    }    

    public int direction(){
        if(Greenfoot.getRandomNumber(99)+1<=50){
            return 1;
        }
        else{
            return -1;
        }
    }
}
