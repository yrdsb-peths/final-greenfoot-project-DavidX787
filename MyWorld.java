import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author David
 * @version June 6 2023
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1400, 600, 1);
        Zombies z = new Zombies();
        addObject(z, 1200, 225);
        prepare();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Heli heli = new Heli();
        addObject(heli,1110,251);
        heli.setLocation(1190,226);
        heli.setLocation(273,285);
        Label label = new Label(0, 80);
        addObject(label,118,72);
        label.setLocation(82,67);
    }
}
