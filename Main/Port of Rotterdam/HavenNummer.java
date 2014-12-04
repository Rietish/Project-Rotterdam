import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HavenNummer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HavenNummer extends controleHavenObjecten
{
    public HavenNummer(String nummer)
    {
        GreenfootImage img = new GreenfootImage(20, 20);  
        img.setColor(java.awt.Color.white);  
        img.drawString (nummer, 2, 15);  
        setImage(img); 
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
