import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighscoresTab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighscoresTab extends Taskbar
{
    /**
     * Act - do whatever the HighscoresTab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        pressed();
    }    
    
    public void hover(){
        GreenfootImage button = getImage();
        if(Greenfoot.mouseMoved(this) == true ){
            setImage("images/taskbar_afsluitenHover.png");
        }
        else{
            setImage("images/taskbar_afsluiten.png");
        }
    }
    
    public void pressed(){
        if(Greenfoot.mousePressed(this) == true){
            Greenfoot.setWorld(new Highscores());
            
        }
    } 
}
