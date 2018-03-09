public class Queen extends Piece {
    boolean isValidMove(Position newPosition) {
        if (((Math.abs(newPosition.column - this.position.column) == Math.abs(newPosition.row - this.position.row)) ||
                (newPosition.column == this.position.column || newPosition.row == this.position.row))) {
            return true;
        } else {
            return false;
        }
    }
}
