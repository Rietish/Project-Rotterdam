import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Hoofdmenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hoofdmenu extends Taskbar
{
    /**
     * Act - do whatever the Hoofdmenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        hover();
        pressed();
    }    
    
    public void hover(){
        GreenfootImage button = getImage();
        if(Greenfoot.mouseMoved(this) == true ){
            setImage("images/taskbar_hoofdmenuHover.png");
        }
        else{
            setImage("images/taskbar_hoofdmenu.png");
        }
    }
    
    public void pressed(){
        if(Greenfoot.mousePressed(this) == true){
            int reply = JOptionPane.showConfirmDialog(null, "Wilt u naar het hoofdmenu terugkeren?", "Hoofdmenu", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){
                 getWorld().removeObject(this);
                 Greenfoot.setWorld(new Menu());
            }
        }
    }
}
