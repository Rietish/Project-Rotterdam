import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LinkLoodsen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkLoodsen extends Links
{
    /**
     * Act - do whatever the LinkLoodsen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image1 = new GreenfootImage("images/link_loodsen.png");
    GreenfootImage image2 = new GreenfootImage("images/link_loodsen_smoke.png");
    
    
    void clicked(){
        if(Greenfoot.mouseClicked(this) == true){
            Greenfoot.setWorld(new Loodsen_Endlessrunner());
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
