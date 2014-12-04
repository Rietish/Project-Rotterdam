import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormaalKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormaalKnop extends StartKnoppen
{
    /**
     * Act - do whatever the NormaalKnop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String worldType = "" + getWorld();
    VrachtOverslaan vrachtOverslaanWereld = (VrachtOverslaan) getWorld();
    Controlecentrum controleCentrumWereld = (Controlecentrum) getWorld();
    public void act() 
    {
        klikje();

    }    
    
    private void klikje(){
        if(Greenfoot.mouseClicked(this)){
            actie();
        }
    }
    private void actie(){
        String worldType = " " + getWorld();
        if(worldType.contains("VrachtOverslaan")){
            VrachtOverslaan deWorld = (VrachtOverslaan) getWorld();
            deWorld.normaal();
        }
        else if(worldType.contains("Controlecentrum")){
            Controlecentrum deWorld = (Controlecentrum) getWorld();
            deWorld.normaal();
        }
        else if(worldType.contains("Loodsen_Endlessrunner")){
            Loodsen_Endlessrunner deWorld = (Loodsen_Endlessrunner) getWorld();
            deWorld.normaal();
        }
    } 
    
    public void geklikt(){
        setImage("images/NormaalGeklikt.png");
    }
    
    public void undo(){
        setImage("images/Normaal.png");
    }
}
