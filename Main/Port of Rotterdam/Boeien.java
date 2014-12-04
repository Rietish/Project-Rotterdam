import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boeien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boeien extends Obstakels
{
    /**
     * Act - do whatever the boeien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    
    public Boeien(){
        int imageKans = Greenfoot.getRandomNumber(2);
        if(imageKans == 0){
            setImage("images/Boeien_1.png");
        }
        else{
            setImage("images/Boeien_2.png");
        }
    }
    
    
}
