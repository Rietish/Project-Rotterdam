import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    GreenfootSound achtergrondGeluid = new GreenfootSound("sounds/background.wav");
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 560, 1); 
        setPaintOrder(Links.class,MenuObjecten.class);
        links();
        taskbar();
        fill();
        Muziekspeler.playSound(2);
    }
    
    void taskbar(){
        addObject(new Taskbar(), 400, 10);
        addObject(new Afsluiten(), 750, 10);
        addObject(new HighscoresTab(), 682, 12);
    }
    
    void links(){
        addObject(new LinkVrachtOverslaan(), 290, 195);
        addObject(new LinkControleKamer(), 713, 330);
        addObject(new LinkLoodsen(),560,210);
    }
    
    void fill(){
        addObject(new PortOfRotterdam(),66,525);

        addObject(new Scheepje(),297,28);
        addObject(new VoortgangBalk(),409,519);
        addObject(new Sound(),40,67);
    }
}
