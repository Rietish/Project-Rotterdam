import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound extends MenuObjecten
{
    /**
     * Act - do whatever the Sound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Sound(){
        if(Muziekspeler.getSpelen() == true){
            setImage("images/sound.png");
        }
        else{
            setImage("images/nosound.png");
        }
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            if(Muziekspeler.getSpelen() == true){
            Muziekspeler.setSpelen(false);
            setImage("images/nosound.png");
        }
        else{
            Muziekspeler.setSpelen(true);
            setImage("images/sound.png");
        }
        
        }
    }
}
