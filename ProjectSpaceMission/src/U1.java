public class U1 extends Rocket{

    public U1(){
        cost = 100;
        weight = 9071.85; //10 tons converted to kg
        maxWeight = 16329.3; //18 tons converted to kg
        launchFailPercent = 0.05;
        landFailPercent = 0.01;
    }

    @Override
    public boolean land() {
        //Todo: Return true based on probability of success
        return super.land();
    }
}
