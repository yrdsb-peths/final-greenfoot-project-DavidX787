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
    public void act()
    {
        // Add your action code here.
        setLocation(getX() +1, getY());
        
   
        MyWorld world = (MyWorld) getWorld();
        if(getY() >=world.getHeight())
        {
            //world.gameOver();
            world.removeObject(this);
        }
    }
}
