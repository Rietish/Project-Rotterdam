import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Krat_vrachtoverslaan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Krat_vrachtoverslaan extends Vrachoverslaanobjecten
{
    /**
     * Act - do whatever the Krat_vrachtoverslaan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    Boolean wordtgetild = false;

    public void act() 
    {
        oppakken();
    }  

    void oppakken(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        int mx = 0;
        int my = 0;
        String containerType = "" + this;

        if(mouse!=null){  
            mx = mouse.getX();  
            my = mouse.getY();  
        }  
        Actor grijper = getOneObjectAtOffset(0,0, kraanGrijper.class);
        kraanGrijper grijpObject = (kraanGrijper) grijper;
        Actor xding = getOneObjectAtOffset(0,0, kraanXding.class);
        //zorg ervoor dat de container opgepakt kan worden!

        if(wordtgetild)
        {
            if(mx <= 48 && mx >= 10)
            {
                setLocation(mx, getY());
            }
            if(my <= 40 && my >= 24)
            {
                setLocation(getX(), my);
            }

            if((Greenfoot.mouseClicked(grijper) || Greenfoot.mouseClicked(xding)) && my % 2 == 0 && ruimteGenoeg() && (getY() <=28 || ((getY() >= 38 && getY() <= 40)))) 
            {
                if((getY() == 38 || getY() == 40)){
                    if(containerType.contains("Container1") && ((mx >= 17 && mx <= 23) || (mx >= 28 && mx <= 34))){
                        wordtgetild = false;
                        grijpObject.setOpgepakt(false);
                    }

                    else if(containerType.contains("Container2") && ((mx >= 18 && mx <= 22) || (mx >= 29 && mx <= 33))){
                        wordtgetild = false;
                        grijpObject.setOpgepakt(false);    
                    }

                    else if(containerType.contains("Container3") && ((mx >= 19 && mx <= 21) || (mx >= 30 && mx <= 32))){
                        wordtgetild = false;
                        grijpObject.setOpgepakt(false);  
                    }
                }
                else{
                    wordtgetild = false;
                        grijpObject.setOpgepakt(false);
                }
                
                //maak de balans weer goed waneer je een container weer op de boot zet
                if(getY() >= 24 && getY() <= 28)
                {
                    int balansKant = 0;
                    if(getY() == 26)
                    {
                        balansKant = 0;
                    }
                    else if(getY() == 24)
                    {
                        balansKant = -1;
                    }
                    else if(getY() == 28)
                    {
                        balansKant = 1;
                    }

                    if(containerType.contains( "Container1"))
                    {           
                        EigenBoot().setBalans(1 * balansKant);

                    }
                    else if(containerType.contains( "Container2"))
                    {
                        EigenBoot().setBalans(2 * balansKant);
                    }
                    else if(containerType.contains( "Container3"))
                    {
                        EigenBoot().setBalans(3 * balansKant);
                    }

                
                }
                if((mx >= 10 && mx <= 38) && (my >= 24 && my <= 28)){
                    VrachtOverslaan wereld = (VrachtOverslaan) getWorld();
                    int nuVracht = wereld.getScheepsVracht();
                    nuVracht++;
                    wereld.setScheepsVracht(nuVracht);
                }
            }
            return;
        }
        if(mx == getX() && my == getY() && (Greenfoot.mouseClicked(grijper) || Greenfoot.mouseClicked(xding)) && grijpObject.getOpgepakt() == false )
        {
            wordtgetild = true;
            grijpObject.setOpgepakt(true);

            //verander de balans van de boot
            int balansKant = 0;
            if(getY() == 26)
            {
                balansKant = 0;
            }
            else if(getY() == 24)
            {
                balansKant = 1;
            }
            else if(getY() == 28)
            {
                balansKant = -1;
            }

            //containerType = containerType.substring(0, containerType.indexOf("@"));
            //containerType = (String) containerType;
            int testLength = containerType.length();

            int hisx = getX();
            int hisy = getY();

            //checkt of x op de boot viel
            if((hisx >= 10 && hisx <= 38) && (hisy >= 24 && hisy <= 28)){
                VrachtOverslaan wereld = (VrachtOverslaan) getWorld();
                int nuVracht = wereld.getScheepsVracht();
                nuVracht--;
                wereld.setScheepsVracht(nuVracht);
            }

            Actor grijpertje = getOneObjectAtOffset(0,0,kraanGrijper.class);
            Actor kraantje = getOneObjectAtOffset(0,0,kraanGrijper.class);
            for(int i = -7; i <= 7; i++){
                if(getOneObjectAtOffset(0,i,kraanXding.class) != null){
                    kraantje = getOneObjectAtOffset(0,i,kraanXding.class);
                }
            }
            

            if(containerType.contains("Container1"))
            {
                EigenBoot().setBalans(1 * balansKant);

                Container1 container1 = new Container1();
                getWorld().addObject(container1, hisx, hisy);

                getWorld().removeObject(grijpertje);
                kraanGrijper nieuweGrijper = new kraanGrijper();
                getWorld().addObject(nieuweGrijper,hisx, hisy);
                nieuweGrijper.setOpgepakt(true);

                getWorld().removeObject(kraantje);
               
                getWorld().addObject(new kraanXding(), hisx, 32);
            

                container1.wordtgetild = true;
                getWorld().removeObject(this);
            }
            else if(containerType.contains( "Container2"))
            {
                EigenBoot().setBalans(2 * balansKant);

                Container2 container2 = new Container2();
                getWorld().addObject(container2, hisx, hisy);

                getWorld().removeObject(grijpertje);
                kraanGrijper nieuweGrijper = new kraanGrijper();
                getWorld().addObject(nieuweGrijper,hisx, hisy);
                nieuweGrijper.setOpgepakt(true);

                getWorld().removeObject(kraantje);
               
                getWorld().addObject(new kraanXding(), hisx, 32);
            

                container2.wordtgetild = true;
                getWorld().removeObject(this);
            }
            else if(containerType.contains("Container3"))
            {
                EigenBoot().setBalans(3 * balansKant);

                Container3 container3 = new Container3();
                getWorld().addObject(container3, hisx, hisy);

                getWorld().removeObject(grijpertje);
                kraanGrijper nieuweGrijper = new kraanGrijper();
                getWorld().addObject(nieuweGrijper,hisx, hisy);
                nieuweGrijper.setOpgepakt(true);

                getWorld().removeObject(kraantje);
                getWorld().addObject(new kraanXding(), hisx, 32);


                container3.wordtgetild = true;
                getWorld().removeObject(this);
            }
        }
    }

    boolean ruimteGenoeg()
    {
        //check of er containers naast of onder staan, afhankelijk van het type container dat je vast hebt

        if(getOneIntersectingObject(Container1.class) == null && getOneIntersectingObject(Container2.class) == null && getOneIntersectingObject(Container3.class) == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}