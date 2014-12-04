import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Loodsen_Endlessrunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loodsen_Endlessrunner extends World
{
    
    /**
     * Constructor for objects of class Loodsen_Endlessrunner.
     * 
     */
    Distance loodsDistance = new Distance();
    Actor MakkelijkKnop = new MakkelijkKnop();
    MakkelijkKnop Makkelijk = (MakkelijkKnop) MakkelijkKnop;
    Actor NormaalKnop = new NormaalKnop();
    NormaalKnop Normaal = (NormaalKnop) NormaalKnop;
    Actor MoeilijkKnop = new MoeilijkKnop();
    MoeilijkKnop Moeilijk = (MoeilijkKnop) MoeilijkKnop;
    public Loodsen_Endlessrunner()
    {    
        super(50,42,20,false);
        taskbar();
        fill();
        setPaintOrder(StartMenuObjecten.class,Distance.class,Afsluiten.class,Hoofdmenu.class,Taskbar2.class,HealthBar.class,Loodsboot.class,Vrachtschip.class,Kant.class,HealthBoost.class,Immunity.class, Speedboost.class, Boeien.class, Wreckage.class, Ondiepwater.class, Water.class);
        startMenu();
        GespawndeObjecten.setGo(false);
        Muziekspeler.playSound(5);
    }
    
    void taskbar(){
        addObject(new Taskbar2(), 24, 0);
        addObject(new Afsluiten(), 48, 0);
        addObject(new Hoofdmenu(), 44, 0);
    }
    
    private void fill(){
        for(int y = 0; y < 42; y++){
            for(int x = -1; x <= 59; x++){
                if((y == 2 || y == 39) && (x%2 == 0 || x == 50)){
                    addObject(new Kant(),x,y);
                }
                if((y >= 9 && y <= 39) && (y %10 == 9 && (x % 10 == 9 || x == -1))){
                    addObject(new Water(),x,y);
                }
            }
        }
        
    }
    
    private void objects(){
        addObject(new Vrachtschip(5.0, 20.0), 5, 20);
        addObject(new Loodsboot(13.0,20.0), 13, 20);
        addObject(new HealthBar(), 45, 2);
        addObject(loodsDistance, 12, 0);
        loodsDistance.scoreReset();
        
        for(int y= 0; y < 42; y++){
            addObject(new SpawnerLoodsen(),49,y);
        }
    }
    
    public void startMenu(){
        //voegt startMenu toe
        addObject(new StartMenuAchtergrond(), 25, 20);
        addObject(new SleepbootTekst(), 25, 20);
        addObject(new StartKnop(), 30, 33);
        
        
        addObject(MakkelijkKnop, 19, 30);
        addObject(NormaalKnop, 25, 30);
        addObject(MoeilijkKnop, 31, 30);
        
        Normaal.geklikt();
    }
    
    public void makkelijk(){
        HealthBar.setDifficulty(3);
        Makkelijk.geklikt();
        Normaal.undo();
        Moeilijk.undo();
        
    }
    
    public void normaal(){
        HealthBar.setDifficulty(2);
        Makkelijk.undo();
        Normaal.geklikt();
        Moeilijk.undo();
    }
    
    public void moeilijk(){
        HealthBar.setDifficulty(1);
        Makkelijk.undo();
        Normaal.undo();
        Moeilijk.geklikt();
    }
    
    public void start(){
        objects();
        remove();
        GespawndeObjecten.setGo(true);
    }
    
    private void remove(){
        List startMenu = getObjects(StartMenuObjecten.class);
        removeObjects(startMenu);
    }
}
