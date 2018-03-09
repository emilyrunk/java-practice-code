public class Rook extends Piece {
    //Example using super keyword for constructor
    public Rook(){
        super();
        this.name = "rook";
    }

    boolean isValidMove(Position newPosition) {
        //Example using super keyword in method
        //Call parent's method to check if position is within board's boundary
        if(!super.isValidMove(position)){
            return false;
        }
        //if first test passed, then check for specific rook movement
        if (newPosition.column == this.position.column || newPosition.row == this.position.row){
            return true;
        } else {
            return false;
        }
    }
}
