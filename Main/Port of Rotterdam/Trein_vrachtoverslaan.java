import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Trein_vrachtoverslaan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trein_vrachtoverslaan extends Vrachoverslaanobjecten
{
    /**
     * Act - do whatever the Trein_vrachtoverslaan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int load = 0;
    boolean GOAAAN = false;
    double currentX = 0;
    public void act() 
    {
        if(Greenfoot.isKeyDown("t")){
           GOAAAN = true;
        }
        
        if(GOAAAN == true){
            move();
        }
        else{
            place();
        }
        
        
        
    }
    
    
    public void move(){
        for(int y = -1; y <= 1; y+=2){
            for(int x = -13; x <= 14; x += 2){
                Actor container = getOneObjectAtOffset(x,y,Krat_vrachtoverslaan.class);
                if(container != null){
                    getWorld().removeObject(container);
                }
            }
        }
        setImage("images/vrachtoverslaan_treinGesloten.png");
        
        if(getX() == 49){
            VrachtOverslaan wereld = (VrachtOverslaan) getWorld();
            int scheepsVracht = wereld.getScheepsVracht();
            if(scheepsVracht == 0){
                VrachtOverslaan dezeWereld = (VrachtOverslaan) getWorld();
                VoortgangBalk.setVoortgang(1);

                if(ScoreLabel.minutenGetal <= ScoreVrachtoverslaan.minutenGetal){
                    if(ScoreLabel.minutenGetal == ScoreVrachtoverslaan.minutenGetal  && ScoreLabel.secondenGetal < ScoreVrachtoverslaan.secondenGetal){
                    ScoreVrachtoverslaan.setVrachtOverslaanScore(ScoreLabel.vrachtOverslaanScore);
                    }
                    else{
                    ScoreVrachtoverslaan.setVrachtOverslaanScore(ScoreLabel.vrachtOverslaanScore);   
                    }
                    
                }
                
                int reply = JOptionPane.showConfirmDialog(null, "Gefeliciteerd u heeft gewonnen! Wilt u nog een keer spelen?", "Gewonnen!", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION){
                    getWorld().removeObject(this);
                    Greenfoot.setWorld(new VrachtOverslaan());
                    return;
                }
                else if(reply == JOptionPane.NO_OPTION){
                    Greenfoot.setWorld(new Menu());
                    return;
                }
                
                
            }
            
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
        if(getX() == 29){
            // trein is 30,39
            
            //grijper linker bovenhoek = 10,24
            //grijper rechter onderhoek = 48,40
            /*for(int y = -15; y <= 1; y++){
                for(int x = -19; x <= 19; x++){
                    Actor deGrijper = getOneObjectAtOffset(x,y,kraanGrijper.class);
                    
                    if(deGrijper != null){
                        int grijperX = deGrijper.getX();
                        int grijperY = deGrijper.getY();
                        getWorld().removeObject(deGrijper);
                        getWorld().addObject(new kraanGrijper(),grijperX,grijperY);
                        
                        
                        break;
                    }
                }
            }*/
            //kraan links = 10,32
            //kraan rechts = 48,32
            /*for(int x = -20; x <= 18; x++){
                Actor deKraan = getOneObjectAtOffset(x,-7, kraanXding.class);
                
                if(deKraan != null){
                    int kraanX = deKraan.getX();
                    int kraanY = deKraan.getY();
                    getWorld().removeObject(deKraan);
                    getWorld().addObject(new kraanXding(), kraanX, kraanY);
                }
            }*/
            
        }
        setLocation((int)currentX, getY());
    }
    
    }

