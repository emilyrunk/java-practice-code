public class U2 extends Rocket {

    public U2() {
        cost = 120;
        weight = 16329.3; //18 tons converted to kg
        maxWeight = 26308.4; //29 tons converted to kg
        launchFailPercent = 0.04;
        landFailPercent = 0.08;
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
