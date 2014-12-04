import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoegNummer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoegNummer extends controleHavenObjecten
{
    public BoegNummer()
    {
        GreenfootImage img = new GreenfootImage(1, 1);  
        img.setColor(java.awt.Color.black);  
        img.drawString ("", 2, 15);  
        setImage(img); 
    }
    
    public void act() 
    {
        
    }    
    
    public void setPosition(int x, int y)
    {
        setLocation(x, y);
    }
    
    public void setBoegNummer(String nummer)
    {
        GreenfootImage img = new GreenfootImage(20, 20);  
        img.setColor(java.awt.Color.black);  
        img.drawString (nummer, 2, 15);  
        setImage(img); 
    }
}
