import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Mobs
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int faster;
    //public int timer=faster*100;
    public int health;
    private int powerup;
    public Enemy(int tmp, int tmp1){
        health=tmp;
        faster=tmp1;
    }
    public void act() 
    {
        animateSprite();
        setLocation(getX(),getY()+faster);
        /*timer--;
        if(timer<=0){
            faster-=10;
            if(faster<=0){
                faster=80;
                
            }
            timer=faster*100;
        }*/
        if(getY()>=699){
            getWorld().removeObject(this);
        }
        else{
            //Actor collision=getOneIntersectingObject(Player.class);
            //if(collision!=null){
            //    Greenfoot.setWorld(new Menu());
            //}
            //else{
                List players = getObjectsInRange(87, Fireball.class);
                if (!players.isEmpty()){
                    Actor fireball = (Actor) players.get(0);
                    if(fireball.getX()>getX()-60&&fireball.getX()<getX()+60){
                        health-=Player.damage;
                        getWorld().removeObject(fireball);
                    }
                }
                List players2 = getObjectsInRange(87, ScatterShotFireball.class);
                if (!players2.isEmpty()){
                    Actor fireball2 = (Actor) players2.get(0);
                    if(fireball2.getX()>getX()-60&&fireball2.getX()<getX()+60){
                        health-=Player.damage;
                        getWorld().removeObject(fireball2);
                    }
                }
            //}
            /*
            Actor collision2=getOneIntersectingObject(Fireball.class);
            if(collision2!=null){
                getWorld().addObject(new Coin(1), getX(), getY());
                getWorld().removeObject(this);
            }*/
        }
        if(health<=0){
            if(Greenfoot.getRandomNumber(99)+1<=2){
                powerup=Greenfoot.getRandomNumber(3)+1;
                switch(powerup){
                    case 1: getWorld().addObject(new MoneyMultiplier(direction()), getX(), getY());
                    break;
                    case 2: getWorld().addObject(new Magnet(direction()), getX(), getY());
                    break;
                    case 3: getWorld().addObject(new ScatterShot(direction()), getX(), getY());
                    break;
                    //case 4: getWorld().addObject(new Magnet(direction()), getX(), getY());
                    //break;
                    //case 5: getWorld().addObject(new ScatterShot(direction()), getX(), getY());
                    // break;
                }
            }
            else{
                getWorld().addObject(new Coin(direction()), getX(), getY());
            }
            getWorld().removeObject(this);
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
    private int spriteTimer=5;
    private int spriteNum=1;
    private int spriteDirection=1;
    private void animateSprite(){
        if(spriteTimer<=0){
            spriteNum+=spriteDirection;
            if(spriteNum>6){
                spriteNum=5;
                spriteDirection=-spriteDirection;
            }
            else if(spriteNum<1){
                spriteNum=2;
                spriteDirection=-spriteDirection;
            }
            GreenfootImage image;
            switch(spriteNum){
                case 1: image=new GreenfootImage("enemy_1.png"); break;
                case 2: image=new GreenfootImage("enemy_2.png"); break;
                case 3: image=new GreenfootImage("enemy_3.png"); break;
                case 4: image=new GreenfootImage("enemy_4.png"); break;
                case 5: image=new GreenfootImage("enemy_5.png"); break;
                case 6: image=new GreenfootImage("enemy_6.png"); break;
                default: image=new GreenfootImage("enemy_1.png"); break;
            }
            setImage(image);
            spriteTimer=5;
        }
        else{
            spriteTimer--;
        }
    }
}
