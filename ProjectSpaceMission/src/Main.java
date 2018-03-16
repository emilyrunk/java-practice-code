import java.util.ArrayList;
import java.util.Arrays;

public class Main {




    public static void main(String[] args ){

        Simulation U1Phase1Sim = new Simulation();
        int u1Phase1Cost = U1Phase1Sim.runCostSimulation(Simulation.ROCKETTYPEU1, Simulation.PHASE1);
        System.out.println("Phase 1 with U1 Rockets costs: $" + u1Phase1Cost + " million.");

        Simulation U1Phase2Sim = new Simulation();
        int u1Phase2Cost = U1Phase2Sim.runCostSimulation(Simulation.ROCKETTYPEU1,Simulation.PHASE2);
        System.out.println("Phase 2 with U1 Rockets costs: $" + u1Phase2Cost + " million.");

        System.out.println("Total Cost of Mission using U1 rockets is: $" + (u1Phase1Cost + u1Phase2Cost) + " million.");


        Simulation U2Phase1Sim = new Simulation();
        int u2Phase1Cost = U2Phase1Sim.runCostSimulation(Simulation.ROCKETTYPEU2, Simulation.PHASE1);
        System.out.println("Phase 1 with U1 Rockets costs: $" + u2Phase1Cost + " million.");

        Simulation U2Phase2Sim = new Simulation();
        int u2Phase2Cost = U2Phase2Sim.runCostSimulation(Simulation.ROCKETTYPEU2,Simulation.PHASE2);
        System.out.println("Phase 2 with U1 Rockets costs: $" + u2Phase2Cost + " million.");


        System.out.println("Total Cost of Mission using U1 rockets is: $" + (u1Phase1Cost + u1Phase2Cost) + " million.");

        System.out.println("Total Cost of Mission using U2 rockets is: $" + (u2Phase1Cost + u2Phase2Cost) + " million.");

    }

}
