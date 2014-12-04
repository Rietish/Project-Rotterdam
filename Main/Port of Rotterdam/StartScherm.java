import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScherm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScherm extends World
{

    /**
     * Constructor for objects of class StartScherm.
     * 
     */
    
    public StartScherm()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(50, 42, 20); 
        addObject(new StartGame(),24,39);
        Muziekspeler.playSound(1);
    }
}
