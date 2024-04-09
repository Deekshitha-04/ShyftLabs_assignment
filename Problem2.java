import java.util.ArrayList;
import java.util.List;

interface Piece {
    String getName();

    int getValue();

    boolean canMove(Board board, Position from, Position to);
}

class Pawn implements Piece {
    public String getName() {
        return "Pawn";
    }

    public int getValue() {
        return 1;
    }

    public boolean canMove(Board board, Position from, Position to) {
        int fromRow = from.getRow();
        int fromCol = from.getColumn();
        int toRow = to.getRow();
        int toCol = to.getColumn();

        if (fromCol == toCol) {
            if (toRow - fromRow == 1) {
                return true;
            }
        }
        return false;
    }
}

class Rook implements Piece {
    public String getName() {
        return "Rook";
    }

    public int getValue() {
        return 5;
    }

    public boolean canMove(Board board, Position from, Position to) {
        int fromRow = from.getRow();
        int fromCol = from.getColumn();
        int toRow = to.getRow();
        int toCol = to.getColumn();

        if (fromRow == toRow || fromCol == toCol) {
            return true;
        }
        return false;
    }
}

class Board {
    private Piece[][] grid;

    public Board() {
        grid = new Piece[8][8];
    }

    public Piece getPiece(Position position) {
        return grid[position.getRow()][position.getColumn()];
    }

    public void movePiece(Position from, Position to) {
        Piece piece = getPiece(from);
        grid[from.getRow()][from.getColumn()] = null;
        grid[to.getRow()][to.getColumn()] = piece;
    }
}

class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}

class Player {
    private String name;
    private List<Piece> pieces;

    public Player(String name) {
        this.name = name;
        pieces = new ArrayList<>();
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}

class Game {
    private Board board;
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        board = new Board();
    }

    public void play() {
        // Implement game logic
    }
}

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        player1.addPiece(new Pawn());
        player1.addPiece(new Rook());

        player2.addPiece(new Pawn());
        player2.addPiece(new Rook());

        Game game = new Game(player1, player2);
        game.play();
    }
}