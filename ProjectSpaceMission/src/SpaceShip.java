public interface SpaceShip {

    boolean launch(); //Returns true if launch successful, false if crash on launch
    boolean land();  //Returns true of landing successful, false if crash on landing
    boolean canCarry(Item i); //Returns true if rocket can carry item, or false if weight limit exceeded
    void carry(Item i); //Updates the weight of rocket
}
