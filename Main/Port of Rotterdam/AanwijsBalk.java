import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class AanwijsBalk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AanwijsBalk extends Vrachoverslaanobjecten
{
    /**
     * Act - do whatever the AanwijsBalk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkY();
    }    
    
    public void checkY(){
        if(getY() == 30 || getY() == 22){
                int reply = JOptionPane.showConfirmDialog(null, "Helaas, het schip is omgeslagen. Wilt u nog een keer spelen?", "Verloren!", JOptionPane.YES_NO_OPTION);
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
    }
}
