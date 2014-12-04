import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LinkVrachtOverslaan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkVrachtOverslaan extends Links
{
    /**
     * Act - do whatever the LinkVrachtOverslaan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image1 = new GreenfootImage("images/link_vracht_overslaan_mirror.png");
    GreenfootImage image2 = new GreenfootImage("images/link_vracht_overslaan.png");
    
    void clicked(){
        if(Greenfoot.mouseClicked(this) == true){
            Greenfoot.setWorld(new VrachtOverslaan());
        }
    }
    
    
    void tellen(){
        teller++;
        if(teller == 20){
            setImage(image1);
        }
        else if(teller == 40){
            setImage(image2);
            teller=0;
        }
    }
}
