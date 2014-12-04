import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Radar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Radar extends Vrachoverslaanobjecten
{
    
    public void act() 
    {
       
            if(getY() == 26)
            {
                turn(2);
            }
            else{
                turn(-2);
            }
        
    }  
}
