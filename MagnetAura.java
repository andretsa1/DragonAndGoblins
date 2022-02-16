import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MagnetAura here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnetAura extends Actor
{
    /**
     * Act - do whatever the MagnetAura wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static boolean invisible=true;
    public void act() 
    {
        if(invisible==true){
            getImage().setTransparency(0);
        }
        else if(invisible==false){
            getImage().setTransparency(255);
            animateSprite();
        }
        setLocation(getX(),getY());
        if (this.getWorld().getClass() == Play.class) {
            MouseInfo mouse=Greenfoot.getMouseInfo();
            if(mouse!=null){
                setLocation(mouse.getX(),getY());
            }
        }
    }
    private int spriteTimer=3;
    private int spriteNum=1;
    private int spriteDirection=1;
    private void animateSprite(){
        if(spriteTimer<=0){
            spriteNum+=spriteDirection;
            if(spriteNum>3){
                spriteNum=2;
                spriteDirection=-spriteDirection;
            }
            else if(spriteNum<1){
                spriteNum=2;
                spriteDirection=-spriteDirection;
            }
            GreenfootImage image;
            switch(spriteNum){
                case 1: image=new GreenfootImage("magnet_aura.png"); break;
                case 2: image=new GreenfootImage("magnet_aura_1.png"); break;
                case 3: image=new GreenfootImage("magnet_aura_2.png"); break;
                default: image=new GreenfootImage("magnet_aura.png"); break;
            }
            setImage(image);
            spriteTimer=3;
        }
        else{
            spriteTimer--;
        }
    }
}
