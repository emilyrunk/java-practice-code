import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    File phase1 = new File("phase-1.txt");
    File phase2 = new File("phase-2.txt");


    public ArrayList<Item> loadItems(File phaseFileName){

        ArrayList<Item> listOfItems = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(phaseFileName);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("=");
                String itemName = parts[0];
                String itemWeight = parts[1];
                Item item = new Item();
                item.name = itemName;
                item.weight = Integer.parseInt(itemWeight);
                listOfItems.add(item);
            }
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }

        return listOfItems;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> listOfItems ){
        //Todo: fill up 1 U1 rocket with as many items before creating a new rockets until all items loaded
        //Todo: returns ArrayList of U1 rockets that are fully loaded

        Collections.sort(listOfItems);
        ArrayList<U1> U1Loads = new ArrayList<U1>();
        while(!listOfItems.isEmpty()) {
            ArrayList<Item> copyList = new ArrayList<Item>(listOfItems);
            U1 rocket = new U1();
            for (Item item: copyList) {
                System.out.println(item.weight);
                //If the rocket can carry the item, then carry it and remove it from the list of items to be loaded
                if (rocket.canCarry(item)) {
                    rocket.carry(item);

                    listOfItems.remove(item);
                }
            }
            U1Loads.add(rocket);

        }

        return U1Loads;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> listOfItems ){
        //Todo: fill up 1 U1 rocket with as many items before creating a new rockets until all items loaded
        //Todo: returns ArrayList of U1 rockets that are fully loaded
        ArrayList<U2> U2Loads = new ArrayList<U2>();
        return U2Loads;
    }

    public int runSimulation(ArrayList<Rocket> listOfRockets) {
        int rocketCost = 0;
        return rocketCost;
    }


}
