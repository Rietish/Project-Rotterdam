import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends LoodsenEndlessRunnerObjecten
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private static int difficulty = 3;
    private  static int  levens = 3;
    private  GreenfootImage hart1 = new GreenfootImage("images/1live.png");
    private  GreenfootImage harten2 = new GreenfootImage("images/2lives.png");
    private  GreenfootImage harten3 = new GreenfootImage("images/3lives.png");
    public void act(){
         switch(levens){
            case 1:
                setImage(hart1);
                break;
            
            case 2:
                setImage(harten2);
                break;
                
            case 3:
                setImage(harten3);
                break;
           
            case 0:
                int reply = JOptionPane.showConfirmDialog(null, "Helaas, u heeft verloren! Wilt u nog een keer spelen?", "Verloren!", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION){
                    getWorld().removeObject(this);
                    Greenfoot.setWorld(new Loodsen_Endlessrunner());
                    return;
                }
                else if(reply == JOptionPane.NO_OPTION){
                    Greenfoot.setWorld(new Menu());
                    return;
                }
                break;
        }
    }
    
    public HealthBar(){
        
        
        
        switch(difficulty){
            case 1:
                setImage(hart1);
                levens = 1;
                break;
            
            case 2:
                setImage(harten2);
                levens = 2;
                break;
                
            case 3:
                setImage(harten3);
                levens = 3;
                break;
            
            default:
                levens = 3;
                setImage(harten3);
                break;
                
        }
    }
    
    
    
    public static void setDifficulty(int input){
        difficulty = input;
    }
    
    public static void setLevens(int getal){
        if((levens == difficulty && getal < 0) || (levens < difficulty)){
        int levenOpteller = getal;
        levens += levenOpteller;
        }
        
        }
        
   

    }
    
    


