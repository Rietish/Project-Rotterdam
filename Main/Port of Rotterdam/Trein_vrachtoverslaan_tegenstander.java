import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trein_vrachtoverslaan_tegenstander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trein_vrachtoverslaan_tegenstander extends Vrachoverslaanobjecten
{
    /**
     * Act - do whatever the Trein_vrachtoverslaan_tegenstander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean GOAAAN = false;
    boolean isInStation = false;
    double currentX = 0;
    public void act() 
    {
        if(GOAAAN == true){
            move();
        }
        else{
            place();
        }
        if(getX() == 30)
        {
            isInStation = true;
        }
        
    }    
    
    public void gaRijden()
    {
        GOAAAN = true;
    }
    
    public boolean isAanHetRijden()
    {
        return GOAAAN;
    }
    
    public boolean isInStation()
    {
        return isInStation;
    }
    
    public void move(){
        isInStation = false;
        for(int y = -1; y <= 1; y+=2){
            for(int x = -13; x <= 14; x += 2){
                Actor container = getOneObjectAtOffset(x,y,Krat_vrachtoverslaan_tegenstander.class);
                if(container != null){
                    getWorld().removeObject(container);
                }
            }
        }
        setImage("images/vrachtoverslaan_treinGesloten.png");
        
        if(getX() == 49){
            currentX = 0;
            //getWorld().addObject(new Trein_vrachtoverslaan(),0, 3);
            
            GOAAAN = false;
        }
        else{
            currentX += 0.1;
        }
        setLocation((int)currentX, getY());
    }
     
    void place(){
        setImage("images/vrachtoverslaan_trein.png");
        if(getX() < 30){
            currentX += 0.1;
        }
        setLocation((int)currentX, getY());
    }
}