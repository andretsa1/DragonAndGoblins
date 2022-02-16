import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Jewel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jewel extends Currency
{
    private int direction;
    public Jewel(int dir){
        direction=dir;
    }
    private int timer=20;
    private int timer2=10;
    private int speed=7;
    private int speed2=7;
    public void act() 
    {
        animateSprite();
        if(Coin.magnetpowerup==true){
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
                    Greenfoot.playSound("gem.mp3");
                    Money.money+=10*Money.moneyIncrease;
                    Score.score+=10*Money.moneyIncrease;
                    getWorld().removeObject(this);
                }
            }
        }
        
    } 
    private int spriteTimer=8;
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
                case 1: image=new GreenfootImage("gem.png"); break;
                case 2: image=new GreenfootImage("gem_1.png"); break;
                default: image=new GreenfootImage("gem_1.png"); break;
            }
            setImage(image);
            spriteTimer=8;
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
