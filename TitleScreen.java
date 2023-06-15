import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author David 
 * @version June 6 2023
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(860, 600, 1);  
        prepare();
    }

    /**
     * Game start 
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
        MyWorld gameWorld = new MyWorld();
        Greenfoot.setWorld(gameWorld);
        }
    }
    
    public void menu()
    {
        Menu menu = new Menu();
        //addObject(menu,255,460);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Menu menu = new Menu();
        addObject(menu,430,300);
    }
}
