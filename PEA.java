import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The pea your helicopter shoots.
 * 
 * @author David Xu
 * @version June 2023
 */
public class PEA extends Actor
{
    int peaSpeed = 15;
    public PEA()
    {
        getImage().scale(30,30);
    }
    
    public void act() 
    {
        // Keeps pea constantly "moving"
        int x = getX() + peaSpeed;
        int y = getY();
        setLocation(x,y);
        
        // Removes pea object if it reaches the world height
        World world = (World) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
        }
    } 
    
}
