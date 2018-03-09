public class Game {
    Piece [][] board;

    Game() {
        board = new Piece[8][8];
    }

    public static void main(String [] args) {
        Queen queen = new Queen();
        queen.position = new Position(3,5);

        Position newPos = new Position(4,8);
        if (queen.isValidMove(newPos)) {
            System.out.println("Yes! You can move there.");
        } else {
            System.out.println("Nope. Can't move there");
        }
    }

}
