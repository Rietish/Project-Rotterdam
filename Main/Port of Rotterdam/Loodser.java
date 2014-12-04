import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Loodser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loodser extends controleHavenObjecten
{
    int originX;
    int originY;
    int loodserID;
    boolean staatOpBoot = false;
    

    public Loodser(int x, int y, int id)
    {
        originX = x;
        originY = y;
        loodserID = id;
    }
    
    public void act() 
    {
        //de boot onder de loodser
        controleBoot dezeBoot = (controleBoot) getOneObjectAtOffset(0, 0, controleBoot.class);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(Greenfoot.mouseDragged(this))
        {
            if(mouse != null)
            this.setLocation(mouse.getX(), mouse.getY());
            

            
                if(dezeBoot != null && !staatOpBoot && (dezeBoot.getStatus() == controleBoot.Status.BINNENVAREN || dezeBoot.getStatus() == controleBoot.Status.OMLAAG || dezeBoot.getStatus() == controleBoot.Status.WACHTENOPLOODS))
                {
                    dezeBoot.setGeselecteerd(true);
                    
                    staatOpBoot = true;
                }
                else if(dezeBoot == null) //als je geen boot selecteerd
                {
                    
                    List<controleBoot> boten = getWorld().getObjects(controleBoot.class);
                    for(int i = 0; i < boten.size(); i++)
                    {
                        controleBoot listBoot = boten.get(i);
                        if(listBoot.isGeselecteerd())
                        {
                            listBoot.setGeselecteerd(false);
                            
                        }
                    }
                    staatOpBoot = false;
                }
            
           
            //TODO als er geen boot wordt geselecteerd, deselect alle boten
            
        }
        else
        {
            //return to origin, als de boot is aangemeerd
            if(dezeBoot != null && dezeBoot.getDestinationID() == 0 && getY() == 37 || getY() == 36)
            {
                setLocation(originX, originY);
            }
        }
        
        
        
        if(Greenfoot.mouseDragEnded(this))
        {
            if(dezeBoot != null && getY() <= 24 && (dezeBoot.getStatus() == controleBoot.Status.BINNENVAREN || dezeBoot.getStatus() == controleBoot.Status.OMLAAG || dezeBoot.getStatus() == controleBoot.Status.WACHTENOPLOODS) && havenIsVrij())
            {
                List<controleBoot> boten = getWorld().getObjects(controleBoot.class);
                for(int i = 0; i < boten.size(); i++)
                {
                    controleBoot listBoot = boten.get(i);
                    if(listBoot.getDestinationID() == loodserID)
                    {
                        listBoot.setGeselecteerd(false);
                        listBoot.setDestinationID(0);
                    }
                }
                dezeBoot.acceptLoodser(this);
                dezeBoot.setGeselecteerd(false);
                staatOpBoot = true;
                
                
            }
            else
            {
                setLocation(originX, originY);
                staatOpBoot = false;
            }
        } 
        
        if(dezeBoot == null && (mouse != null && (this.getX() != mouse.getX() || this.getY() != mouse.getY() ) ) )
        {
            setLocation(originX, originY);
        }
    }    
    
    public void setPosition(int x, int y)
    {
        setLocation(x, y);
    }
        
    public boolean havenIsVrij()
    {
        boolean ans = true;
             List<Haven> havenList = getWorld().getObjects(Haven.class);
              for(int i = 0; i < havenList.size(); i++)
              {
                  if(havenList.get(i).getID() == loodserID)
                  {
                      if(havenList.get(i).isBootInHaven())
                      {
                          ans = false;
                      }
                  
                  }
              }
              
        return ans;
    }
}
