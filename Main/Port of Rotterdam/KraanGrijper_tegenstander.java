import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class KraanGrijper_tegenstander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KraanGrijper_tegenstander extends Vrachoverslaanobjecten
{
    public double kraanSnelheid = 0.1;
    
    public class coord 
    {
        public coord (int px, int py)
        {
            x = px;
            y = py;
        }
        public int x;
        public int y;
    }
    
    public class planRegel
    {
        public coord origin;
        public coord destination;
        public int destinationTreinstel;
        public boolean treinVol;
        public int containerSize;
    }
    //maak een lijst van zetten
    List<planRegel> movePlan = null;
    
    int currentRegel = -1;
    
    
    //krijg de locaties van de containers en vul de lijst van zetten
    public void acceptContainerMap(String[][] containerMap)
    {
        planRegel regel = null;
        boolean treinIsVol = false;
        movePlan = new ArrayList<planRegel>();
        
        // array met treinstel, x- en y-positie in het treinstel
        boolean[][][] treincell = new boolean[2][2][4];
        
        do{
               
            //STAP 1: zoek naar grootste vrije ruimte op trein
            regel = null;
            treinIsVol = false;
            int grootsteVrijeRuimte = 0;
            coord GVRcoord = null;
            int GVRtreinstel = 0;
            
            do 
            {
                for(int treinstel = 0; treinstel < 2; treinstel++)
                {
                    for(int y = 0; y < 2; y++)
                    {
                        for(int x = 0; x < 4; x++)
                        {
                            if(getVrijeRuimte(treincell[treinstel][y], x) > grootsteVrijeRuimte)
                            {
                                grootsteVrijeRuimte = getVrijeRuimte(treincell[treinstel][y], x);
                                GVRcoord = new coord(x,y);
                                GVRtreinstel = treinstel;
                            }
                                               
                        }
                    }
                }
                
                if (grootsteVrijeRuimte==0)
                {
                    // trein=vol
                    treinIsVol = true;
                    treincell = new boolean[2][2][4]; // maak een lege trein aan0
                }
            } while (grootsteVrijeRuimte==0) ;
            
            
            //STAP 2: wat is de grootste contsainer op de boot, kleiner of gelijkaan de grootste vrije ruimte
            regel = getVolgendeContainerOpBoot(containerMap, grootsteVrijeRuimte);
            
            if (regel == null)
            {
                // Er is geen planregel: dus boot is leeg OF er zijn geen containers meer die passen op de trein
                if (!IsBootLeeg(containerMap))
                {
                    // er zijn nog containers, dus laat trein gaan
                    treinIsVol=true;
                    // Let op! dit moeten we bij de vorige planregel noteren!
                    movePlan.get(movePlan.size()-1).treinVol = true;
                }
            }
            else
            {   //Als er iets gevonden is, maak een planregel aan

                // als trein nu vol is, dan moet de trein rijden bij de vorige container
                if (treinIsVol)
                {
                    movePlan.get(movePlan.size()-1).treinVol = true;
                }
                
                
                //hoera we hebben een container om te verplaatsen, party bij mij thuis
                regel.destination = GVRcoord;
                regel.destinationTreinstel = GVRtreinstel;
                regel.treinVol = false;
                movePlan.add(regel);
                //afvinken plek op de trein
                for(int x = regel.destination.x; x < regel.destination.x + regel.containerSize; x++)
                {
                    treincell[regel.destinationTreinstel][regel.destination.y][x] = true;
                }
                
            }
        } while (regel != null || treinIsVol);
        
        //de tegenstander is klaar met het maken van het plan
    
    } 
    
    private planRegel getVolgendeContainerOpBoot(String[][] containerMap, int grootsteVrijeRuimte)
    {
        if(grootsteVrijeRuimte > 3)
        grootsteVrijeRuimte = 3;
        for(int containerSize = grootsteVrijeRuimte; containerSize > 0; containerSize--)
        {
            
            String searchFor ="container" + Integer.toString(containerSize);
            for(int y = 0; y < 3; y++)
            {
                for(int x = 0; x < 15; x++)
                {
                    if(containerMap[x][y].contains(searchFor))
                    {
                        //vink conatainerplek op de boot af
                        containerMap[x][y] = "empty";
                        planRegel regel = new planRegel();
                        regel.origin = new coord(x,y);
                        regel.containerSize = containerSize;
                        return regel;
                    }
                }
            }
        }
        return null;
    }
    
    
    private boolean IsBootLeeg(String[][] containerMap)
    {            
        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 15; x++)
            {
                if(containerMap[x][y].contains("container"))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int getVrijeRuimte(boolean[] cell, int x)
    {
        int ruimte = 0;
        for(int i = x; i < cell.length; i++)
        {
            if(cell[i])
            {
                return ruimte;
            }
            else
            {
                ruimte++;
            }
            
        }
        return ruimte;
    }
    
    /**
     * Act - Wat de grijper moet doen volgens het plan
     */
    
    public enum Status {
    INIT, MOVETO_ORIGIN_X, MOVETO_DESTINATION_X, MOVETO_ORIGIN_Y, MOVETO_DESTINATION_Y, WAITFORTRAIN, IDLE
    }
    Status tegenstanderStatus = Status.INIT;
    int bestemmingX = 0;
    int bestemmingY = 0;
    double currentX = 0;
    double currentY = 0;
    Krat_vrachtoverslaan_tegenstander currentContainer =null;
    
    public void act() 
    {
        int grijperx = getX();
        int grijpery = getY();
        
        if(tegenstanderStatus == Status.INIT)
        {
           currentX=getX();
           currentY=getY();
          
           //bepaal volgende regel
           tegenstanderStatus = Status.WAITFORTRAIN;
           
           
           
        }
        else if(tegenstanderStatus == Status.MOVETO_ORIGIN_X)
        {
            //check of de trein in het station staat
            Trein_vrachtoverslaan_tegenstander trein = (Trein_vrachtoverslaan_tegenstander) getWorld().getObjects(Trein_vrachtoverslaan_tegenstander.class).get(0);
            if(trein.isInStation())
            {
                if(getX() == bestemmingX)
                {
                    tegenstanderStatus = Status.MOVETO_ORIGIN_Y;
                    
                }
                else{
                    currentX = currentX + Math.signum(bestemmingX - currentX) * kraanSnelheid;
                }
            }
            
        }
        else if(tegenstanderStatus == Status.MOVETO_ORIGIN_Y)
        {
            if(getY() == bestemmingY)
            {
                tegenstanderStatus = Status.MOVETO_DESTINATION_X;
                
                //moveto destination op trein
                bestemmingX = movePlan.get(currentRegel).destination.x * 2 + 17 + movePlan.get(currentRegel).containerSize - 1 + movePlan.get(currentRegel).destinationTreinstel*11;
                bestemmingY = movePlan.get(currentRegel).destination.y * 2 + 2;   
                
                // onthou de container die we gaan verplaatsen
                Actor containerActor = getOneObjectAtOffset(0, 0, Krat_vrachtoverslaan_tegenstander.class);
                currentContainer = (Krat_vrachtoverslaan_tegenstander) containerActor;
            }
            else{
                currentY = currentY + Math.signum(bestemmingY - currentY) * kraanSnelheid;
            }

        }
        else if(tegenstanderStatus == Status.MOVETO_DESTINATION_X)
        {
           if(getX() == bestemmingX)
            {
                tegenstanderStatus = Status.MOVETO_DESTINATION_Y;
                
            }
            else{
                currentX = currentX + Math.signum(bestemmingX - currentX) * kraanSnelheid;
               
                //zorg ervoor dat de container meebeweegt  
                currentContainer.setLocation((int)currentX, (int)currentY);
            }
 
        }
        else if(tegenstanderStatus == Status.MOVETO_DESTINATION_Y)
        {
            if(getY() == bestemmingY)
            {
                tegenstanderStatus = Status.WAITFORTRAIN;
                
                
                // als de trein vol is, laat hem dan vertrekken
                if (movePlan.get(currentRegel).treinVol)
                {
                    Trein_vrachtoverslaan_tegenstander trein = (Trein_vrachtoverslaan_tegenstander) getWorld().getObjects(Trein_vrachtoverslaan_tegenstander.class).get(0);
                    trein.gaRijden();
                }
                
            }
            else{
                currentY = currentY + Math.signum(bestemmingY - currentY) * kraanSnelheid;
                
                //zorg ervoor dat de container meebeweegt
                currentContainer.setLocation((int)currentX, (int)currentY);
            }

        }
        else if(tegenstanderStatus == Status.WAITFORTRAIN)
        {
            Trein_vrachtoverslaan_tegenstander trein = (Trein_vrachtoverslaan_tegenstander) getWorld().getObjects(Trein_vrachtoverslaan_tegenstander.class).get(0);
            if(!trein.isAanHetRijden())
            {
                 // moveto origin op boot
               currentRegel++;
               if (currentRegel < movePlan.size())
               {
                 bestemmingX = movePlan.get(currentRegel).origin.x * 2 + 10 + movePlan.get(currentRegel).containerSize - 1;
                 bestemmingY = 18 - (movePlan.get(currentRegel).origin.y * 2);
               
                 tegenstanderStatus = Status.MOVETO_ORIGIN_X;
                }
                else{
                    //TEGENSTANDER HEFT GEWONNEN
                    int reply = JOptionPane.showConfirmDialog(null, "Helaas, u heeft verloren. Wilt u nog een keer spelen?", "Verloren!", JOptionPane.YES_NO_OPTION);
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
        else if(tegenstanderStatus == Status.IDLE)
        {
            //PLAYER HEEFT GEWONNEN
            //speler wint als zijn laatste trein weg gaat dus dit kan weg
            
        }
        setLocation((int)currentX, (int)currentY);
        
        // Move kraan tegenstander
        KraanXding_tegenstander kraanXding = (KraanXding_tegenstander) getWorld().getObjects(KraanXding_tegenstander.class).get(0);
        kraanXding.setLocation((int)currentX,kraanXding.getY());
        
        
    }    
    
    public void setKraanSnelheid(double snelheid){
            kraanSnelheid = snelheid;
        }
}



