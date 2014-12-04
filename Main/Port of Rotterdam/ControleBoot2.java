import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControleBoot2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControleBoot2 extends controleBoot
{
    public ControleBoot2()
    {
        setLocation(0, 4);
        currentY = 4.0;
        currentX = 0;
    }
    
    public void act() 
    {
       //currentX += 0.03;
       
       if(getX() >= 49)
       {
           Spawner spawner = (Spawner) getWorld().getObjects(Spawner.class).get(0);
           spawner.setSpawnChance(2, -200);
           getWorld().removeObject(this);
       }
       
       super.act();
    }    
}
