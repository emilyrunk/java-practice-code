public class Rocket implements SpaceShip {
    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry() {
        //Todo: implement class here, not overridden in U1
        return false;
    }

    @Override
    public void carry(Item i) {
        //Todo: implement class here, not overridden in U1

    }
}
