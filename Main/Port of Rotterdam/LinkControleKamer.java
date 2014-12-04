import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LinkControleKamer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkControleKamer extends Links
{
    /**
     * Act - do whatever the LinkControleKamer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image1 = new GreenfootImage("images/link_controlekamer_off.png");
    GreenfootImage image2 = new GreenfootImage("images/link_controlekamer.png");
  public void act(){
      pressed();
      tellen();
    }
    
     public void pressed(){
        if(Greenfoot.mousePressed(this) == true){
            Greenfoot.setWorld(new Controlecentrum());
            
        }
    } 
    
        void tellen(){
            teller++;
            if(teller == 20){
                setImage(image1);
            }
            else if(teller == 40){
                setImage(image2);
                teller=0;
            }
        }
    
}
