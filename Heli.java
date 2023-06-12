import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heli here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heli extends Actor
{
    /**
     * Act - do whatever the Heli wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()+3);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()-3);
        }
        
        // animate helicopter 
        //animateHeli();
        
    }
   
        
}
