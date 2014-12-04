import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControleBoot3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControleBoot3 extends controleBoot
{
    public ControleBoot3()
    {
        setLocation(0, 6);
        currentY = 6.0;
        currentX = 0;
    }
    
    public void act() 
    {
       //currentX += 0.04;
       
       if(getX() >= 49)
       {
           Spawner spawner = (Spawner) getWorld().getObjects(Spawner.class).get(0);
           spawner.setSpawnChance(3, -200);
           getWorld().removeObject(this);
       }
       
       super.act();
    }    
}
