public class Rocket implements SpaceShip {

    int cost;
    int weight;
    int maxWeight;
    double launchFailPercent;
    double landFailPercent;



    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item i) {
        if((weight + i.weight) < maxWeight){
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item i) {
        weight += i.weight;
    }
}
