import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Win extends MenuObjecten
{
    /**
     * Act - do whatever the Win wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int teller = 0;
    public void act() 
    {
       tellen();
    }    
    
    public void tellen(){
        if(teller == 1000){
            getWorld().removeObject(this);
        }
    }
}
