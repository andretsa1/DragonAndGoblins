import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int damage=2;
    public static int shootspeed=5;
    private int timer=shootspeed;
    public int powerTimer=0;
    public int X;
    private int slowtimer=25;
    private boolean dead=false;
    private int ct=0;
    public static boolean moneymultiplier=false;
    public static boolean scattershot=false;
    public void act() 
    {
        X=getX();
        if(moneymultiplier==false){
            animateSprite();
        }
        if(moneymultiplier==true){
            animateSpriteMultiplier();
        }
        setLocation(getX(),getY());
        if (this.getWorld().getClass() == Play.class) {
            MouseInfo mouse=Greenfoot.getMouseInfo();
            if(mouse!=null){
                setLocation(mouse.getX(),getY());
            }
            if(scattershot==true){
                scattershotpower();
            }
            else if(scattershot==false){
                spawnFireball();
            }
        }
        List players = getObjectsInRange(87, Enemy.class);
        if (!players.isEmpty()){
            Actor player = (Actor) players.get(0);
            if(player.getX()>getX()-60&&player.getX()<getX()+60&&player.getY()<getY()+20){
                if (ct==0)
                {
                    getWorld().removeObjects(getWorld().getObjects(MagnetAura.class));
                    Greenfoot.playSound("gameOver.mp3");
                    ct++;
                }
                dead=true;
            }
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

    public void spawnFireball(){
        if(timer==0){
            timer=shootspeed;
            Fireball fireball=new Fireball();
            getWorld().addObject(fireball,getX(),getY()-10);
        }
        else{
            timer--;
        }
    }

    public void scattershotpower(){
        if(timer==0){
            timer=shootspeed;
            ScatterShotFireball scattershotfireball1=new ScatterShotFireball(-1,0);
            ScatterShotFireball scattershotfireball2=new ScatterShotFireball(0,0);
            ScatterShotFireball scattershotfireball3=new ScatterShotFireball(1,0);
            getWorld().addObject(scattershotfireball1,getX(),getY()-10);
            getWorld().addObject(scattershotfireball2,getX(),getY()-10);
            getWorld().addObject(scattershotfireball3,getX(),getY()-10);
        }
        else{
            timer--;
        }
    }
    private int spriteTimer=3;
    private int spriteNum=1;
    private int spriteDirection=1;
    private void animateSprite(){
        if(spriteTimer<=0){
            spriteNum+=spriteDirection;
            if(spriteNum>7){
                spriteNum=6;
                spriteDirection=-spriteDirection;
            }
            else if(spriteNum<1){
                spriteNum=2;
                spriteDirection=-spriteDirection;
            }
            GreenfootImage image;
            switch(spriteNum){
                case 1: 
                image=new GreenfootImage("Player_1.png");
                break;
                case 2: 
                image=new GreenfootImage("Player_2.png");
                break;
                case 3: 
                image=new GreenfootImage("Player_3.png");
                break;
                case 4: 
                image=new GreenfootImage("Player_4.png");
                break;
                case 5: 
                image=new GreenfootImage("Player_5.png");
                break;
                case 6: 
                image=new GreenfootImage("Player_6.png");
                break;
                case 7: 
                image=new GreenfootImage("Player_7.png");
                break;
                default: 
                image=new GreenfootImage("Player_1.png");
                break;
            }
            setImage(image);
            spriteTimer=3;
        }
        else{
            spriteTimer--;
        }
    }

    private void animateSpriteMultiplier(){
        if(spriteTimer<=0){
            spriteNum+=spriteDirection;
            if(spriteNum>7){
                spriteNum=6;
                spriteDirection=-spriteDirection;
            }
            else if(spriteNum<1){
                spriteNum=2;
                spriteDirection=-spriteDirection;
            }
            GreenfootImage image;
            switch(spriteNum){
                case 1: 
                image=new GreenfootImage("Player2_1.png");
                break;
                case 2: 
                image=new GreenfootImage("Player2_2.png");
                break;
                case 3: 
                image=new GreenfootImage("Player2_3.png");
                break;
                case 4: 
                image=new GreenfootImage("Player2_4.png");
                break;
                case 5: 
                image=new GreenfootImage("Player2_5.png");
                break;
                case 6: 
                image=new GreenfootImage("Player2_6.png");
                break;
                case 7: 
                image=new GreenfootImage("Player2_7.png");
                break;
                default: 
                image=new GreenfootImage("Player2_1.png");
                break;
            }
            setImage(image);
            spriteTimer=3;
        }
        else{
            spriteTimer--;
        }
    }
}
