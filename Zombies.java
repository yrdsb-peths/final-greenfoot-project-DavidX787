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
    int zombieCount = 0; 
    int zombieHealth = 100; 
    public void act()
    {
        //zombie moving
        setLocation(getX() -1 , getY());
        
        zombieHit(50);
        //animate the zombie
        animateZomb();
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
        if(isTouching(PEA.class))
        {
            zombieHealth -= damage;
            removeTouching(PEA.class);
        }
        
        if(zombieHealth <= 0)
            {
                removeTouching(PEA.class);                
                
                MyWorld world = (MyWorld) getWorld();
                world.increaseScore();
                world.removeObject(this);
            }
    }
}
