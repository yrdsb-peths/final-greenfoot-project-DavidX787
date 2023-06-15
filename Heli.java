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
    GreenfootImage[] animateHeli = new GreenfootImage[4];
    SimpleTimer animationTimer = new SimpleTimer();
    int speed = 2;
    int fireTimer = 0;
    boolean canShoot = true;
    //public int Level;
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-3-world.Level);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+3+world.Level);
        }
         // If helicopter  is at the edge of viewport, stops it moving further
        if(isAtEdge())
        {
            move(0);
        }
        // If player clicks space, shoots pea (if timer equals 0)
        if(Greenfoot.isKeyDown("space"))
        {
            if(canShoot == true)
            {
                shootPea();
                if(world.Level >= 2)
                {
                    shootPea();
                    shootPea();
                }
                canShoot = false;
                fireTimer = 70 - (world.Level*15);
            }
            else
            {
                if(fireTimer <= 0)
                {
                    canShoot = true;
                }
            }
        }
        fireTimer--;
        // animate helicopter 
        animateHeli();
    }
    
    /**
     * Creates and shoots pea object in the world
     */
    public void shootPea()
    {
        PEA pea = new PEA();
        getWorld().addObject(pea,getX() + 200,getY()+ 70);
        //fireSound.play();
    }
    public Heli()
    {
        getImage().scale(420,150);
        for(int i = 0; i < animateHeli.length; i++)
        {
            animateHeli[i] = new GreenfootImage("images/image" + (i) + ".png");
            animateHeli[i].scale(300, 120);
        }
        animationTimer.mark();
        setImage(animateHeli[0]);
    }
    
    int imageIndex = 0;
    public void animateHeli()
    {
        if(animationTimer.millisElapsed() < 300){
            return;
        }
        animationTimer.mark();
        setImage(animateHeli[imageIndex]);
        imageIndex = (imageIndex + 1) % animateHeli.length;
    }
    
   
        
}
