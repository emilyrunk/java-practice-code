public class Rocket implements SpaceShip {

    int cost;
    double weight;
    double maxWeight;
    double launchFailPercent;
    double landFailPercent;



    @Override
    public boolean launch() {
        double variablePercentage = (double) (weight/maxWeight);
//        System.out.println("Variable Percentage: " + variablePercentage);

        double launchExplosionRate = launchFailPercent * variablePercentage;
//        System.out.println("Launch Explosion Rate: " + launchExplosionRate);

        double explosionRoll = Math.random();
//        System.out.println("Random Explosion Roll: " + explosionRoll);

        if(explosionRoll <= launchExplosionRate) {
            return false;
        }
        return true;
    }

    @Override
    public boolean land() {
        double variablePercentage = (double) (weight/maxWeight);
//        System.out.println("Variable Percentage: " + variablePercentage);

        double landingExplosionRate = landFailPercent * variablePercentage;
//        System.out.println("Landing Explosion Rate: " + landingExplosionRate);

        double explosionRoll = Math.random();
//        System.out.println("Random Explosion Roll: " + explosionRoll);

        if(explosionRoll <= landingExplosionRate) {
            return false;
        }
        return true;
    }

    @Override
    public boolean canCarry(Item i) {
        if((weight + i.weight) <= maxWeight){
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item i) {
        weight += i.weight;
    }
}
