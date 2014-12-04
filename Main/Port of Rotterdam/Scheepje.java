import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scheepje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scheepje extends MenuObjecten
{
    /**
     * Act - do whatever the Scheepje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        move(0);
        if (Greenfoot.isKeyDown("a"))
        {
            turn(-1);  
    }    
    if (Greenfoot.isKeyDown("d"))
        { 
            turn(1);  
    }    
    if (Greenfoot.isKeyDown("w"))
        { move(1); // setLocation(getX(), getY()-3);   
    }    
    if (Greenfoot.isKeyDown("s"))
        {move(-1);// setLocation(getX(), getY()+3);  
        }}}
