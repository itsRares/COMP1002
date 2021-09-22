 /***************************************************************************
 *  FILE: DSAGraph.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Creates the graph to hold vertices
 *  LAST MOD: 19/10/17
 ***************************************************************************/

import java.util.*;

public class DSAGraph
{
    /*----------Classfields----------*/
    private int edgeCount;
    private int vertexCount;
    private DSALinkedList<DSAGraphNode> vertices;
    private Location[] places = new Location[200];
    
    /*----------Constructors----------*/
    /*******************************************
 *  *SUBMODULE DSAGraph
 *  *IMPORT: none
 *  *EXPORT: -
 *  *ASSERTION: Creates a DSAGraph object which holds the vertices
 *  ******************************************/
    public DSAGraph()
    {
        vertices = new DSALinkedList<DSAGraphNode>();
        vertexCount = 0;
        edgeCount = 0;
    }
    
    /*----------Accessors----------*/
    //General
    public Location getPlaces(int ii)
    {
        return places[ii];
    }
    
    public int getVertexCount()
    {
        return vertexCount;
    }
    
    public int getEdgeCount()
    {
        return edgeCount;
    }
    
    /*----------Mutators----------*/
    /*******************************************
 *  *SUBMODULE addVertex
 *  *IMPORT: inLabel (String), inValue (Object)
 *  *EXPORT: none
 *  *ASSERTION: adds a new vertice to the linked list at the end and incriments the vertice count by 1
 *  ******************************************/
    public void addVertex(String inLabel, Location inValue)
    {
        DSAGraphNode node = new DSAGraphNode(inLabel, (Object)inValue);        //Create a new node
        vertices.insertLast(node);                                             //Insert node last into linked list
        places[vertexCount] = inValue;                                         //Insert node last into places array
        vertexCount++;                                                         //Incriment vertexCount by 1
    }
    
    /*******************************************
 *  *SUBMODULE addEdge
 *  *IMPORT: vertex1 (DSAGraphNode), vertex2 (DSAGraphNode), inLabel (String), inValue (Object)
 *  *EXPORT: none
 *  *ASSERTION: Adds the given edge to the vertices provided and incriments the edgecount by 1 each time;
 *  ******************************************/
    public void addEdge(DSAGraphNode vertex1, DSAGraphNode vertex2, String inLabel, Object edgeValue)
    {
        vertex1.addEdgeList(inLabel, edgeValue);        //Add edge to vertex1 linked List
        vertex2.addEdgeList(inLabel, edgeValue);        //Add edge to vertex2 linked List
        edgeCount++;                                    //Incriment edgeCount by 1
    }
    
    /*******************************************
 *  *SUBMODULE isVertex
 *  *IMPORT: inLabel (String)
 *  *EXPORT: found (boolean)
 *  *ASSERTION: Checks if label is a vertex (node)
 *  ******************************************/
    public boolean isVertex(String inLabel)
    {
        boolean found = false;
        String label;
        DSAGraphNode current = null;
        Iterator iter = vertices.iterator();
        
        while(iter.hasNext() && found == false)         //if there is a next and not found
        {
            current = (DSAGraphNode)iter.next();        //Set current to next iter
            label = current.getLabel();                 //Set label to current node label
            if (label.equalsIgnoreCase(inLabel))        //if label equals the provided inLabel (not case sensitive) found equals true
            {
                found = true;
            }
        }
        return found;
    }
    
    /*******************************************
 *  *SUBMODULE getVertex
 *  *IMPORT: inLabel (String)
 *  *EXPORT: value (DSAGraphNode)
 *  *ASSERTION: Returns the vertex given the label
 *  ******************************************/
    public DSAGraphNode getVertex(String inLabel)
    {
        boolean found = false;
        DSAGraphNode current = null, value = null;
        Iterator iter = vertices.iterator();
        while(iter.hasNext() && found == false)                      //if there is a next and not found
        {
            current = (DSAGraphNode)iter.next();                     //Set current to next iter
            if (current.getLabel().equalsIgnoreCase(inLabel))        //if label equals the provided inLabel (not case sensitive)
            {                                                        //set found to true and value to current
                found = true;
                value = current;
            }
        }
        return value;
    }
    
    /*******************************************
 *  *SUBMODULE calculateShortestDistances
 *  *IMPORT: start (String), end (String)
 *  *EXPORT: shortestPath (String)
 *  *ASSERTION: Finds the shortest path
 *  *REFERENCE: https://medium.com/@ssaurel/calculate-shortest-paths-in-java-by-implementing-dijkstras-algorithm-5c1db06b6541  -- MORE IN PAPER
 *  ******************************************/
    public void calculateShortestDistances(String start)
    {
        getVertex(start).setTimeFromSource(0.0);        //Sets the default from source to 0 as it is the source
        getVertex(start).setDistanceFromSource(0.0);
        String nextNode = start;                        //nextNode value is set to start (Provided by user)
        
        DSAGraphNode current = null;
        Iterator iter = vertices.iterator();
        while(iter.hasNext())
        {
            current = (DSAGraphNode)iter.next();
            if (current.getEdgeCount() > 1 && isVertex(nextNode))       //Make sure a valid vertex (node)
            {
                DSALinkedList<DSAGraphEdge> currentNodeEdges = getVertex(nextNode).getEdges();      //Gets the edges to iterate through them
                DSAGraphEdge eCurrent = null;
                Iterator eIter = currentNodeEdges.iterator();
                while(eIter.hasNext())
                {
                    eCurrent = (DSAGraphEdge)eIter.next();
                    String neighbourIndex = eCurrent.getNeighbour(nextNode);       //Gets the neighbour (to)
                    if (!getVertex(neighbourIndex).getVisit())                          //If vertex (node) not visited then
                    {
                        double timeVal, distVal;
                        timeVal = getVertex(nextNode).getTimeFromSource() + eCurrent.getTime();         //Add source distance amount + time
                        distVal = getVertex(nextNode).getDistanceFromSource() + eCurrent.getKms();      //Add source distance amount + distance
                        if (timeVal < getVertex(neighbourIndex).getTimeFromSource())                    //If timeVal less than source then it's a shorter path
                        {
                            getVertex(neighbourIndex).setTimeFromSource(timeVal);                       //Set new time source time to timeVal
                            getVertex(neighbourIndex).setDistanceFromSource(distVal);                   //Set new distance source time to distVal
                        }
                    }
                }
                getVertex(nextNode).setVisited();               //Mark vertex (node) done when finished with it
                nextNode = getNodeShortestDistance();          //Get the next shortest vertex (node)
            }
        }
    }
    
    /*******************************************
 *  *SUBMODULE getNodeShortestDistance
 *  *IMPORT: none   
 *  *EXPORT: storedNodeIndex (String)
 *  *ASSERTION: Finds the node with the shortest distance
 *  ******************************************/
    public String getNodeShortestDistance()
    {
        String exportNode = null;
        double compNode = Double.MAX_VALUE;     //Set the largest initial value
        
        DSAGraphNode current = null;
        Iterator iter = vertices.iterator();
        while(iter.hasNext())
        {
            current = (DSAGraphNode)iter.next();
            double currentDist = current.getTimeFromSource();       //Get the total time from source
            if (!current.getVisit() && currentDist < compNode)      //If visited false and currentDist is less than compNode
            {                                                 
                compNode = currentDist;                             //Set the value of compNode to currentDist
                exportNode = current.getLabel();                    //Export the label name to be used in the code
            }
        }
        return exportNode;
    }
    
    /*******************************************
 *  *SUBMODULE getNearbyTimeNodes
 *  *IMPORT: inLocation (String), inTime (double)   
 *  *EXPORT: none
 *  *ASSERTION: Gets and outputs the nodes close to the given time
 *  ******************************************/
    public void getNearbyTimeNodes(String inLocation, double inTime)
    {
        DSAGraphNode current = null;
        Iterator iter = vertices.iterator();
        System.out.println("Locations nearby " + inLocation);
        while(iter.hasNext())
        {
            current = (DSAGraphNode)iter.next();
            double currentTime = current.getTimeFromSource();       //Get the total time from source
            if (currentTime < inTime)                               //If currentDist is less than compNode 
            {                       
                System.out.println("\t"+current.getLabel());        //Print all the values with a time lower than provided
            }
        }
    }
    
    /*******************************************
 *  *SUBMODULE getNearbyDistanceNodes
 *  *IMPORT: inLocation (String), inDistance (double)
 *  *EXPORT: none
 *  *ASSERTION: Gets and outputs the nodes close to the given distance
 *  ******************************************/
    public void getNearbyDistanceNodes(String inLocation, double inDistance)    //Same as above but instead of time with distance (kms)
    {
        DSAGraphNode current = null;
        Iterator iter = vertices.iterator();
        System.out.println("Locations nearby " + inLocation);
        while(iter.hasNext())
        {
            current = (DSAGraphNode)iter.next();
            double currentDist = current.getDistanceFromSource();
            if (currentDist < inDistance)
            {
                System.out.println("\t"+current.getLabel());
            }
        }
    }
    
    /*******************************************
 *  *SUBMODULE printResult
 *  *IMPORT: end (String), start (String)   
 *  *EXPORT: none
 *  *ASSERTION: Outputs the shortest path result in a readable format
 *  ******************************************/
    public void printResult(String end, String start)
    {
        //Round the time to 2 decimal places
        double rounded = Math.round(getVertex(end).getTimeFromSource() * 100.0) / 100.0;    
        
        //Convert the decimal to time
        String str = Double.toString(rounded);                          //Convert to string
        String arr[] = str.split("\\.");                                //Split at .
        int hours = Integer.parseInt(arr[0]);                           //First part is hours arr[0] and parse to Int
        int minutes = Integer.parseInt(arr[1]);                         //Second part is minutes arr[1] and parse to Int
        minutes = minutes * 6;                                          //Convert minutes to actual minutes
        String time = hours + " hours and " + minutes + " minutes";     //Make everything nicer to read!
        
        String output = ("\nThe shortest distance from "+getVertex(start).getLabel()+" to "+getVertex(end).getLabel()+" is " + time);
        System.out.println(output);     //Output the shortest distance
    }

}