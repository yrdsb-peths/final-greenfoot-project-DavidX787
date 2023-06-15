import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author David
 * @version June 6 2023
 */
public class MyWorld extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("background.wav");
    public int score = 0;
    Label scoreLabel;
    public int Level = 1;
    int waveTimer = 0;
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
        backgroundMusic.playLoop();
        
    }
    public void act()
    {
          
          if(waveTimer <= 0)
          {
              spawnZombie();
              waveTimer = 400;
          }
          waveTimer--;
          
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
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel,118,72);
        
    }
    
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 10 == 0)
        {
            Level += 1;
        }
        
    }
    
    /*
     * allows you to spawn a zombie 
     */
    public void spawnZombie()
    {
        Zombies zombie = new Zombies();
        zombie.speed = Level;
        int x = 1200;
        int y = Greenfoot.getRandomNumber(600);
        addObject(zombie, x, y);

    }
        /**
     * Stops the background music when the game ends
     */
    public void stopBackgroundMusic()
    {
       backgroundMusic.stop();
    }
    
    public void gameOver()
    {
            TitleScreen gameOver = new TitleScreen();  
            Greenfoot.setWorld(gameOver);
            stopBackgroundMusic();
    }
}
