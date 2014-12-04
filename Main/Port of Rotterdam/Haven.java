import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Haven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Haven extends controleHavenObjecten
{
    public int havenID;
    public boolean bootInHaven = false;
    
    public Haven(int ID)
    {
       havenID = ID;
    }
    public void act() 
    {
        /*
        if(Greenfoot.mouseClicked(this))
        {
            List<controleBoot> boten = getWorld().getObjects(controleBoot.class);
            for(int i = 0; i < boten.size(); i++)
            {
                controleBoot dezeBoot = boten.get(i);
                if(dezeBoot.isGeklikt())
                {
                    //zet destination voor de boot
                    dezeBoot.setDestinationID(getID());
                    
                    //zet boegnummer
                    
                    
                }
            }
        }
        */
    }
    
    public int getID()
    {
        return havenID;
    }
    
    public void setBootInHaven(boolean a)
    {
        if(a == true)
        {
            bootInHaven = true;
        }
        else
        {
            bootInHaven = false;
        }
    }
    
    public boolean isBootInHaven()
    {
        return bootInHaven;
    }
    
    /*public int getXPosition(int id)
    {
        if(havenID == id)
        {
            return 
        }
    }*/
    
}
