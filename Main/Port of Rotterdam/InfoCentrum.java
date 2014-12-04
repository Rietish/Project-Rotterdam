import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class InfoCentrum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfoCentrum extends controleHavenObjecten
{
    public int spawnChance1 = 300;
    public int spawnChance2 = 300;
    public int spawnChance3 = 300;
    
    public void act() 
    {
        if(Greenfoot.getRandomNumber(spawnChance1) == 1)
        {
            getWorld().addObject(new ControleBoot1(), 0, 4);
        }
    }  
}
