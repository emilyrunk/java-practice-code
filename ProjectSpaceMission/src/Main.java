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

        Simulation sim = new Simulation();
        ArrayList<Item> listOfItems = sim.loadItems(sim.phase1);
        ArrayList<U1> U1List = sim.loadU1(listOfItems);
        ArrayList<Rocket> U1RocketList = new ArrayList<Rocket>(U1List);

        System.out.println(U1List.size());
        sim.runSimulation(U1RocketList);

//        for (Item item:listOfItems) {
//            System.out.println(item.toString());
//        }




    }

}
