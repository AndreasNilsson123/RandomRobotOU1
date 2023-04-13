import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RobotTest {
    public static void main(String[] args) {
        /* --- Load input file --- */
        if (args.length != 1) {
            System.out.println("Usage: java RobotTest <filename>");
            return;
        }
        String fileName = args[0];
        Maze maze = null;

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            maze = new Maze(scanner);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        /* --- Move RandomRobot through maze --- */
        System.out.println("Position: (x,y)");
        if(maze != null) {
            RandomRobot robot = new RandomRobot(maze);
            int maxIterations = 10000; //Set maximum iterations
            int numIterations = 0; // Initialize iterations
            while (!robot.hasReachedGoal() && numIterations < maxIterations) {
                robot.move(); // Move robot
                System.out.println("("+robot.getPosition().getX()+ ","+robot.getPosition().getY()+")");
                numIterations++;
            }
            if (robot.hasReachedGoal()) {
                System.out.println("Goal reached in "+numIterations+" iterations!");
            } else {
                System.out.println("Maximum number of iterations reached");
            }
        } else {
            System.out.println("Maze did not load correctly: check input file");
        }
    }

}
