import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boot_vrachtoverslaan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boot_vrachtoverslaan extends Vrachoverslaanobjecten
{
    /**
     * Act - do whatever the Boot_vrachtoverslaan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int eigenBalans = 0;
    public void act() 
    {
        /*entrance();*/
    } 
    
    /*void entrance(){
        if(getX() < 10){
            setLocation(getX()+1, getY());
        }
    }*/
    
    public int getBalans()
    {
        return this.eigenBalans;
    }
    
    public void setBalans(int verschil)
    {
        this.eigenBalans += verschil;
        getWorld().removeObjects(getWorld().getObjects(AanwijsBalk.class));
        getWorld().addObject(new AanwijsBalk(), 46, 26 + getBalans() / 2);
    }
}
