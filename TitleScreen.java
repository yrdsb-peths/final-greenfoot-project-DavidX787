import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author David 
 * @version June 6 2023
 */
public class TitleScreen extends World
{
    GreenfootSound background = new GreenfootSound("menu.wav");
    
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
        stopBackgroundMusic();
        }
        else{
            background.playLoop();
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
        Label label = new Label("Click Space To Begin", 50);
        addObject(label,430,480);
    }
    
    /**
     * Stops the background music once the screen is changed
     */
    public void stopBackgroundMusic()
    {
        background.stop();
    }
}
