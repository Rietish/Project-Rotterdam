import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wreckage_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wreckage extends Obstakels
{
    /**
     * Act - do whatever the Wreckage_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
    */  
    
    public Wreckage(){
        int imageKans = Greenfoot.getRandomNumber(2);
        if(imageKans == 0){
            setImage("images/wreckage01.png");
        }
        else{
            setImage("images/wreckage_2.png");
        }
    
    }
}
