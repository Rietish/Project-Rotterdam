import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.DecimalFormat;
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Distance extends HighscoresObjecten
{
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    private static int distanceCounter = 0000;
    private static int teller = 0;
    private static String distance = "";
    private static String loodsDistance = distance + "m";
    
    //HighscoreVrachtOverslaan highscore = (HighscoreVrachtOverslaan) getOneObjectAtOffset(4,0,ScoreLabel.class);
    
    public void act() 
    {
       teller++;
       if(teller == 60){
           distanceCounter += 10;
           DecimalFormat formatter = new DecimalFormat("0000");
           String distanceInMeters = formatter.format(distanceCounter);
           distance = distanceInMeters;
           setScore(distance);
           teller = 0;
        }
       if(distanceCounter == 1000){
           VoortgangBalk.setVoortgang(3);
        }
       checkYourself();
    }    
    
    public Distance ()  
    {  
        GreenfootImage img = new GreenfootImage(500, 30);  
        img.setColor(java.awt.Color.white);  
        img.drawString ("Afstand afgelegd: 0000m", 2, 15);  
        setImage(img);  
    }  
    
   public void setScore(String distance)  
   {  
    GreenfootImage img = getImage();  
    img.clear();  
    img.drawString ("Afstand afgelegd: " + distance + "m", 2, 15);  
    }  
    
   public void scoreReset(){
       distanceCounter = 0000;
    }
    
   public void checkYourself(){
       if(ScoreSleepboot.getSleepbootScore() < distanceCounter){
           ScoreSleepboot.setSleepbootScore(distance,distanceCounter);
           
        }
    }
    
   
}
