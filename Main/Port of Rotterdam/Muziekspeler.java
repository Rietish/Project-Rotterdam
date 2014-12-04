import greenfoot.*;
/**
 * Write a description of class Muziekspeler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Muziekspeler
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Muziekspeler
     */
    public Muziekspeler()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    private static GreenfootSound startmenu = new GreenfootSound("sounds/intro.wav");
    private static GreenfootSound menu = new GreenfootSound("sounds/background.wav");
    private static GreenfootSound control = new GreenfootSound("sounds/control.wav");
    private static GreenfootSound sleepboot = new GreenfootSound("sounds/sleepboot.wav");
    private static GreenfootSound vrachtoverslaan = new GreenfootSound("sounds/vrachtoverslaan.wav");
    private static boolean spelen = true;
    public static void playSound(int nummer){
        if(spelen == true){
        switch(nummer){
            case 1:
                control.stop();
                sleepboot.stop();
                vrachtoverslaan.stop();
                menu.stop();
                startmenu.playLoop();
                startmenu.setVolume(80);
                break;
            
            case 2:
                startmenu.stop();
                control.stop();
                sleepboot.stop();
                vrachtoverslaan.stop();
                menu.playLoop();
                menu.setVolume(50);
                break;
                
            case 3:
                startmenu.stop();
                control.stop();
                sleepboot.stop();
                menu.stop();
                vrachtoverslaan.playLoop();
                vrachtoverslaan.setVolume(100);
                break;
            
            case 4:
                startmenu.stop();
                sleepboot.stop();
                menu.stop();
                vrachtoverslaan.stop();
                control.playLoop();
                control.setVolume(100);
                break;
                
            case 5:
                startmenu.stop();
                menu.stop();
                vrachtoverslaan.stop();
                control.stop();
                sleepboot.playLoop();
                sleepboot.setVolume(90);
                break;
                
                
                
        }
    }
    }
    
    public static void setSpelen(boolean gaan){
        spelen = gaan;
        if(gaan == false){
             startmenu.stop();
                sleepboot.stop();
                menu.stop();
                vrachtoverslaan.stop();
                control.stop();
        }
        else{
            startmenu.stop();
                control.stop();
                sleepboot.stop();
                vrachtoverslaan.stop();
                menu.playLoop();
                menu.setVolume(50);
        }
    }
    
    public static boolean getSpelen(){
        return spelen;
    }
    
}
