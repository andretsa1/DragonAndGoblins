import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Text
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public static int score=0;
    public void act() 
    {
        GreenfootImage image=new GreenfootImage("Score: "+score, 30, Color.WHITE, transparent);
        setImage(image);
        getWorld().setPaintOrder(Score.class,Gameover.class,Highscore.class,Restart.class,Store.class);
        if(score>Highscore.highscore){
            Highscore.highscore=score;
        }
    }    
}
