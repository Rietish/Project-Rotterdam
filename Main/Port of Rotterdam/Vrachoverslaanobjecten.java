import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Vrachoverslaanobjecten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vrachoverslaanobjecten extends Actor
{
    private Boot_vrachtoverslaan _eigenBoot = null;
    
    Boot_vrachtoverslaan EigenBoot ()
    {
        if (_eigenBoot == null)
        {
            List<Boot_vrachtoverslaan> bootList = getWorld().getObjects(Boot_vrachtoverslaan.class);
            Actor eigenBootActor = bootList.get(0);
            _eigenBoot = (Boot_vrachtoverslaan) eigenBootActor;
           
        }
        return _eigenBoot;
    }
    
    /**
     * Act - do whatever the Vrachoverslaanobjecten wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //static int eigenBalans = 0;
    //Actor balansBalkActor = getOneObjectAtOffset(46, 26, BalansBalk.class);
    //BalansBalk balansBalk = (BalansBalk) balansBalkActor;
    //Actor aanwijsBalkActor = getOneObjectAtOffset(46, 26, AanwijsBalk.class);
    //AanwijsBalk aanwijsBalk = (AanwijsBalk) aanwijsBalkActor;
    public void act() 
    {
        // Add your action code here.
    }    
    
    
}
