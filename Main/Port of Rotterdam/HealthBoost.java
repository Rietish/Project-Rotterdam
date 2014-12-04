import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBoost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBoost extends Powerups
{
    /**
     * Act - do whatever the HealthBoost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void actie(){
        HealthBar.setLevens(+1);
    }
}
