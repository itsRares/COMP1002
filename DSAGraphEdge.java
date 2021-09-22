 /***************************************************************************
 *  FILE: DSAGraphEdge.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Creates the graph edges for graph
 *  LAST MOD: 19/10/17
 ***************************************************************************/

import java.util.*;

//DSAGraphEdge.java
public class DSAGraphEdge
{
        
    /*----------Classfields----------*/
    private String label;
    private Object value;
    private boolean visited;
        
    /*----------Constructors----------*/
    /*******************************************
 *  *SUBMODULE DSAGraphEdge
 *  *IMPORT: inLabel (String), inValue (Object)
 *  *EXPORT: -
 *  *ASSERTION: Creates a DSAGraphEdge object with the values provided
 *  ******************************************/
    public DSAGraphEdge(String inLabel, Object inValue)
    {
        label = inLabel;
        value = inValue;
        visited = false;
    }
        
    /*----------Accessors----------*/
    //General
    public String getLabel()
    {
        return label;
    }

    public Object getValue()
    {
        return value;
    }
    
    public boolean getVisit()
    {
        return visited;
    }
    
    public String getFrom()
    {
        Travel travels = (Travel)value;
        return travels.getFrom();
    }

    public String getTo()
    {
        Travel travels = (Travel)value;
        return travels.getTo();
    }
    
    public double getTime()
    {
        Travel travels = (Travel)value;
        return travels.getTime();
    }
    
    public double getKms()
    {
        Travel travels = (Travel)value;
        return travels.getKms();
    }
    
    public String getNeighbour(String node) {
        String from, to, values;
        Travel travels = (Travel)value;
        from = travels.getFrom();
        to = travels.getTo();
        
        //If the provided node equals the edge value get to value else get from (node value itself)
        if (from.equals(node)) {
            values = to;
        } else {
            values = from;
        }
        return values;
    }
    
    /*----------Mutators----------*/
    /*******************************************
 *  *SUBMODULE setVisited
 *  *IMPORT: none
 *  *EXPORT: none
 *  *ASSERTION: Sets the visited to true for the edge
 *  ******************************************/
    public void setVisited()
    {
        visited = true;
    }

    /*******************************************
 *  *SUBMODULE clearVisited
 *  *IMPORT: none
 *  *EXPORT: none
 *  *ASSERTION: Sets the visited to false for the edge
 *  ******************************************/ 
    public void clearVisited()
    {
        visited = false;
    }
    
    /*******************************************
 *  *SUBMODULE toString
 *  *IMPORT: none   
 *  *EXPORT: str (String)
 *  *ASSERTION: Outputs it to the string
 *  ******************************************/
    public String toString()
    {
        return ("Edge label: " + label);    
    }
            
}//End DSAGraphEdge.java