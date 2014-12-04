import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.DecimalFormat;
/**
 * Write a description of class ScoreSleepboot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreSleepboot extends HighscoresObjecten
{
    /**
     * Act - do whatever the ScoreSleepboot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private static String distance = "0000";
    private static int distanceCounter = 0000;
    public void act() 
    {
       DecimalFormat formatter = new DecimalFormat("00");
       String distanceInMeters = formatter.format(distanceCounter);
       
       setScore(distance);
    }    
    public ScoreSleepboot ()  
    {  
        GreenfootImage img = new GreenfootImage(500, 30);  
        img.setColor(java.awt.Color.white);  
        img.drawString ("Uw verst afgelegde afstand in Sleepboot: " + distance + "m", 2, 15);  
        setImage(img);  
    }  
    
    public static void setSleepbootScore(String deScore, int distanceCount){
        distance = deScore;
        distanceCounter = distanceCount;
    }
    
   public void setScore(String vrachtOverslaanScore)  
   {  
    GreenfootImage img = getImage();  
    img.clear();  
    img.drawString ("Uw verst afgelegde afstand in Sleepboot: " + distance + "m", 2, 15);  
    }       
    
    public static int getSleepbootScore(){
        return distanceCounter;
    }
}
