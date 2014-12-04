import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighscoreVrachtOverslaan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighscoreVrachtOverslaan extends Vrachoverslaanobjecten
{
    /**
     * Act - do whatever the HighscoreVrachtOverslaan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int highscoreMinuten = 99;
    int highscoreSeconden = 99;
    String deScore = "";
    
    public HighscoreVrachtOverslaan ()  
    {  
        GreenfootImage img = new GreenfootImage(500, 30);  
        img.setColor(java.awt.Color.white);  
        img.drawString ("Highscore: 00:00", 2, 15);  
        setImage(img);  
    }  
    
   public void setScore(String vrachtOverslaanScore)  
   {  
    GreenfootImage img = getImage();  
    img.clear();  
    deScore = vrachtOverslaanScore;
    img.drawString ("Highscore: " + vrachtOverslaanScore, 2, 15); 
    }   
    
   public int getMinuten(){
       return highscoreMinuten;
    }
    
   public int getSeconden(){
       return highscoreSeconden;
    }
    
  
}
