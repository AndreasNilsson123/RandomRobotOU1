import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze {
    private final char[][] maze;
    private int startRow;
    private int startCol;
    private int goalRow;
    private int goalCol;
    private final int numRows;
    private final int numCols;

    /* --- Reads in maze from scanner --- */
    /**
     * Takes a scanner for a maze and initialize the maze according to
     * walls are given by "*", start position by "S", goal by "G" and
     * open spaces by blank space.
     * @param scanner which holds a {@code Scanner} to the given maze
     */
    public Maze(Scanner scanner) {
        ArrayList<String> rows = new ArrayList<>();
        ArrayList<Integer> rowWidths = new ArrayList<>();
        boolean startSeen = false;
        boolean goalSeen = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break; // stop reading if we encounter an empty line
            }
            rows.add(line);
            rowWidths.add(line.length());
        }

        numRows = rows.size();
        numCols = Collections.max(rowWidths);

        maze = new char[numCols][numRows];

        for (int i = 0; i < numRows; i++) {
            String row = rows.get(i);
            int rowWidth = rowWidths.get(i);

            // pad shorter rows with spaces
            if (rowWidth < numCols) {
                row = String.format("%-" + numCols + "s", row);
            }

            for (int j = 0; j < numCols; j++) {
                char c = row.charAt(j);
                maze[j][i] = c;
                System.out.print(maze[j][i]);
                if (c == 'S') {
                    startRow = i;
                    startCol = j;
                    startSeen = true;
                } else if (c == 'G') {
                    goalRow = i;
                    goalCol = j;
                    goalSeen = true;
                }
            }
            System.out.println();

        }
        if(!startSeen){
            System.out.println("Maze has no starting point!");
            System.exit(-1);
        }
        if(!goalSeen){
            System.out.println("Maze has no goal point!");
            System.exit(-1);
        }
    }

    /* --- Method isMovable --- */
    /**
     * Check if it's possible to move to this {@code Position}, no check
     * if new position is valid from current {@code Position}.
     * @param position check for this {@code Position}
     * @return a boolean statement if the new position is valid or not
     */
    public boolean isMovable(Position position){
        int posX = position.getX();
        int posY = position.getY();
        if(posX<0 || posX >= getNumColumns() || posY<0 || posY >= getNumRows())
            return false;
        return maze[posX][posY] != '*';
    }

    /* --- Method isGoal --- */
    /**
     * Returns a boolean statement if this {@code Position} is equal
     * to the position of the goal.
     * @param position is the {@code Position} that is compared with the goal position
     * @return boolean if {@code Position} is considered the same
     */
    public boolean isGoal(Position position){
        Position goalPos = new Position(goalCol, goalRow);
        return position.equals(goalPos);
    }

    /* --- Method getStart --- */
    /**
     * Get start position for this {@code Maze}
     * @return {@code Position} of the starting point
     */
    public Position getStart(){
        return new Position(startCol, startRow);
    }

    /* --- Method getNumColumns --- */
    /**
     * Retrieves the maximum number of columns according to this {@code Maze}
     * @return an integer corresponding to the maximum number of columns
     */
    public int getNumColumns(){
        return numCols;
    }

    /* --- Method getNumRows --- */
    /**
     * Retrieves the number of rows according to this {@code Maze}
     * @return an integer corresponding to the number of rows
     */
    public int getNumRows(){
        return numRows;
    }
}
