import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartKnop extends StartKnoppen
{
    /**
     * Act - do whatever the StartKnop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        klikje();
    }    
    
    private void klikje(){
        if(Greenfoot.mouseClicked(this)){
            actie();
        }
    }
    
    
    public void actie(){
        String worldType = " " + getWorld();
        if(worldType.contains("VrachtOverslaan")){
            VrachtOverslaan deWorld = (VrachtOverslaan) getWorld();
            deWorld.start();
        }
        else if(worldType.contains("Controlecentrum")){
            Controlecentrum deWorld = (Controlecentrum) getWorld();
            deWorld.start();
        }
        else if(worldType.contains("Loodsen_Endlessrunner")){
            Loodsen_Endlessrunner deWorld = (Loodsen_Endlessrunner) getWorld();
            deWorld.start();
        }
    }  
}
