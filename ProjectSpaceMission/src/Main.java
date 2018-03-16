import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args ){
//
//        U1 rocket = new U1();
//        Item item1 = new Item();
//        item1.name = "habitat";
//        item1.weight = 3000;
//
//        System.out.println(rocket.canCarry(item1));
//
//        System.out.println("success? : " + rocket.launch());

        Simulation U1Phase1Sim = new Simulation();
        ArrayList<Item> listOfPhase1Items = U1Phase1Sim.loadItems(U1Phase1Sim.phase1);
        ArrayList<U1> U1Phase1Rockets = U1Phase1Sim.loadU1(listOfPhase1Items);
        ArrayList<Rocket> U1Phase1RocketList = new ArrayList<Rocket>(U1Phase1Rockets);

        System.out.println(U1Phase1Rockets.size());
        int u1Phase1Cost = U1Phase1Sim.runSimulation(U1Phase1RocketList);
        System.out.println("Phase 1 with U1 Rockets costs: $" + u1Phase1Cost + " million.");


        Simulation U1Phase2Sim = new Simulation();
        ArrayList<Item> listofPhase2Items = U1Phase2Sim.loadItems(U1Phase2Sim.phase2);
        ArrayList<U1> U1Phase2Rockets = U1Phase2Sim.loadU1(listofPhase2Items);
        ArrayList<Rocket> U1Phase2RocketList = new ArrayList<Rocket>(U1Phase2Rockets);
        System.out.println(U1Phase1Rockets.size());
        int u1Phase2Cost = U1Phase2Sim.runSimulation(U1Phase2RocketList);
        System.out.println("Phase 2 with U1 Rockets costs: $" + u1Phase2Cost + " million.");

        System.out.println("Total Cost of Mission using U1 rockets is: $" + (u1Phase1Cost + u1Phase2Cost) + " million.");





//        for (Item item:listOfItems) {
//            System.out.println(item.toString());
//        }




    }

}
