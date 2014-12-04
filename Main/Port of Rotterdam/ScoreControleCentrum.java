import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.DecimalFormat;
/**
 * Write a description of class ScoreControleCentrum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreControleCentrum extends HighscoresObjecten
{
    /**
     * Act - do whatever the ScoreControleCentrum wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   private static String controleCentrumScore = "00:00";
    static int secondenGetal = 00;
    static int minutenGetal = 00;
    
    public void act() 
    {
       DecimalFormat formatter = new DecimalFormat("00");
       String seconden = formatter.format(secondenGetal);
       String minuten = formatter.format(minutenGetal);
       
       setScore(controleCentrumScore);
    }    
    public ScoreControleCentrum ()  
    {  
        GreenfootImage img = new GreenfootImage(500, 30);  
        img.setColor(java.awt.Color.white);  
        img.drawString ("Uw beste tijd in controle centrum: 00:00", 2, 15);  
        setImage(img);  
    }  
    
    public static void setControleCentrumScore(String deScore){
        controleCentrumScore = deScore;
    
    }
    
   public void setScore(String vrachtOverslaanScore)  
   {  
    GreenfootImage img = getImage();  
    img.clear();  
    img.drawString ("Uw beste tijd in controle centrum: " + controleCentrumScore, 2, 15);  
    }    
}
