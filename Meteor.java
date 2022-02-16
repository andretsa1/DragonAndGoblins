import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteor extends Actor
{
    /**
     * Act - do whatever the Meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean dead=false;
    private int slowtimer=15;
    private int ct=0;
    public void act() 
    {
        //Actor collision=getOneIntersectingObject(Player.class);
        List players = getObjectsInRange(87, Player.class);
        if(getY()>=699){
            getWorld().removeObject(this);
        }
        else if (!players.isEmpty()){
            Actor player = (Actor) players.get(0);
            setLocation(getX(),getY()+8);
            animateSprite();
            if(player.getX()>getX()-60&&player.getX()<getX()+60&&player.getY()<getY()+40){
                if (ct==0)
                {
                    getWorld().removeObjects(getWorld().getObjects(MagnetAura.class));
                    Greenfoot.playSound("gameOver.mp3");
                    ct++;
                }
                getWorld().removeObject(player);
                dead=true;
            }
        }
        //else if(collision!=null){
        //    Greenfoot.setWorld(new Menu());
        //}
        else{
            setLocation(getX(),getY()+8);
            animateSprite();
        }
        if(dead==true){
            Greenfoot.setSpeed(40);
            slowtimer--;
            getImage().setTransparency(0);
            if(slowtimer<=0){
                Greenfoot.setSpeed(50);
                getWorld().addObject(new Gameover(), 200, 250);
                getWorld().addObject(new Highscore(), 200, 350);
                getWorld().addObject(new Restart(), 100, 400);
                getWorld().addObject(new Store(), 300, 400);
                getWorld().removeObject(this);
            }
        }
    }    
    private int spriteTimer=7;
    private int spriteNum=1;
    private int spriteDirection=1;
    private void animateSprite(){
        if(spriteTimer<=0){
            spriteNum+=spriteDirection;
            if(spriteNum>4){
                spriteNum=3;
                spriteDirection=-spriteDirection;
            }
            else if(spriteNum<1){
                spriteNum=2;
                spriteDirection=-spriteDirection;
            }
            GreenfootImage image;
            switch(spriteNum){
                case 1: image=new GreenfootImage("meteor_1.png"); break;
                case 2: image=new GreenfootImage("meteor_2.png"); break;
                case 3: image=new GreenfootImage("meteor_3.png"); break;
                case 4: image=new GreenfootImage("meteor_4.png"); break;
                default: image=new GreenfootImage("meteor_1.png"); break;
            }
            setImage(image);
            spriteTimer=7;
        }
        else{
            spriteTimer--;
        }
    }
}
