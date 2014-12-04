import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kraanGrijper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class kraanGrijper extends Vrachoverslaanobjecten
{
    /**
     * Act - do whatever the kraanGrijper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean opgepakt = false;
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo(); 
        int grijperx = getX();
        int grijpery = getY();
        
        int mx = 0;
        int my = 0;
        if(mouse!=null){  
           mx = mouse.getX();  
           my = mouse.getY();  
        }  
        
        //check of de grijper binnen het domein valt, dan zet de positie van de grijper
        if(mx <= 48 && mx >= 10)
        {
            setLocation(mx, getY());
        }
        if(my <= 40 && my >= 24)
        {
            setLocation(getX(), my);
        }
    }    
    
    public void setOpgepakt(boolean input){
        opgepakt = input;
    }
    
    public boolean getOpgepakt(){
        return opgepakt;
    }
}
