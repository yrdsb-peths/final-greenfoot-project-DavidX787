import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The pea your helicopter shoots.
 * 
 * @author David Xu
 * @version June 2023
 */
public class PEA extends Actor
{
    int peaSpeed = 10;
    public PEA()
    {
        getImage().scale(30,30);
    }
    
    public void act() 
    {
        // Keeps pea constantly "moving"
        MyWorld world = (MyWorld) getWorld();
        int x = getX() + peaSpeed + world.Level*2;
        int y = getY();
        setLocation(x,y);
        
        // Removes pea object if it reaches the world width
        if(getX() >= world.getWidth()-50)
        {
            world.removeObject(this);
        }
    } 
    
}
