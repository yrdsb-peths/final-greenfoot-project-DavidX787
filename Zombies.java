import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombies extends Actor
{
    /**
     * Act - do whatever the Zombies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idle = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    int random = 4;
    public void act()
    {
        // Add your action code here.
        setLocation(getX() -1 , getY());
        
        
   
        MyWorld world = (MyWorld) getWorld();
        if(getY() >=world.getHeight())
        {
            //world.gameOver();
            world.removeObject(this);
        }
        if(isTouching(PEA.class))
        {
            removeTouching(PEA.class);
            //deathSound.play();
            //createExplosion();
            world.increaseScore();
            world.removeObject(this);
            
            if(Greenfoot.getRandomNumber(random) == 2){
                world.spawnZombie();
                world.spawnZombie();
            }
            else{
                world.spawnZombie();
            }
        }
        //animate the zombie
        animateZomb();
    }
    
    public Zombies()
    {

        for(int i = 0; i < idle.length; i ++)
        {
            idle[i] = new GreenfootImage("images/tile00" + i + ".png");
            idle[i].scale(200, 200);
        }
        animationTimer.mark();
        setImage(idle[0]);
    }
    
    int imageIndex = 0;
    public void animateZomb()
    {
        if(animationTimer.millisElapsed() < 200){
            return;
        }
        animationTimer.mark();
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
        
}
