import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class obstakels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstakels extends GespawndeObjecten
{
    /**
     * Act - do whatever the obstakels wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean werken = true;
    public void act() 
    {
        if (go == true){
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
        if(getOneIntersectingObject(Loodsboot.class) != null || getOneIntersectingObject(Vrachtschip.class) != null ){
            if(Loodsboot.getKwetsbaar() == true && Vrachtschip.getKwetsbaar() == true){
            actie();
            remove();
            return;
            }
            else{
                remove();
                return;
            }
        }
    }
    
    public void remove(){
        getWorld().removeObject(this);
    }
    
    public void actie(){
        HealthBar.setLevens(-1);
    }
}
