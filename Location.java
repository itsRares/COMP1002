 /***************************************************************************
 *  FILE: Location.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Creates the location object to hold values
 *  LAST MOD: 19/10/17
 ***************************************************************************/

import java.util.*;

public class Location
{
    
    /*----------Classfields----------*/
    private String name, state, desc, country;
    private double position;

    /*----------Constructors----------*/
    /*******************************************
 *  *SUBMODULE Location
 *  *IMPORT: inName (String), inState (String), inDesc (String), inCountry (String), inPosition (double)
 *  *EXPORT: -
 *  *ASSERTION: Creates a Location object with the values provided
 *  ******************************************/
    public Location(String inName, String inState, String inDesc, String inCountry, double inPosition)
    {
        if ((validatePosition(inPosition)))
        {
            name = new String(inName);   
            state = new String(inState);
            desc = new String(inDesc);   
            country = new String(inCountry);
            position = inPosition; 
        }
        else 
        {
            throw new IllegalArgumentException("Invalid Import Values");        //Throw error if invalid
        }
    }

    /*----------Accessors----------*/
    public String getName()
    {
        return new String(name);
    }
    
    public String getState()
    {
        return new String(state);
    }

    public String getCountry()
    {
        return new String(country);
    }

    public String getDesc()
    {
        return new String(desc);
    }

    public double getPosition()
    {
        return position;
    }
    
    /*----------Mutators----------*/
    /*******************************************
 *  *SUBMODULE setName
 *  *IMPORT: inName (String)
 *  *EXPORT: none
 *  *ASSERTION: If not null sets name to inName
 *  ******************************************/
    public void setName(String inName)
    {
        if (inName != null)                                            //if not null then name equals inName
        {
            name = inName;
        }
        else 
        {
            throw new IllegalArgumentException("Invalid name");        //Throw error if invalid
        }
    }
    
    /*******************************************
 *  *SUBMODULE setState
 *  *IMPORT: inState (String)
 *  *EXPORT: none
 *  *ASSERTION: If not null sets state to inState
 *  ******************************************/
    public void setState(String inState)
    {
        if (inState != null)                                            //if not null then state equals inState
        {
            state = inState;
        }
        else 
        {
            throw new IllegalArgumentException("Invalid state");        //Throw error if invalid
        }
    }
    
    /*******************************************
 *  *SUBMODULE setDesc
 *  *IMPORT: inDesc (String)
 *  *EXPORT: none
 *  *ASSERTION: If not null sets desc to inDesc
 *  ******************************************/
    public void setDesc(String inDesc)
    {
        if (inDesc != null)                                            //if not null then desc equals inDesc
        {
            desc = inDesc;
        }
        else 
        {
            throw new IllegalArgumentException("Invalid desc");        //Throw error if invalid
        }
    }
    
    /*******************************************
 *  *SUBMODULE setCountry
 *  *IMPORT: inCountry (String)
 *  *EXPORT: none
 *  *ASSERTION: If not null sets country to inCountry
 *  ******************************************/
    public void setCountry(String inCountry)
    {
        if (inCountry != null)                                            //if not null then country equals inCountry
        {
            country = inCountry;
        }
        else 
        {
            throw new IllegalArgumentException("Invalid country");        //Throw error if invalid
        }
    }
    
    /*******************************************
 *  *SUBMODULE setPosition
 *  *IMPORT: inPosition (double)
 *  *EXPORT: none
 *  *ASSERTION: If valid sets position to inPosition
 *  ******************************************/
    public void setPosition(double inPosition)
    {
        if ((validatePosition(inPosition)))                                //Validate position then set position equal inPosition
        {
            position = inPosition;
        }
        else 
        {
            throw new IllegalArgumentException("Invalid position");        //Throw error if invalid
        }
    }
    
    /*----------Validation----------*/
    /*******************************************
 *  *SUBMODULE validatePosition
 *  *IMPORT: inPosition (double)
 *  *EXPORT: boolean
 *  *ASSERTION: Validates that inPosition is above 0
 *  ******************************************/
    public boolean validatePosition(double inPosition)
    {
        return (inPosition > 0.0);                                          //Check if above 0
    }

}
