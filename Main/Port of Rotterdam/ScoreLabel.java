import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.DecimalFormat;

/**
 * Write a description of class ScoreLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ScoreLabel extends HighscoresObjecten  
{  
    static int secondenGetal = 00;
    static int minutenGetal = 00;
    static int teller = 0;
    static String vrachtOverslaanScore = "";
    static String controleCentrumScore = "";
    
    //HighscoreVrachtOverslaan highscore = (HighscoreVrachtOverslaan) getOneObjectAtOffset(4,0,ScoreLabel.class);
    
    public void act() 
    {
       teller++;
       if(teller == 60){
           secondenGetal ++;
           if(secondenGetal == 60){
               minutenGetal++;
               secondenGetal = 0;
            }
           DecimalFormat formatter = new DecimalFormat("00");
           String seconden = formatter.format(secondenGetal);
           String minuten = formatter.format(minutenGetal);
           vrachtOverslaanScore = minuten + ":" + seconden;
           controleCentrumScore = minuten + ":" + seconden;
           setScore(minuten, seconden);
           teller = 0;
        }
        
        String worldType = "" + getWorld();
       if(worldType.contains("Controlecentrum")){
           checkScore();
        }
    }    
    
    public ScoreLabel ()  
    {  
        GreenfootImage img = new GreenfootImage(500, 30);  
        img.setColor(java.awt.Color.white);  
        img.drawString ("Tijd: 00:00", 2, 15);  
        setImage(img);  
    }  
    
   public void setScore(String minuten, String seconden)  
   {  
    GreenfootImage img = getImage();  
    img.clear();  
    img.drawString ("Tijd: " + minuten + ":" + seconden, 2, 15);  
    }  
    
   public String getScore(){
       return vrachtOverslaanScore;
    }
    
   public int getMinuten(){
       return minutenGetal;
    }
    
   public int getSeconden(){
       return secondenGetal;
    }
    
   public void scoreReset(){
       secondenGetal = 00;
       minutenGetal = 00;
    }
    
   private void checkScore(){
       if((minutenGetal > ScoreControleCentrum.minutenGetal) || (minutenGetal == ScoreControleCentrum.minutenGetal && secondenGetal > ScoreControleCentrum.secondenGetal)){
           ScoreControleCentrum.setControleCentrumScore(controleCentrumScore);
           ScoreControleCentrum.minutenGetal = this.minutenGetal;
           ScoreControleCentrum.secondenGetal = this.secondenGetal;
        }
       if(minutenGetal == 2 && secondenGetal == 0){
           VoortgangBalk.setVoortgang(2);
        }
    }
    
   
    
   
   
}  
