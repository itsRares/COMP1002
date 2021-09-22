 /***************************************************************************
 *  FILE: DSAGraphNode.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Creates the graph nodes (vertices) for graph/holds edges
 *  LAST MOD: 19/10/17
 ***************************************************************************/

import java.util.*;

public class DSAGraphNode
{
     
    /*----------Classfields----------*/
    private String label;
    private Object value;
    private DSALinkedList<DSAGraphEdge> edges;
    private int edgeCount;
    private boolean visited;
    private double distanceFromSource, timeFromSource;
        
    /*----------Constructors----------*/
    /*******************************************
 *  *SUBMODULE DSAGraphNode
 *  *IMPORT: inLabel (String), inValue (Object)
 *  *EXPORT: -
 *  *ASSERTION: Creates a DSAGraphNode (node) object with the values provided
 *  ******************************************/
    public DSAGraphNode(String inLabel, Object inValue)
    {
        label = inLabel;
        value = inValue;
        visited = false;
        edges = new DSALinkedList<DSAGraphEdge>();
        distanceFromSource = Double.MAX_VALUE;
        timeFromSource = Double.MAX_VALUE;
    }
        
    /*----------Accessors----------*/
    //General
    public String getLabel()
    {
        return label;
    }
        
    //Adjacent
    public Object getValue()
    {
        return value;
    }
    
    public boolean getVisit()
    {
        return visited;
    }
    
    public DSALinkedList<DSAGraphEdge> getEdges()
    {
        return edges;
    }
    
    public int getEdgeCount()
    {
        return edgeCount;
    }
    
    public double getDistanceFromSource() {
        return distanceFromSource;
    }
    
    public void setDistanceFromSource(double inDistanceFromSource) {
        distanceFromSource = inDistanceFromSource;
    }
    
    public double getTimeFromSource() {
        return timeFromSource;
    }
    
    public void setTimeFromSource(double inTimeFromSource) {
        timeFromSource = inTimeFromSource;
    }
    
    /*----------Mutators----------*/
    /*******************************************
 *  *SUBMODULE addEdgeList
 *  *IMPORT: inLabel (String), inValue (Object)
 *  *EXPORT: none
 *  *ASSERTION: Adds the edge provided to the node
 *  ******************************************/
    public void addEdgeList(String inLabel, Object inValue)
    {
        DSAGraphEdge node = new DSAGraphEdge(inLabel, inValue);        //Create a new edge
        edges.insertLast(node);                                        //Insert edge last into linked list
        edgeCount++;                                                   //Incriment edgeCount by 1
    }
     
    /*******************************************
 *  *SUBMODULE setVisited
 *  *IMPORT: none
 *  *EXPORT: none
 *  *ASSERTION: Sets the visited value to true for the node
 *  ******************************************/   
    public void setVisited()
    {
        visited = true;
    }
    
    /*******************************************
 *  *SUBMODULE clearVisited
 *  *IMPORT: none
 *  *EXPORT: none
 *  *ASSERTION: Clears (resets) the node visited value back to false
 *  ******************************************/
    public void clearVisited()
    {
        visited = false;
    }
    
    /*******************************************
 *  *SUBMODULE isEdge
 *  *IMPORT: inLabel (String)
 *  *EXPORT: found (boolean)
 *  *ASSERTION: Checks to see if given label is a edge
 *  ******************************************/
    public boolean isEdge(String inLabel)
    {
        boolean found = false;
        String label;
        DSAGraphEdge current = null;
        Iterator iter = edges.iterator();
        
        while(iter.hasNext() && found == false)                      //if there is a next and not found
        {
            current = (DSAGraphEdge)iter.next();                     //Set current to next iter
            label = current.getLabel();                              //Set Label to equal current getLabel()
            if (label.equals(inLabel))                               //if label equals the provided inLabel (not case sensitive)      
            {                                                        //set found to true
                found = true;
            }
        }
        return found;
    }
    
    /*******************************************
 *  *SUBMODULE getEdge
 *  *IMPORT: inLabel (String)
 *  *EXPORT: value (DSAGraphEdge)
 *  *ASSERTION: Returns the edge given the label
 *  ******************************************/
    public DSAGraphEdge getEdge(String inLabel)
    {
        boolean found = false;
        String label;
        DSAGraphEdge current = null, value = null;
        Iterator iter = edges.iterator();
        
        while(iter.hasNext() && found == false)                      //if there is a next and not found
        {
            current = (DSAGraphEdge)iter.next();                     //Set current to next iter
            label = current.getLabel();                              //Set Label to equal current getLabel()
            if (label.equals(inLabel))                               //if label equals the provided inLabel (not case sensitive) 
            {                                                        //set found to true and value to current
                found = true;
                value = current;
            }
        }
        return value;
    }
    
    /*******************************************
 *  *SUBMODULE toString
 *  *IMPORT: none   
 *  *EXPORT: str (String)
 *  *ASSERTION: Outputs it to the string
 *  ******************************************/
    public String toString() {
        String str, nodeLabel;
        DSAGraphEdge current = null;
        Iterator iter = edges.iterator();
        
        str = "Node: " + label + " has\n";
            while(iter.hasNext())                                    //if there is a next
            {
                current = (DSAGraphEdge)iter.next();                 //Set current to next iter
                Object curObj = current.getValue();                  //Get the current node's object
                Travel travels = (Travel)curObj;                     //Typecast object to Travel
                nodeLabel = current.getLabel();                      //Set nodeLabel to current node label
                
                str += "\tEdge to " + nodeLabel + " with a distance of " +travels.getKms()+ "\n";       //Construct string
            }
        return str;
    }
        
}//end DSAGraphNode.java