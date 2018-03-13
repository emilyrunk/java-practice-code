public class U1 extends Rocket{

    public U1(){
        cost = 100;
        weight = 10;
        maxWeight = 18;
        launchFailPercent = 0.05;
        landFailPercent = 0.01;
    }

    @Override
    public boolean launch() {
        //Todo: Return true based on probability of success
        return super.launch();
    }

    @Override
    public boolean land() {
        //Todo: Return true based on probability of success
        return super.land();
    }
}
