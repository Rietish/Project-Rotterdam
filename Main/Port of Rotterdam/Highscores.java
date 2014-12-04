import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Highscores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Highscores extends World
{

    /**
     * Constructor for objects of class Highscores.
     * 
     */
    ScoreVrachtoverslaan scoreLabelVO = new ScoreVrachtoverslaan();
    ScoreControleCentrum scoreLabelCC = new ScoreControleCentrum();
    ScoreSleepboot scoreLabelSB = new ScoreSleepboot();
    public Highscores()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 560, 1); 
        taskbar();
        addObject(scoreLabelVO, 491, 144);
        addObject(scoreLabelCC, 491, 164);
        addObject(scoreLabelSB, 491, 184);
        addObject(new KevindeKraanmachinist(), 149, 409);
        Muziekspeler.playSound(1);
    }
    
    void taskbar(){
        addObject(new Taskbar(), 400, 10);
        addObject(new Afsluiten(), 750, 10);
        addObject(new Hoofdmenu(), 650, 10);
    }
    
    
}
