 /***************************************************************************
 *  FILE: TestLocation.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Unit test for Location
 *  LAST MOD: 19/10/17
 ***************************************************************************/
 
import java.util.*;
 
public class TestLocation
{
    public static void main(String args[])
    {
        String name, state, country, desc;
        double position;
        Location l;
        
        System.out.println("    Testing Normal");
        System.out.println("-----------------------");
        
        try
        {
            System.out.println("Testing: Creating Location");
            l = new Location("Perth","WA","A nice place","Australia",44.4);
            System.out.println("Passed\n");
            
            System.out.println("Testing: Setters/Getters");
            
            System.out.println("------Getters------");
            System.out.println("> getName()");
            name = l.getName();
            if (!name.equals("Perth"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> getState()");
            state = l.getState();
            if (!state.equals("WA"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> getCountry()");
            country = l.getCountry();
            if (!country.equals("Australia"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> getDesc()");
            desc = l.getDesc();
            if (!desc.equals("A nice place"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> getPosition()");
            position = l.getPosition();
            if (position != 44.4)
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
        
            System.out.println("------Setters------");
            System.out.println("> setName()");
            l.setName("London");
            name = l.getName();
            if (!name.equals("London"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> setState()");
            l.setState("none");
            state = l.getState();
            if (!state.equals("none"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> setCountry()");
            l.setCountry("England");
            country = l.getCountry();
            if (!country.equals("England"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> setDesc()");
            l.setDesc("Nice");
            desc = l.getDesc();
            if (!desc.equals("Nice"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> setPosition()");
            l.setPosition(500);
            position = l.getPosition();
            if (position != 500.0)
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            
        } catch(Exception e) {System.out.println("Failed");}
        
        
        
        
        
        System.out.println("    Testing Error");
        System.out.println("-----------------------");
        
        try
        {
            System.out.println("Testing: Creating Location");
            l = new Location("Perth","WA","A nice place",null,44);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
        
        System.out.println("Testing: Setters");
            
        System.out.println("------Setters------");
        try{
            System.out.println("> setName()");
            l = new Location("Perth","WA","A nice place","",44);
            l.setName(null);
            System.out.println("failed\n");            
        } catch(Exception e) {System.out.println("Passed\n");}
        
        try{
            System.out.println("> setState()");
            l = new Location("Perth","WA","A nice place","",44);
            l.setState(null);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
        
        try{
            System.out.println("> setCountry()");
            l = new Location("Perth","WA","A nice place","",44);
            l.setCountry(null);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
        
        try{
            System.out.println("> setDesc()");
            l = new Location("Perth","WA","A nice place","",44);
            l.setDesc(null);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
        
        try{
            System.out.println("> setPosition()");
            l = new Location("Perth","WA","A nice place","",44);
            l.setPosition(0);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
    }
}