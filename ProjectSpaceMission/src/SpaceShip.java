public interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry();
    void carry(Item i);
}
