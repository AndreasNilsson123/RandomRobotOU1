import java.util.Objects;

public class Position {
    private int x;
    private int y;

    /* --- Position --- */
    /**
     * A point representing a location in {@code (x,y)} in
     * coordinate space
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /* --- Method getX --- */
    /**
     * Returns the x-coordinate of this {@code Position}
     * in integer precision.
     * @return the x-coordinate
     */
    public int getX(){
        return x;
    }

    /* --- Method getY --- */
    /**
     * Returns the y-coordinate of this {@code Position}
     * in integer precision.
     * @return the y-coordinate
     */
    public int getY(){
        return y;
    }
    /* --- Method getPosToSouth --- */
    /**
     * Returns the {@code (x,y)} coordinate of the position
     * south of {@code Position}
     * @return coordinate south of this {@code Position}
     */
    public Position getPosToSouth(){
        return new Position(x,y+1);
    }
    /* --- Method getPosToNorth --- */
    /**
     * Returns the {@code (x,y)} coordinate of the position
     * north of {@code Position}
     * @return coordinate north of this {@code Position}
     */
    public Position getPosToNorth(){
        return new Position(x,y-1);
    }
    /* --- Method getPosToWest --- */
    /**
     * Returns the {@code (x,y)} coordinate of the position
     * west of {@code Position}
     * @return coordinate west of this {@code Position}
     */
    public Position getPosToWest(){
        return new Position(x-1,y);
    }
    /* --- Method getPosToEast --- */
    /**
     * Returns the {@code (x,y)} coordinate of the position
     * east of {@code Position}
     * @return coordinate east of this {@code Position}
     */
    public Position getPosToEast(){
        return new Position(x+1,y);
    }

    /* --- Method equals --- */
    /**
     * Returns a boolean statement, for two points being equal according to
     * their coordinates {@code (x,y)}.
     * @param o corresponding to this {@code Position}
     * @return boolean statement if two points are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    /* --- Method hashCode --- */
    /**
     * Returns unique integer corresponding to the coordinates {@code (x,y)}
     * @return hash integer for coordinates {@code (x,y)}
     */
    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
