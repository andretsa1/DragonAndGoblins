import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends World
{
    private int imageCount = 0;
    private GreenfootImage bgImage = new GreenfootImage("sky_clouds_05.jpg");
    public void drawBackgroundImage() {
        if (imageCount > bgImage.getHeight()) {
            imageCount -= bgImage.getHeight();
        }
        int temp = imageCount;
        getBackground().drawImage(bgImage, 0, temp);
        getBackground().drawImage(bgImage, 0, temp - bgImage.getHeight());
    }
    public Play()
    {    
        super(400,700,1);
        Score.score=0;
        played=true;
        Player player=new Player();
        addObject(player, 200, 600);
        MagnetAura magnetaura=new MagnetAura();
        addObject(magnetaura, 200, 600);
        Score score=new Score();
        addObject(score,100,50);
    }
    public static boolean played=false;
    private int spawnEnemy=0;
    private int count=0;
    private int health=4;
    private int faster=4;
    private int spawnMeteor=150;
    public void act() 
    {
        imageCount+=2;
        drawBackgroundImage();
        if(spawnEnemy<=0){
            for(int i=1;i<=5;i++){
                if(Greenfoot.getRandomNumber(99)+1<5){
                    addObject(new Treasure(faster),i*80-20,0);
                }
                else{
                    addObject(new Enemy(health, faster),i*80-20,0);
                }
            }
            count++;
            if (count>=20) {
                faster += 1;
                health++;
                count=0;
            }
            spawnEnemy=100-faster*5;
        }
        else{
            spawnEnemy--;
        }
        if(spawnMeteor<=0){
            if(Greenfoot.getRandomNumber(99)+1<30){
                MouseInfo mouse=Greenfoot.getMouseInfo();
                if(mouse!=null){
                    addObject(new Warning(), mouse.getX(), 700/2);
                }
                else{
                    addObject(new Warning(), 400/2, 700/2);
                }
            }
            spawnMeteor=150;
        }
        else{
            spawnMeteor--;
        }
    }
}
