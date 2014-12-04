import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class controleBoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class controleBoot extends controleHavenObjecten
{
    
    boolean geklikt = false;
    boolean geselecteerd = false;
    boolean varen = true;
    int mx = 0;
    int my = 0;
    double currentX;
    double currentY;
    double vaarSnelheid = 0.06;
    controleBootCirkel cirkel = null;
    BoegNummer boegNummer = null;
    int destinationID = 0;
    int destinationX;
    int laadLosTijd = 600;
    Loodser mijnLoodser = null;
    int havenNr = 0;
    
    public controleBoot()
    {
        
    }
    
    public enum Status {
    BINNENVAREN, OMLAAG, WACHTENOPLOODS, NAARHAVENX, NAARHAVENY, AANGEMEERD, UITHAVENY, UITHAVENX, OMHOOG, WEGVAREN, IDLE
    }
    Status bootStatus = Status.BINNENVAREN;
    
    public void act() 
    {  
       //maak boegnummer
       if(boegNummer == null)
       {
           boegNummer = new BoegNummer();
           getWorld().addObject(boegNummer, 0, 0);
       }
      
       /*
       //klikken op boten
       if (Greenfoot.mouseClicked(this) == true && geklikt == false && getY() < 24)
       {
            geklikt = true;
           
            cirkel = new controleBootCirkel();

            getWorld().addObject(cirkel, getX(), getY());
       }
       else if (Greenfoot.mouseClicked(this) && geklikt == true)
       {
           //destination = EEN HAVEN
           
          
           geklikt = false; 
           getWorld().removeObject(cirkel);
       }
       else if(Greenfoot.mouseClicked(null) && geklikt == true) //als je ergens anders klikt, deselect alle boten
       {
           geklikt = false;  
           getWorld().removeObject(cirkel);
       }
       */
      
            
       if(bootStatus == Status.BINNENVAREN)
       {
           currentX += vaarSnelheid;
           
           if(getX() == 32)
           {
               turn(90);
               bootStatus = Status.OMLAAG;
           }
       }
       else if(bootStatus == Status.OMLAAG)
       {
           if(isRouteVrij("omlaag"))
           {
               currentY += vaarSnelheid;
           }
           
           if(verloren())
           {
               int reply = JOptionPane.showConfirmDialog(null, "Helaas, u heeft verloren. Wilt u nog een keer spelen?", "Verloren!", JOptionPane.YES_NO_OPTION);
               if (reply == JOptionPane.YES_OPTION){
               getWorld().removeObject(this);
               Greenfoot.setWorld(new Controlecentrum());
               return;
               }
               else if(reply == JOptionPane.NO_OPTION){
               Greenfoot.setWorld(new Menu());
               return;
               }
           }

           if(getY() == 10)
           {
               bootStatus = Status.WACHTENOPLOODS;
           }
       }
       else if(bootStatus == Status.WACHTENOPLOODS)
       {
           if(isRouteVrij("omlaag") && getY() < 24)
           {
               currentY += vaarSnelheid;
           }
           else
           {
               //VERLOREN
           }
            
           //deselecteer als je geselecteerd bent en stil staat
           if(getY() == 24 && geselecteerd && destinationID == 0 && getOneObjectAtOffset(0, 0, Loodser.class) == null)
           {
               setGeselecteerd(false);
           }
           
           if(getY() == 24 && destinationID != 0)
           {
               //turn naar goede kant
               turn(-90 * linksOfRechts(destinationID));
               
               //zoek x positie van de haven
               destinationX = getDestinationXPos(destinationID);
               
               getWorld().removeObject(cirkel);
               bootStatus = Status.NAARHAVENX;
           }

       }
       else if(bootStatus == Status.NAARHAVENX)
       {
           //ga naar goede kant
           currentX += vaarSnelheid * linksOfRechts(destinationID);
           
           //TODO als de haven x is bereikt, ga naar de Y van de haven
           if(getX() == destinationX)
           {
               turn(90 * linksOfRechts(destinationID));
               bootStatus = Status.NAARHAVENY;
           }
           
       }
       else if(bootStatus == Status.NAARHAVENY)
       {
           //if(currentY < 37.0)
           //{
               currentY += vaarSnelheid;
           //}
           
           if(getY() == 37)
           {
               turn(180);
               //zet de boot in haven op true
              
                   List<Haven> havenList = getWorld().getObjects(Haven.class);
                    for(int i = 0; i < havenList.size(); i++)
                    {
                        if(havenList.get(i).getID() == destinationID)
                        {
                            havenList.get(i).setBootInHaven(true);
                        }
                    }
               havenNr = destinationID;
               
               setDestinationID(0);
               mijnLoodser = null;
               bootStatus = Status.AANGEMEERD;
           }
       }
       else if(bootStatus == Status.AANGEMEERD)
       {
           if(laadLosTijd == 0)
           {
               setImage("images/controle_Bootv2_leeg.png");
               getWorld().removeObject(boegNummer);
               if(Greenfoot.mouseClicked(this))
               {
                   //zet bootInHaven op false
                   List<Haven> havenList = getWorld().getObjects(Haven.class);
                    for(int i = 0; i < havenList.size(); i++)
                    {
                        if(havenList.get(i).getID() == havenNr)
                        {
                            havenList.get(i).setBootInHaven(false);
                        }
                    }
                   bootStatus = Status.UITHAVENY;
               }
           }
           else
           {
               laadLosTijd--;
           }
       }
       else if(bootStatus == Status.UITHAVENY)
       {
           currentY -= vaarSnelheid;
           
           if(getY() == 27)
           {
               if(getX() <= 34)
               {
                   turn(90);
               }
               else
               {
                   turn(-90);
               }
               bootStatus = Status.UITHAVENX;
           }
       }
       else if(bootStatus == Status.UITHAVENX)
       {
           //ga naar goede kant
           if(getX() <= 34)
              {
                  currentX += vaarSnelheid;
              }
              else
              {
                  currentX -= vaarSnelheid;
           }
           
           
           if(getX() == 34)
           {
               if(this.getRotation() == 0)
               {
                   turn(-90);
               }
               else if(this.getRotation() == 180)
               {
                   turn(90);
               }
               bootStatus = Status.OMHOOG;
           }
       }
       else if(bootStatus == Status.OMHOOG)
       {
           if(isRouteVrij("omhoog"))
           {
               currentY -= vaarSnelheid;
           }
           
           if(getY() == 4)
           {
               turn(90);
               bootStatus = Status.WEGVAREN;
           }
       }
       else if(bootStatus == Status.WEGVAREN)
       {
           currentX += vaarSnelheid;
       }
       
       
       //beweeg cirkel mee
       if(cirkel != null)
       {
           cirkel.setPosition((int)currentX, (int)currentY);
       }
       //beweeg boegnummer mee
       if(bootStatus == Status.BINNENVAREN || bootStatus == Status.OMLAAG || bootStatus == Status.WACHTENOPLOODS || bootStatus == Status.NAARHAVENX || bootStatus == Status.NAARHAVENY)
       {
           boegNummer.setPosition((int)currentX, (int)currentY);
       }
       //beweeg loodser mee
       if(mijnLoodser != null)
       {
           mijnLoodser.setPosition((int)currentX, (int)currentY);
       }
       
       setLocation((int)currentX, (int)currentY);
    }    
    
    public int linksOfRechts(int havenID)
    {
        int kant;
        if(havenID < 6)
        {
            kant = -1;
        }
        else
        {
            kant = 1;
        }
        return kant;
    }
    
    public boolean isGeklikt()
    {
        return geklikt;
    }
    
    public void setDestinationID(int id)
    {
        destinationID = id;
        if(id == 0)
        {
            boegNummer.setBoegNummer("");
        }
        else
        {
            boegNummer.setBoegNummer(Integer.toString(id));
        }
    }
    
    public void acceptLoodser(Loodser loodser)
    {
        mijnLoodser = loodser;
        setDestinationID(loodser.loodserID);
    }
    
    public int getDestinationID()
    {
        return destinationID;
    }
    
    public int getDestinationXPos(int id)
    {
        int position = 47;
        
        List<Haven> havens = getWorld().getObjects(Haven.class);
        for(int i = 0; i < havens.size();i++)
        {
            Haven haven = havens.get(i);
            if(haven.getID() == id)
            {
                position = haven.getX();
            }
        }
        return position;
    }
    
    public boolean isRouteVrij(String richting)
    {
        boolean vrij = true;
     
        int y = 1;
        if(richting == "omlaag")
        {
            y = 1;
        }
        else if(richting == "omhoog")
        {
            y = -1;
        }
        if(getOneObjectAtOffset(0, y, controleBoot.class) == null && getOneObjectAtOffset(0, 2 * y, controleBoot.class) == null && getOneObjectAtOffset(0, 3 * y, controleBoot.class) == null)
        {
            vrij = true;
        }
        else
        {
            vrij = false;
        }
        return vrij;
    }
    
    public void setGeselecteerd(boolean var)
    {
        if(var)
        {
            geselecteerd = true;
            cirkel = new controleBootCirkel();
            getWorld().addObject(cirkel, getX(), getY());
        }
        else
        {
            geselecteerd = false;
            getWorld().removeObject(cirkel);
        }
    }
    
    public boolean isGeselecteerd()
    {
        return geselecteerd;
    }
    
    public Status getStatus()
    {
        return bootStatus;
    }
    
    public boolean verloren()
    {
        boolean verloren = false;
        
        if(getOneObjectAtOffset(0, 3, controleBoot.class) != null && getOneObjectAtOffset(0, 7, controleBoot.class) != null && getOneObjectAtOffset(0, 11, controleBoot.class) != null)
        {
            verloren = true;
        }
        
        return verloren;
    }
}