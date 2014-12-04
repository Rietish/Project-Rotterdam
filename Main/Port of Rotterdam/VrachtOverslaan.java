import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; 
import java.util.*;
/**
 * Write a description of class VrachtOverslaan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VrachtOverslaan extends World
{

    /**
     * Constructor for objects of class VrachtOverslaan.
     * 
     */
    int scheepsVracht = 0;
    int scheepsVrachtTegenstander = 0;
    KraanGrijper_tegenstander tegenstander = new KraanGrijper_tegenstander();
    
    Actor MakkelijkKnop = new MakkelijkKnop();
    MakkelijkKnop Makkelijk = (MakkelijkKnop) MakkelijkKnop;
    Actor NormaalKnop = new NormaalKnop();
    NormaalKnop Normaal = (NormaalKnop) NormaalKnop;
    Actor MoeilijkKnop = new MoeilijkKnop();
    MoeilijkKnop Moeilijk = (MoeilijkKnop) MoeilijkKnop;
    
    public VrachtOverslaan()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(50, 42, 20);  
        
        fill();
        taskbar();
        startMenu();
        //objects();
        Muziekspeler.playSound(3);
    }
    
    void fill(){
        for(int y = 0; y < 42; y++){
            for(int x = 0; x < 50; x++){
               
                
                if(y <= 12  || y >= 30){
                    addObject(new Dijk(), x, y);
                }
                
                else if(y == 21){
                    addObject(new Border(), x, y);
                }
               
            }
        }
        
        for(int y = 0; y < 42; y++){
            for(int x = 0; x < 50; x++){
               
                if((y == 3 || y == 39) && x  % 2 == 0){
                    addObject(new Spoor(), x, y);
                }
            }
        }
        
    }
   
    ScoreLabel VrachtOverslaanScore = new ScoreLabel();
    public static HighscoreVrachtOverslaan Highscore = new HighscoreVrachtOverslaan();
    void objects(){
        addObject(new Boot_vrachtoverslaan(),24, 16);
        addObject(new Boot_vrachtoverslaan(),24, 26);
        addObject(new Radar(), 6, 16);
        addObject(new Radar(), 6, 26);
        addObject(new Trein_vrachtoverslaan_tegenstander(), 30, 3);
        addObject(new Trein_vrachtoverslaan(), 30, 39);  
        
        //zet containers neer
        String[][] randomContainers = getRandomContainers(3, 15);
        //Vector startEigenContainers = new Vector(10, 24);
        //Vector startComputerContainers = new Vector(10, 14);
        for(int y = 0; y <= 2; y++)
        {
            for(int x = 0; x <= 14; x++)
            {
                //maak containers tegenstander
                if(randomContainers[x][y] == "container1")
                {
                    addObject(new Container1_tegenstander(), 10 + (2 * x), 18 - (2 * y));
                    scheepsVrachtTegenstander++;
                }
                else if(randomContainers[x][y] == "container2")
                {
                    addObject(new Container2_tegenstander(), 10 + (2 * x) + 1, 18 - (2 * y));
                    scheepsVrachtTegenstander++;
                }
                else if(randomContainers[x][y] == "container3")
                {
                    addObject(new Container3_tegenstander(), 10 + (2 * x) + 2, 18 - (2 * y));
                    scheepsVrachtTegenstander++;
                }
                
                //maak eigen containers
                if(randomContainers[x][y] == "container1")
                {
                    addObject(new Container1(), 10 + (2 * x), 24 + (2 * y));
                    scheepsVracht++;
                }
                else if(randomContainers[x][y] == "container2")
                {
                    addObject(new Container2(), 10 + (2 * x) + 1, 24 + (2 * y));
                    scheepsVracht++;
                }
                else if(randomContainers[x][y] == "container3")
                {
                    addObject(new Container3(), 10 + (2 * x) + 2, 24 + (2 * y));
                    scheepsVracht++;
                }
                
                
            }
        }
             
        /*
         * ROBINS STUKJE VOOR ALS JE HET NOG WILT TERUGZETTEN
        for(int y = 14; y <= 28; y+= 2){
            for(int x = 10; x <= 39; x+= 2){
            if(y >= 14 && y <= 18){
                addObject(new Krat_vrachtoverslaan_tegenstander(), x, y);
            }
            
            if(y >= 24 && y <= 28){
                addObject(new Krat_vrachtoverslaan(), x, y);
            }
        }
        }
        */
        addObject(new BalansBalk(), 46, 26);
        addObject(new AanwijsBalk(), 46, 26);
        
        addObject(new KraanBasis(), 29, 8);
        addObject(new KraanBasis(), 29, 34);
        
        
        addObject(tegenstander, 22, 18);
        addObject(new kraanGrijper(), 22, 24);
        addObject(new KraanXding_tegenstander(), 22, 10);
        addObject(new kraanXding(), 22, 32);
        
        
        
        taskbar();
        addObject(VrachtOverslaanScore, 12, 0);
        VrachtOverslaanScore.scoreReset();
        
        //geef de tegenstander de locaties van de containers mee
        tegenstander.acceptContainerMap(randomContainers);
    }
    
    public String[][] getRandomContainers(int y, int x)
    {          
        //vul array met random containers
        String[][] array = new String[x][y];
        
        for(int a = 0; a < y; a++)
        {
            for(int b = 0; b < x; b++)
            {
                //check eerst welke containers er nog passen
                int maxRandom = 3;
                //nog 3 vakjes over
                if(b == x - 3)
                {
                    maxRandom = 3;
                }
                //nog 2 vakjes over
                else if(b == x - 2)
                {
                    maxRandom = 2;
                }
                //nog 1 vakje over
                else if(b == x - 1)
                {
                    maxRandom = 1;
                }
                //vul random containers in
                int random = Greenfoot.getRandomNumber(maxRandom);
                if(random == 0)
                {
                    array[b][a] = "container1";
                }
                else if(random == 1)
                {
                    array[b][a] = "container2";
                    array[b+1][a] = "empty";
                    b++;
                }
                else if(random == 2)
                {
                    array[b][a] = "container3";
                    array[b+1][a] = "empty";
                    array[b+2][a] = "empty";
                    b += 2;
                }
               
            }
        }
        
        return array;
    }
    
    public int getScheepsVracht(){
        return scheepsVracht;
    }
    
    public void setScheepsVracht(int scheepsVracht){
        this.scheepsVracht = scheepsVracht;
    }
    
    
    public void startMenu(){
        //voegt startMenu toe
        addObject(new StartMenuAchtergrond(), 25, 20);
        addObject(new VrachtOverslaanTekst(), 25, 20);
        addObject(new StartKnop(), 30, 33);
        
        
        addObject(MakkelijkKnop, 19, 30);
        addObject(NormaalKnop, 25, 30);
        addObject(MoeilijkKnop, 31, 30);
        
        Normaal.geklikt();
    }
    
    public void makkelijk(){
        tegenstander.setKraanSnelheid(0.1);
        Makkelijk.geklikt();
        Normaal.undo();
        Moeilijk.undo();
        
    }
    
    public void normaal(){
        tegenstander.setKraanSnelheid(0.2);
        Makkelijk.undo();
        Normaal.geklikt();
        Moeilijk.undo();
    }
    
    public void moeilijk(){
        tegenstander.setKraanSnelheid(0.3);
        Makkelijk.undo();
        Normaal.undo();
        Moeilijk.geklikt();
    }
    
    public void start(){
        objects();
        remove();
    }
    
    private void remove(){
        List startMenu = getObjects(StartMenuObjecten.class);
        removeObjects(startMenu);
    }
    
    void taskbar(){
        addObject(new Taskbar2(), 24, 0);
        addObject(new Afsluiten(), 48, 0);
        addObject(new Hoofdmenu(), 44, 0);
    }
    
    
}

