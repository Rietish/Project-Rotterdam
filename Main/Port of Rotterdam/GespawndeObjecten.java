import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GespawndeObjecten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GespawndeObjecten extends LoodsenEndlessRunnerObjecten
{
    /**
     * Act - do whatever the GespawndeObjecten wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int mover = 0;
    static boolean go = false;
    public void act() 
    {
        if(go == true){
        moven();
    }
    }    
    
    public void moven(){
        mover++;
        if(mover == 15){
            setLocation(getX()-1,getY());
            mover = 0;
            if(getX() == -10){
                getWorld().removeObject(this);
            }
        }
    }
    
    public static void setGo(boolean start){
        go = start;
    }
}
