import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombies here.
 * 
 * @author David
 * @version June 2023
 */
public class Zombies extends Actor
{
    /**
     * Act - do whatever the Zombies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idle = new GreenfootImage[8];
    GreenfootSound comingZombie = new GreenfootSound("zombies_coming.wav");
    SimpleTimer animationTimer = new SimpleTimer();
    public int zombieCount = 0; 
    public int speed = 1;
    int zombieHealth = 100; 
    public void act()
    {
        //zombie moving
        setLocation(getX() - speed , getY());
        zombieHit(50);
        //animate the zombie
        animateZomb();
        //checks if zombie reaches the end to activiate game over
        MyWorld world = (MyWorld) getWorld();
        try {
            if(getX() <= world.getWidth()-1200)
            {
                world.removeObject(this);
                world.gameOver();
            } 
        }
        catch(Exception e) {}
    }
    
    public Zombies()
    {
        //plays music when no zombies
        if(zombieCount==0)
        {
            comingZombie.play();
        }
        zombieCount+=1;
        //zombie animation code
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
    
        /**
     * This method sets the health of a zombie object
     */
    public void setHealth(int health)
    {
        zombieHealth = health;
    }

    
    /**
     * This method is called whenever a zombie is hit by an object of the bullet class.
     * It takes the input: the damage caused by the bullet, which is reduced from its health,
     */
    public void zombieHit(int damage)
    {   
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(PEA.class))
        {
            zombieHealth -= damage + (world.Level*15);
            removeTouching(PEA.class);
            if(Greenfoot.getRandomNumber(4) == 1)
            {
                world.spawnZombie();
                world.spawnZombie();
            }
            if(Greenfoot.getRandomNumber(12) == 1)
            {
                world.spawnZombie();
                world.spawnZombie();
                world.spawnZombie();
            }
        }
        
        if(zombieHealth <= 0)
            {
                removeTouching(PEA.class);                
                
                
                world.increaseScore();
                world.removeObject(this);
             
            }
    }
}

