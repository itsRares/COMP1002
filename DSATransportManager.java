 /***************************************************************************
 *  FILE: DSATransportManager.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Manages the menu and options
 *  LAST MOD: 19/10/17
 ***************************************************************************/

import java.util.*;
import java.io.*;
 
public class DSATransportManager
{
    public static void run()
    {
        DSAGraph graph = new DSAGraph();
        Location[] places = new Location[200];
        
        //Location value = new Location("R", "R", "R", "R", 44.4);
        //Location value2 = new Location("R", "R", "R", "R", 44.4);
        //Travel value3 = new Travel("R",  "R", "car", 0.4, 1.2, "PEEK=0.12");
        //graph.addVertex("Test", value);
        //graph.addVertex("Test2", value2);
        ////DSAGraphEdge help2 = graph.getEdge("Test3");
        //graph.addEdge(graph.getVertex("Test"), graph.getVertex("Test2"), "cars", value3);
        //graph.addEdge(graph.getVertex("Test2"), graph.getVertex("Test"), "truck", value3);
        //DSAGraphNode help = graph.getVertex("Darwin Airport");
        //int amount = graph.getVertexCount();
        //int amount2 = graph.getEdgeCount();
        ////DSALinkedList<DSAGraphNode> amount2 = help.getAdjacent();
        //System.out.println(amount + ", " + amount2 + ", ");
        
        //if (graph.getVertex("Test2") == null) {
        //    System.out.println("Vertex: " + graph.getVertex("Test"));
        //}
        //else
        //{
        //    DSAGraphNode pls = graph.getVertex("Test2");
        //    System.out.println(pls.getLabel());
        //    DSAGraphNode pls2 = graph.getVertex("Test");
        //    System.out.println(pls2.getLabel());
        //}
        mainMenu(graph);
    }
    
    /*******************************************
 *  *SUBMODULE options
 *  *IMPORT: none
 *  *EXPORT: choice (int)
 *  *ASSERTION: Choice menu for the manager
 *  ******************************************/
    private static int options()
    {
        int choice;
        
        System.out.print("\033[H\033[2J");                                              //This clears the console, from online.
        System.out.println("====================================");
        System.out.println("     \u001B[32mTransperth Journey Planner\u001B[0m");       //Bored and added some fun colours, from online
        System.out.println("====================================");
        System.out.println("(1) Travel Search");
        System.out.println("(2) Location Search");
        System.out.println("(3) Nearby Search");
        System.out.println("(4) Update Data");
        System.out.println("(5) Load data");
        //System.out.println("(6) Save Data");
        System.out.println("(0) Quit");
        System.out.println("------------------------------------");
        System.out.print("> Your Choice: ");
        
        choice = userInputInt();
        return choice;
    }
    
    /*******************************************
 *  *SUBMODULE mainMenu
 *  *IMPORT: graph (DSAGraph)
 *  *EXPORT: none
 *  *ASSERTION: The menu for the Journey Planner
 *  ******************************************/
    private static void mainMenu(DSAGraph graph)
    {
        int choice;
        boolean run = true;
        
        while(run)                              //Keep running main until user chooses a valid option
        {
            choice = options();
            switch (choice)
            {
                case 0:
                    System.out.println("------------------------------------");
                    System.out.println("    Thanks for using Transperth\n    Journey Planner! Goodbye o/");
                    System.out.println("------------------------------------");
                    run = false;
                    break;
                case 1:
                    travelSearch(graph);
                    run = false;
                    break;
                case 2:
                    locationSearch(graph);
                    run = false;
                    break;
                case 3:
                    nearbySearch(graph);
                    run = false;
                    break;
                case 4:
                    updateData();
                    run = false;
                    break;
                case 5:
                    loadData(graph);
                    run = false;
                    break;
                case 6:
                    saveData();
                    run = false;
                    break;
                default:
                  System.out.println("------------------------------------");
                  System.out.println("Error: Please input 0,1,2,3,4,5 or 6");
                  System.out.println("------------------------------------");
            }
        }
    }
    
    private static void menuOption(DSAGraph graph)
    {
        Scanner sc = new Scanner(System.in);
        char conti;
        
        //Allow user to search again, else go back to main menu
        System.out.println("\n- Would you like to return to main menu? (y/n)");
        System.out.print("> Your choice: ");
        try {
            conti = sc.nextLine().charAt(0);
            if (conti == 'T' || conti == 'y') {
                mainMenu(graph);
            }
        }
            catch (Exception e)
        {
            System.out.println("------------------------------------");
            System.out.println("> Error: Invalid input");
        }
    }
    
    /*******************************************
 *  *SUBMODULE travelSearch
 *  *IMPORT: graph (DSAGraph)
 *  *EXPORT: none
 *  *ASSERTION: User gives 2 locations then calc the shortest distance to get there
 *  ******************************************/
    private static void travelSearch(DSAGraph graph)
    {
        Scanner sc = new Scanner(System.in);
        int amount = graph.getVertexCount();
        String choice1, choice2;
        
        System.out.print("\033[H\033[2J"); //This clears the console, from online.
        System.out.println("====================================");
        System.out.println("         Plan Your Journey");
        System.out.println("====================================");
        if (amount == 0)    //If no vertices (nodes) in graph output message
        {
            System.out.println("> No Locations found! Please load in a file\\s");
            System.out.println("------------------------------------");
        }
        else
        {
            
            System.out.println("- Where does your journey start? (Eg. Perth Airport)");
            System.out.print("> Start: ");
            choice1 = sc.nextLine();
            try
            {   //If their choice is valid then go to next step
                graph.calculateShortestDistances(choice1);
                System.out.println("- Where does your journey End? (Eg. Darwin Airport)");
                System.out.print("> End: ");
                choice2 = sc.nextLine();
                try
                {  //If their choice is valid then go to next step
                    graph.printResult(choice2, choice1);
                }
                catch (Exception e) 
                {
                    System.out.println("------------------------------------");
                    System.out.println("> Error: No journey plan found.");
                }
            }
            catch (Exception e) 
            {
                System.out.println("------------------------------------");
                System.out.println("> Error: This isnt a location");
            }
        }
        
        //Allow user to go back to the main menu after done, else close the program
        menuOption(graph);
    }
    
    /*******************************************
 *  *SUBMODULE locationSearch
 *  *IMPORT: graph (DSAGraph)
 *  *EXPORT: none
 *  *ASSERTION: User gives a string and any matching locations info is shown
 *  ******************************************/
    private static void locationSearch(DSAGraph graph)
    {
        Scanner sc = new Scanner(System.in);
        int amount = graph.getVertexCount(), count = 0;
        String choice;
        char conti;
        boolean searching = true;
        Location l;
        
        System.out.print("\033[H\033[2J"); //This clears the console, from online.
        System.out.println("====================================");
        System.out.println("         Search a Location");
        System.out.println("====================================");
        if (amount == 0)    //If no vertices (nodes) in graph output message
        {
            System.out.println("> No Locations found! Please load in a file\\s");
            System.out.println("------------------------------------");
            menuOption(graph);
        }
        else
        {
            while (searching)   //Keep looping search until user says no
            {
                System.out.println("- Enter location\\s you would like info on (Eg. Perth)");
                System.out.print("> Location: ");
                choice = sc.nextLine();
                
                System.out.println("Here are the locations that contain: "+choice);
                for (int ii = 0; ii < amount; ii++) //Loop through all vertices (nodes)
                {
                    l = graph.getPlaces(ii);    //Get location ii and check if matches
                    if (l.getName().toLowerCase().contains(choice.toLowerCase()))   //if choice contains a location print info
                    {
                        count++;
                        System.out.println("\t"+l.getName()+", "+l.getCountry()+", "+l.getState()+", "+l.getDesc());
                    }
                }
                if (count == 0)
                {
                    System.out.println("\tNo locations found.");
                }
                
                //Allow user to search again, else go back to main menu
                System.out.println("\n- Would you like to return to main menu? (y/n)");
                System.out.print("> Your choice: ");
                try {
                    conti = sc.nextLine().charAt(0);
                    if (conti == 'T' || conti == 'y') {
                        mainMenu(graph);
                        searching = false;
                    }
                }
                    catch (Exception e)
                {
                    System.out.println("------------------------------------");
                    System.out.println("> Error: Invalid input");
                }
            }
        }
    }
    
    /*******************************************
 *  *SUBMODULE nearbySearch
 *  *IMPORT: graph (DSAGraph)
 *  *EXPORT: none
 *  *ASSERTION: User gives their location and nearby type and limit and locations around are shown
 *  ******************************************/
    private static void nearbySearch(DSAGraph graph)
    {
        Scanner sc = new Scanner(System.in);
        int amount = graph.getVertexCount();
        String choice;
        char type;
        double min, km;
        boolean noValid = true;
        
        System.out.print("\033[H\033[2J"); //This clears the console, from online.
        System.out.println("====================================");
        System.out.println("       Visit Nearby Locations");
        System.out.println("====================================");
        if (amount == 0)    //If no vertices (nodes) in graph output message
        {
            System.out.println("> No Locations found! Please load in a file\\s");
            System.out.println("------------------------------------");
        }
        else
        {
            System.out.println("- Where does your journey start? (Eg. Perth Airport)");
            System.out.print("> Start: ");
            choice = sc.nextLine();
            if (graph.isVertex(choice)) {   //If their choice is valid then go to next step
                graph.calculateShortestDistances(choice);
                System.out.println("- How do we search? (t-Time, d-Distance)");
                System.out.print("> Type: ");
                do {    //Keep looping until user inputs a valid option
                    type = sc.nextLine().charAt(0);
                    switch (type)
                    {
                        case 'T': case 't':
                            noValid = false;    //Stop looping
                            System.out.println("- How long away can locations be? (Hour)");
                            System.out.print("> Time: ");
                            min = sc.nextDouble();   //Get user input
                            graph.getNearbyTimeNodes(choice, min);
                            sc.nextLine();
                            break;
                        case 'D': case 'd':
                            noValid = false;
                            System.out.println("- How far away can locations be? (Km)");
                            System.out.print("> Distance: ");
                            km = sc.nextDouble();   //Get user input
                            graph.getNearbyDistanceNodes(choice, km);
                            sc.nextLine();
                            break;
                        default:
                            System.out.print("> Error: Please input t or d: ");
                    }
                } while(noValid);
            }
            else
            {
                System.out.println("------------------------------------");
                System.out.println("Error: This isnt a location");
            }
        }
        
        //Allow user to go back to the main menu after done, else close the program
        menuOption(graph);
    }
    
    //Update data
    private static void updateData()
    {
        System.out.println("Update data happens here");
    }
    
    /*******************************************
 *  *SUBMODULE loadData
 *  *IMPORT: graph (DSAGraph)
 *  *EXPORT: none
 *  *ASSERTION: User inputs a location/distance csv then this loads the data into the graph
 *  ******************************************/
    private static void loadData(DSAGraph graph)
    {    
        Scanner sc = new Scanner(System.in);
        String filename, filename2;
        char type;
        int lines;
        boolean valid;
        
        System.out.print("\033[H\033[2J"); //This clears the console, from online.
        System.out.println("====================================");
        System.out.println("            Load in Data");
        System.out.println("====================================");
        System.out.println("- Enter location filename you would like to load");
        System.out.print("> File: ");
        filename = sc.nextLine();       //Get locations file
        valid = readFile(graph, filename, "locations");     //Validate the file inputted 
        if (valid)      //If valid then go to next stop
        {
            System.out.println("- Enter distances filename you would like to load");
            System.out.print("> File: ");
            filename2 = sc.nextLine();      //Get distances file
            readFile(graph, filename2, "distances");    //Validate the file inputed
        }
        
        //Allow user to go back to the main menu after done, else close the program
        menuOption(graph);
    }
    
    //Savedata - Only do if everything complete
    private static void saveData()
    {
        System.out.println("Save data happens here");
    }
    
    /*******************************************
 *   *SUBMODULE readFile
 *   *IMPORT: graph (DSAGraph), filename (String), type (String)
 *   *EXPORT: none
 *   *ASSERTION: Open and read the file by every line
 *  ******************************************/
    public static boolean readFile(DSAGraph graph, String fileName, String type)
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line;
        boolean valid = false;
        int vAmount, eAmount;

        //try catch block which detects any errors and outputs them
        try
        {
            fileStrm = new FileInputStream(fileName);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            int lineNum = 0;
            line = bufRdr.readLine();
            while (line != null)    //Until no more lines loop
            {
                lineNum++;
                if (type.equals("locations"))           //If location file do this
                {
                    processLocations(graph, line);      //Process locations
                    line = bufRdr.readLine();           //Next line
                }
                else                                    //If distances file do this
                {
                    processDistances(graph, line);      //Process distances
                    line = bufRdr.readLine();           //Next line
                }
            }
            //Output message when done
            vAmount = graph.getVertexCount();
            eAmount = graph.getEdgeCount();
            System.out.println("@ Success! There are "+ vAmount + " vertices and " + eAmount + " edges!");      //Output amount in graph
            fileStrm.close();
            valid = true;
        }   
            catch (IOException e)   //Catch exceptions
        {
            if (fileStrm != null)   //If file isnt null close it before throwing exception
            {
                try
                {
                fileStrm.close();
                }
                catch (IOException ex2){ }
            }
            System.out.println("------------------------------------");
            System.out.println("Error in file processing: " + e.getMessage());
        }
        return valid;
    }
    
    /*******************************************
 *   *SUBMODULE processDistances
 *   *IMPORT: graph (DSAGraph), csvRow (String)
 *   *EXPORT: none
 *   *ASSERTION: Process the distances and add it to the graph
 *  ******************************************/
    public static void processDistances(DSAGraph graph, String csvRow)
    {
        String string, from, to, type, peek;
        double kms, time;
        String[] lineArray = csvRow.split(",");
        
        try
        {
        //Place it in array
        from = lineArray[0];
        to = lineArray[3];
        type = lineArray[6];
        kms = Double.parseDouble(lineArray[7]);
        time = timeToDouble(lineArray[8]);
        
        DSAGraphNode node1 = graph.getVertex(from);
        if (node1.isEdge(from+"+"+to+"="+type)) {                                                           //Check to make sure not already a edge (node)
                System.out.println("It seems: "+from+"+"+to+"="+type+" is already a edge!");
        }
        else
        {
            if(lineArray.length == 10){                                                                     //If length is 10 peak is included
                peek = lineArray[9];
                Travel value = new Travel(from, to, type, kms, time, peek);                                 //Create new travel object with values
                graph.addEdge(graph.getVertex(to), graph.getVertex(from), from+"+"+to+"="+type, value);     //Add it to the graph
            }
            else                                                                                            //Else manually include peak at 0
            {
                Travel value = new Travel(from, to, type, kms, time, "peak=0");                             //Create new travel object with values
                graph.addEdge(graph.getVertex(to), graph.getVertex(from), from+"+"+to+"="+type, value);     //Add it to the graph
            }
        }
        }
            catch (Exception e)                                                                             //Catch any exceptions
        {
            System.out.println("------------------------------------");
            System.out.println("Error processing the file, input a valid file.");
        }
    }
    
    /*******************************************
 *   *SUBMODULE timeToDouble
 *   *IMPORT: time (String)
 *   *EXPORT: combined (double)
 *   *ASSERTION: Convert a time to a double value
 *  ******************************************/
    public static double timeToDouble(String time) {
        String[] Stime = time.split(":");               //Split time to array
        double hour, mins, hoursInMins, combined;
        
        hour = Double.parseDouble(Stime[0]);            //Parse hour to double
        mins = Double.parseDouble(Stime[1]);            //Parse mins to double
        hoursInMins = hour * 60;                        //Convert hour to minutes
        combined = (hoursInMins + mins)/60;             //Add together then divide by 60 to get hours
        return combined;
    }
    
    /*******************************************
 *   *SUBMODULE processDistances
 *   *IMPORT: graph (DSAGraph), csvRow (String)
 *   *EXPORT: none
 *   *ASSERTION: Process the distances and add it to the graph
 *  ******************************************/
    public static void processLocations(DSAGraph graph, String csvRow)
    {
        String thisToken = null;
        StringTokenizer strTok;
        String processName, processState, processCountry, processDesc;
        String name = "", state = "", desc = "", country = "";
        char c = csvRow.charAt(0);
        
        if (c == 'L') {                                                     //If the first char is L it's a location    
            strTok = new StringTokenizer(csvRow, ":");
            while (strTok.hasMoreTokens()) {
                thisToken = strTok.nextToken();
                if (!thisToken.equals("LOCATION")) {                        //If the first token is LOCATION then start process
                    
                    //Processes and checks if not empty if isnt then value = this
                    processName = processName(thisToken);
                    processState = processState(thisToken);
                    processCountry = processCountry(thisToken);
                    processDesc = processDesc(thisToken);
                    
                    if(!processName.equals(""))
                    {
                        name = processName;
                    }
                    else if (!processState.equals(""))
                    {
                        state = processState;
                    }
                    else if (!processCountry.equals(""))
                    {
                        country = processCountry;
                    }
                    else if (!processDesc.equals(""))
                    {
                        desc = processDesc;
                    }
                }
            }
            
            if (graph.isVertex(name)) {                                             //Check to make sure not already a vertice (node)
                System.out.println("It seems: " +name+ " is already a vertex!");
            }
            else
            {
                Location value = new Location(name, state, desc, country, 44.4);    //Create new location object
                graph.addVertex(name, value);                                       //Create a new vertice (node) with object
            }
        }
    }
    
    /*******************************************
 *   *SUBMODULE processName
 *   *IMPORT: line (String)
 *   *EXPORT: string (String)
 *   *ASSERTION: if line[0] equals NAME then process it 
 *  ******************************************/
    public static String processName(String line)
    {
        String string = "";
        String[] lineArray = line.split("=");       //Split string at '='
        if(lineArray[0].equals("NAME"))             //If line[0] equals NAME then return line[1]
        {
            string = lineArray[1];
        }
        return string;
    }

    /*******************************************
 *   *SUBMODULE processState
 *   *IMPORT: line (String)
 *   *EXPORT: string (String)
 *   *ASSERTION: if line[0] equals STATE then process it 
 *  ******************************************/
    public static String processState(String line)
    {
        String string = "";
        String[] lineArray = line.split("=");                         //Split string at '='
        if(lineArray[0].equals("STATE") && lineArray.length > 1)      //If line[0] equals STATE and above 1 length  then return line[1]
        {
            string = lineArray[1];
        }
        return string;
    }

    /*******************************************
 *   *SUBMODULE processCountry
 *   *IMPORT: line (String)
 *   *EXPORT: string (String)
 *   *ASSERTION: if line[0] equals COUNTRY then process it 
 *  ******************************************/
    public static String processCountry(String line)
    {
        String string = "";
        String[] lineArray = line.split("=");                           //Split string at '='
        if(lineArray[0].equals("COUNTRY") && lineArray.length > 1)      //If line[0] equals COUNTRY and above 1 length then return line[1]
        {
            string = lineArray[1];
        }
        return string;
    }
    
    /*******************************************
 *   *SUBMODULE processDesc
 *   *IMPORT: line (String)
 *   *EXPORT: string (String)
 *   *ASSERTION: if line[0] equals DESCRIPTION then process it 
 *  ******************************************/
    public static String processDesc(String line)
    {
        String string = "";
        String[] lineArray = line.split("=");       //Split string at '='
        if(lineArray[0].equals("DESCRIPTION"))      //If line[0] equals DESCRIPTION then return line[1]
        {
            string = lineArray[1];
        }
        return string;
    }
    
    /*******************************************
 *   *SUBMODULE userInputInt
 *   *IMPORT: none
 *   *EXPORT: val (int)
 *   *ASSERTION: Sanatizes the user int input
 *  ******************************************/
    private static int userInputInt()
    {
        Scanner sc = new Scanner(System.in);
        int choice, val;
        
        choice = sc.nextInt();
        if (choice >= 0)
        {
            val = choice;
        }
        else
        {
            val = -1;
        }
        return val;
    }
    
}