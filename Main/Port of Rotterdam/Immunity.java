import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Immunity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Immunity extends Powerups
{
    /**
     * Act - do whatever the Immunity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void actie(){
        Loodsboot.setKwetsbaar(false);
        Vrachtschip.setKwetsbaar(false);
    }  
}
