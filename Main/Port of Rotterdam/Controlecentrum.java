import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Controlecentrum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlecentrum extends World
{

    /**
     * Constructor for objects of class Controlecentrum.
     * 
     */
    ScoreLabel ControlecentrumScore = new ScoreLabel();
    
    Actor MakkelijkKnop = new MakkelijkKnop();
    MakkelijkKnop Makkelijk = (MakkelijkKnop) MakkelijkKnop;
    Actor NormaalKnop = new NormaalKnop();
    NormaalKnop Normaal = (NormaalKnop) NormaalKnop;
    Actor MoeilijkKnop = new MoeilijkKnop();
    MoeilijkKnop Moeilijk = (MoeilijkKnop) MoeilijkKnop;
    
    Actor spawner = new Spawner();
    Spawner spawnerObject = (Spawner) spawner;
    
    public Controlecentrum()
    {
        super(50, 42, 20); 
        fill();
        taskbar();
        //objects();
        setPaintOrder(BoegNummer.class, Loodser.class, controleBoot.class);
        startMenu();
        Muziekspeler.playSound(4);
    }
    
     void objects()
    {
        
        addObject(ControlecentrumScore, 12, 0);
        ControlecentrumScore.scoreReset();
        addObject(spawner, 24, 41);
        
        //zet havens neer + havennummers + Loodser
        Haven haven1 = new Haven(1);
        addObject(haven1, 2, 37);
        addObject(new HavenNummer("1"), 2, 38);
        addObject(new Loodser(2, 40, 1), 2, 40);
        
        Haven haven2 = new Haven(2);
        addObject(haven2, 11, 37);
        haven2.setImage("images/HavenRechts.png");
        addObject(new HavenNummer("2"), 11, 38);
        addObject(new Loodser(11, 40, 2), 11, 40);
        
        Haven haven3 = new Haven(3);
        addObject(haven3, 14, 37);
        addObject(new HavenNummer("3"), 14, 38);
        addObject(new Loodser(14, 40, 3), 14, 40);
        
        Haven haven4 = new Haven(4);
        addObject(haven4, 23, 37);
        haven4.setImage("images/HavenRechts.png");
        addObject(new HavenNummer("4"), 23, 38);
        addObject(new Loodser(23, 40, 4), 23, 40);
        
        Haven haven5 = new Haven(5);
        addObject(haven5, 26, 37);
        addObject(new HavenNummer("5"), 26, 38);
        addObject(new Loodser(26, 40, 5), 26, 40);
        
        Haven haven6 = new Haven(6);
        addObject(haven6, 35, 37);
        haven6.setImage("images/HavenRechts.png");
        addObject(new HavenNummer("6"), 35, 38);
        addObject(new Loodser(35, 40, 6), 35, 40);
        
        Haven haven7 = new Haven(7);
        addObject(haven7, 38, 37);
        addObject(new HavenNummer("7"), 38, 38);
        addObject(new Loodser(38, 40, 7), 38, 40);
        
        Haven haven8 = new Haven(8);
        addObject(haven8, 47, 37);
        haven8.setImage("images/HavenRechts.png");
        addObject(new HavenNummer("8"), 47, 38);
        addObject(new Loodser(47, 40, 8), 47, 40);
    }
    
    
    /* maakt controlehaven  */
    void fill(){
        //"Gate" naar haven //
        
        for (int y = 16; y < 17; y++){
            for(int x = 0; x < 28; x++){
                addObject(new controleHaven(), x, y);
            }
        }
        
        for (int y = 16; y < 17; y++){
            for(int x = 39; x < 50; x++){
                addObject(new controleHaven(), x, y);
            }
        }
        
        /* "onderste stuk" */
        for (int y = 41; y < 45; y++){
            for(int x = 0; x < 52; x++){
                 addObject(new controleHaven(), x, y);
               
                }
            }
       
           // van havens van links naar rechts//
       for (int y = 33; y < 43; y++){
            for(int x = 0; x < 2; x++){
                addObject(new controleHaven(), x, y);

            }
        }
        
           
           for (int y = 33; y < 43; y++){
            for(int x = 12; x < 14; x++){
                addObject(new controleHaven(), x, y);

            }
        }
       
          
        for (int y = 33; y < 43; y++){
            for(int x = 24; x < 26; x++){
               addObject(new controleHaven(), x, y);

            }
        }
           
        
        for (int y = 33; y < 43; y++){
            for(int x = 36; x < 38; x++){
                addObject(new controleHaven(), x, y);

            }
        }
        
        
        for (int y = 33; y < 43; y++){
            for(int x = 48; x < 51; x++){
                addObject(new controleHaven(), x, y);

            }
        }
        
      }
      
      public void startMenu(){
        //voegt startMenu toe
        addObject(new StartMenuAchtergrond(), 25, 20);
        addObject(new ControleCentrumTekst(), 25, 20);
        addObject(new StartKnop(), 30, 33);
        
      
        
        addObject(MakkelijkKnop, 19, 30);
        addObject(NormaalKnop, 25, 30);
        addObject(MoeilijkKnop, 31, 30);
        
        Normaal.geklikt();
    }
    
    public void makkelijk(){
        
        Makkelijk.geklikt();
        Normaal.undo();
        Moeilijk.undo();
        
        spawnerObject.setDifficulty(800,800,800);
        
    }
    
    public void normaal(){
        
        Makkelijk.undo();
        Normaal.geklikt();
        Moeilijk.undo();
        
        spawnerObject.setDifficulty(600,600,600);
    }
    
    public void moeilijk(){
        
        Makkelijk.undo();
        Normaal.undo();
        Moeilijk.geklikt();
        
        spawnerObject.setDifficulty(300,300,300);
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
 
