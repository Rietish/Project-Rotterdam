import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kraanXding here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class kraanXding extends Vrachoverslaanobjecten
{
    /**
     * Act - do whatever the kraanXding wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         MouseInfo mouse = Greenfoot.getMouseInfo(); 
        
        int mx = 0;
        int my = 0;
        if(mouse!=null){  
           mx = mouse.getX();   
        }  
        
        //check of de grijper binnen het domein valt, dan zet de positie van de grijper
        if(mx <= 48 && mx >= 10)
        {
            setLocation(mx, getY());
        }
    }  
    
    public kraanXding(){
        turn(180);
    }
}
