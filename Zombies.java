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
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
        animationTimer.mark();
    }
        
}
