import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControleBoot1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControleBoot1 extends controleBoot
{    
    public ControleBoot1()
    {
        setLocation(0, 2);
        currentY = 2.0;
        currentX = 0;
    }
    
    public void act() 
    {
       //currentX += 0.02;
       
       if(getX() >= 49)
       {
           Spawner spawner = (Spawner) getWorld().getObjects(Spawner.class).get(0);
           spawner.setSpawnChance(1, -200);
           getWorld().removeObject(this);
       } 
       
       super.act();
    }    
}
