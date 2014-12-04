import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerups here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerups extends GespawndeObjecten
{
    /**
     * Act - do whatever the Powerups wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   boolean werken = true;
   Loodsboot deLoods;
   Actor schip;
   
    public void act() 
    {   
        if(go == true){
        moven();
        if(werken == true){
            if(getX() == 0){
                werken = false;
            }
        checkYourself();
            
        }
    }
    }    
    
    public void checkYourself(){
        if(getOneIntersectingObject(Loodsboot.class) != null || getOneIntersectingObject(Vrachtschip.class) != null){
            if(getOneIntersectingObject(Loodsboot.class) != null){
                deLoods = (Loodsboot) getOneIntersectingObject(Loodsboot.class);
            }
            actie();
            remove();
            return;
        }
    }
    
    public void remove(){
        getWorld().removeObject(this);
    }
    
    public void actie(){
    }  
}
