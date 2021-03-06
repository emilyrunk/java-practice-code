import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Simulation {
    public static final String ROCKETTYPEU1 = "U1";
    public static final String ROCKETTYPEU2 = "U2";
    public static final String PHASE1 = "phase1";
    public static final String PHASE2 = "phase2";

    File phase1 = new File("phase-1.txt");
    File phase2 = new File("phase-2.txt");


    public ArrayList<Item> loadItems(File phaseFileName){

        ArrayList<Item> listOfItems = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(phaseFileName);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                listOfItems.add(parseLine(line));
            }
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }

        return listOfItems;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> listOfItems ){
        Collections.sort(listOfItems); //Sort the ArrayList so that items are descending by weight
        ArrayList<U1> U1Loads = new ArrayList<U1>(); //Create ArrayList of loaded U1 Rockets
        while(!listOfItems.isEmpty()) { //While listOfItems has items in it

            //Make a copy of the listOfItems to be loaded so it can be used to iterate the loop
            ArrayList<Item> copyList = new ArrayList<Item>(listOfItems);

            U1 rocket = new U1(); //Create a new rocket
            //For every item in the iterable list of items, if the rocket can carry the weight,
            //carry it and remove it from the list of items
            for (Item item: copyList) {
                //If the rocket can carry the item, then carry it and remove it from the list of items to be loaded
                if (rocket.canCarry(item)) {
                    rocket.carry(item);
                    listOfItems.remove(item);
                }
            } //Loop until every item is removed from listofitems
            //Add the loaded rocket to the list of loaded rockets
            U1Loads.add(rocket);
        }

        return U1Loads; //Number of loaded U1 rockets
    }

    public ArrayList<U2> loadU2(ArrayList<Item> listOfItems ){
        Collections.sort(listOfItems); //Sort the ArrayList so that items are descending by weight
        ArrayList<U2> U2Loads = new ArrayList<U2>();
        while(!listOfItems.isEmpty()) { //While listOfItems has items in it

            //Make a copy of the listOfItems to be loaded so it can be used to iterate the loop
            ArrayList<Item> copyList = new ArrayList<Item>(listOfItems);

            U2 rocket = new U2(); //Create a new rocket
            //For every item in the iterable list of items, if the rocket can carry the weight,
            //carry it and remove it from the list of items
            for (Item item: copyList) {
                //If the rocket can carry the item, then carry it and remove it from the list of items to be loaded
                if (rocket.canCarry(item)) {
                    rocket.carry(item);
                    listOfItems.remove(item);
                }
            } //Loop until every item is removed from listofitems
            //Add the loaded rocket to the list of loaded rockets
            U2Loads.add(rocket);
        }

        return U2Loads; //Number of loaded U2 rockets
    }

    public int runSimulation(ArrayList<Rocket> listOfRockets) {

        int rocketCount = 0;

        for (Rocket rocket: listOfRockets) {
            rocketCount++;
            System.out.println("*****Initalize rocket. rocket count = " + rocketCount);

            while ((!rocket.launch()) || (!rocket.land())) {
                rocketCount ++;
                System.out.println("Rocket Launch or Landing Failed. rocket count = " + rocketCount);
            }

        }


        System.out.println("All rockets launched and landed. Total rocket count = " + rocketCount);


        int rocketCost = (rocketCount * listOfRockets.get(0).cost);

        System.out.println("Total Rocket Cost = " + rocketCost);
        return rocketCost;
    }

    public int runCostSimulation(String rocketType, String phase){
        ArrayList<Item> listOfItems = new ArrayList<Item>();
        if(phase.equals("phase1")) {
            listOfItems = this.loadItems(this.phase1);
        }else if(phase.equals("phase2")) {
            listOfItems = this.loadItems(this.phase2);
        }

        int rocketCost = 0;

        if (rocketType.equals("U1")) {
            ArrayList<U1>list = this.loadU1(listOfItems);
            ArrayList<Rocket> U1RocketList = new ArrayList<Rocket>(list);
            rocketCost =  this.runSimulation(U1RocketList);
        } else if(rocketType.equals("U2")) {
            ArrayList<U2> list = this.loadU2(listOfItems);
            ArrayList<Rocket> U2RocketList = new ArrayList<Rocket>(list);
            rocketCost = this.runSimulation(U2RocketList);
        }

        return rocketCost;

    }




    private Item parseLine(String nextLine){
        String[] parts = nextLine.split("=");
        String itemName = parts[0];
        String itemWeight = parts[1];
        Item item = new Item();
        item.name = itemName;
        item.weight = Integer.parseInt(itemWeight);
        return item;
    }


}
