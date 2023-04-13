import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRobot {
    private Position position;
    private Position previousPosition;
    private Maze maze;
    private Random random;

    /* --- RandomRobot --- */
    /**
     * Initialize this {@code Maze} and starting position for
     * the random robot.
     * @param maze that the robot is travelling through.
     */
    public RandomRobot(Maze maze){
        /* --- Initiate starting point --- */
        position = maze.getStart();
        this.maze = maze;
    }

    /* --- Method move --- */
    /**
     * Moves robot to available position, if there is no available
     * position then the previous position is accepted.
     */
    public void move(){
        /* --- See available directions --- */
        List<Position> availableDirections = new ArrayList<>();
        if(maze.isMovable(position.getPosToNorth())) {
            availableDirections.add(position.getPosToNorth());
        }
        if(maze.isMovable(position.getPosToSouth())) {
            availableDirections.add(position.getPosToSouth());
        }
        if(maze.isMovable(position.getPosToWest())) {
            availableDirections.add(position.getPosToWest());
        }
        if(maze.isMovable(position.getPosToEast())) {
            availableDirections.add(position.getPosToEast());
        }
        /* --- If no available direction exit with message --- */
        if(availableDirections.size() == 0){
            System.out.println("Robot is trapped!");
            System.exit(-1);
        }
        /* --- If only available directions is previous go there --- */
        if(availableDirections.size() == 1 &&
                availableDirections.contains(previousPosition)){
            setPosition(previousPosition);
            previousPosition = getPosition();
            return;
        }
        availableDirections.remove(previousPosition);
        /* --- Select random direction --- */
        random = new Random();
        int index = random.nextInt(availableDirections.size());
        Position nextPosition = availableDirections.get(index);
        previousPosition = getPosition();
        /* --- Update position --- */
        setPosition(nextPosition);
    }

    /* --- Method getPosition --- */
    /**
     * Retrieves position corresponding to this {@code Position}
     * @return this {@code Position} corresponding to the coordinates {@code (x,y)}
     */
    public Position getPosition(){
        return new Position(position.getX(),position.getY());
    }

    /* --- setPosition --- */
    /**
     * Change value of this {@code Position} to input position
     * @param position new position for the robot.
     */
    private void setPosition(Position position){
        this.position = position;
    }

    /* --- hasReachedGoal --- */
    /**
     * Checks if a position is equal to the position of the goal
     * @return boolean statement if the robot has reached the goal.
     */
    public boolean hasReachedGoal(){
        return maze.isGoal(getPosition());
    }
}
