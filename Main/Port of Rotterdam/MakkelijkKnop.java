import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MakkelijkKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MakkelijkKnop extends StartKnoppen
{
    /**
     * Act - do whatever the MakkelijkKnop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String worldType = "" + getWorld();
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
            deWorld.makkelijk();
        }
        else if(worldType.contains("Controlecentrum")){
            Controlecentrum deWorld = (Controlecentrum) getWorld();
            deWorld.makkelijk();
        }
        else if(worldType.contains("Loodsen_Endlessrunner")){
            Loodsen_Endlessrunner deWorld = (Loodsen_Endlessrunner) getWorld();
            deWorld.makkelijk();
        }

    }
    
    public void geklikt(){
        setImage("images/MakkelijkGeklikt.png");
    }
    
    public void undo(){
        setImage("images/Makkelijk.png");
    }
}
