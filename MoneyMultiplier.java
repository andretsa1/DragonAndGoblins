import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoneyMultiplier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoneyMultiplier extends Powerup
{
    private int direction;
    public MoneyMultiplier(int dir){
        direction=dir;
    }
    private int timer=20;
    private int timer2=10;
    private int speed=7;
    private int speed2=7;
    private int poweruptimer=350;
    public void act() 
    {
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
        if(getY()>=699&&getImage().getTransparency()>0){
            getWorld().removeObject(this);
        }
        else{
            Actor collision=getOneIntersectingObject(Player.class);
            if(collision!=null){
                getImage().setTransparency(0);
                Player.moneymultiplier=true;
                Greenfoot.playSound("powerUp.mp3");
            }
        }
        if(getImage().getTransparency()==0){
            Money.moneyIncrease=2;
            poweruptimer--;
            if(poweruptimer==0){
                Money.moneyIncrease=1;
                Player.moneymultiplier=false;
                getWorld().removeObject(this);
            }
        }
    }      
}
