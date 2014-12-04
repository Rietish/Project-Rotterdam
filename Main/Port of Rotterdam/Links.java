import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Links here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Links extends Actor
{
    /**
     * Act - do whatever the Links wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int teller = 0;
    GreenfootImage image1;
    GreenfootImage image2;
    public void act() 
    {
        clicked();
        tellen();
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
    
    void clicked(){
        Greenfoot.setWorld(new VrachtOverslaan());
    }
}
