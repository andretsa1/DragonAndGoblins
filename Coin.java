import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Currency
{
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int direction;
    public Coin(int dir){
        direction=dir;
    }
    private int timer=20;
    private int timer2=10;
    private int speed=7;
    private int speed2=7;
    public static boolean magnetpowerup=false;
    public void act() 
    {
        animateSprite();
        if(magnetpowerup==true){
            magnetpower();
        }
        if(timer!=0){
            setLocation(getX()+direction,getY()-speed);
            speed--;
            timer--;
            if(speed<=1){
                speed=1;
            }
        }
        else{
            setLocation(getX()+direction,getY()+speed);
            if(timer2<=0){
                speed+=2;
                timer2=10;
            }
            else{
                timer2--;
            }
            if(speed>=10){
                speed=10;
            }
        }
        if(getY()>=699){
            getWorld().removeObject(this);
        }
        else{
            List players = getObjectsInRange(87, Player.class);
            if (!players.isEmpty()){
                Actor player = (Actor) players.get(0);
                if(player.getX()>getX()-25&&player.getX()<getX()+25&&player.getY()<getY()+30&&player.getY()>getY()-30){
                    Greenfoot.playSound("coinSound_1.mp3");
                    Money.money+=1*Money.moneyIncrease;
                    Score.score+=1*Money.moneyIncrease;
                    getWorld().removeObject(this);
                }
            }
        }
    }  
    private int spriteTimer=6;
    private int spriteNum=1;
    private int spriteDirection=1;
    private void animateSprite(){
        if(spriteTimer<=0){
            spriteNum+=spriteDirection;
            if(spriteNum>2){
                spriteNum=1;
                spriteDirection=-spriteDirection;
            }
            else if(spriteNum<1){
                spriteNum=2;
                spriteDirection=-spriteDirection;
            }
            GreenfootImage image;
            switch(spriteNum){
                case 1: image=new GreenfootImage("coco.png"); break;
                case 2: image=new GreenfootImage("coco_2.png"); break;
                default: image=new GreenfootImage("coco.png"); break;
            }
            setImage(image);
            spriteTimer=6;
        }
        else{
            spriteTimer--;
        }
    }
    private void magnetpower(){
         List players = getObjectsInRange(100, Player.class);
         if (!players.isEmpty()){
             Actor player = (Actor) players.get(0);
             if(getX()>player.getX()){
                 setLocation(getX()-5,getY());
             }
             if(getX()<player.getX()){
                 setLocation(getX()+5,getY());
             }
             if(getY()>player.getY()){
                 setLocation(getX(),getY()-5);
             }
             if(getY()<player.getY()){
                 setLocation(getX(),getY()+5);
             }
         }
    }
}
