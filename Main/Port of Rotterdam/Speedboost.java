import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speedboost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speedboost extends Powerups
{
    /**
     * Act - do whatever the Speedboost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Speedboost(){
        turn(180);
    }
    
    public void actie(){
        Loodsboot.setSpeedboost(true);
    
    }
}
