package main;

public class DayThree {

    public int steps;
    public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;

    int[][] spiralMatrix;
    int[][] coordinates;

    public DayThree(int n) {
        this.spiralMatrix = initMatrix(new int[n][n]);
    }

    private int[][] initMatrix(int[][] matrix) {

        if (matrix.length / 2 == 0) {
            throw new UnsupportedOperationException("Can only handle odd matrix sizes");
        }

        int x = 0; // current position; x
        int y = 0; // current position; y
        int[] direction = {1,0}; // direction is to the right
        int value = 1; // current value being inserted

        // determine starting coordinate for matrix
        x = (int) (Math.floor(matrix.length / 2.0));
        y = (int) (Math.floor(matrix.length / 2.0));

        // array for storing next coordinate
        int[] nextCoordinate;
        // array for storing sequential coordinates with initial size of matrix.length to the power 2
        coordinates = new int[(int) Math.pow(matrix.length, 2.0)][];
        // counter for coordinate to be added
        int counter = 0;
        // initial amount of movements before rotating the matrix
        int steps = 1;

        // loop over each coordinate
        outer:
        for (int row = 0; row < matrix.length; row++) {

            for (int column = 0; column < matrix.length; column++) {

                // repeat number of steps and rotation twice
                for (int repetition = 0; repetition < 2; repetition++) {

                    // for the odd matrix needs only one row added, not a new column
                    if (column == matrix.length - 1 && repetition == 1) {
                        break outer;
                    }

                    // loop over number of steps remaining
                    for (int k = 0; k < steps; k++) {

                        // write current value to matrix
                        matrix[x][y] = value;
                        System.out.println("coordinate (" + x + "," + y + ") is filled with " + value++);
//                        value++;

                        // save current coordinate to array for later reference
                        coordinates[counter++] = new int[] {x, y};

                        // move to next position
                        nextCoordinate = moveCoordinate(direction, x, y);
                        x = nextCoordinate[0];
                        y = nextCoordinate[1];
                    }

                    // rotate matrix after steps have completed
                    direction = rotateCCW(direction);
                }
                steps++;
            }
        }

        System.out.println("wrote " + counter + " values to matrix");
        return matrix;
    }

    private int[] rotateCCW(int[] direction) {
        int temp = direction[0];
        direction[0] = direction[1];
        direction[1] = -temp;
        return direction;
    }

    private int[] moveCoordinate(int[] direction, int x, int y) {

        return new int[]{direction[0] + x, direction[1] + y};
    }

    public int getShortestPath() {

        return 0;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        int[] currentCoordinate;
        for (int i = 0; i < coordinates.length; i++) {

            currentCoordinate = coordinates[i];
            builder.append(spiralMatrix[currentCoordinate[0]][currentCoordinate[1]]);

            if (i == coordinates.length -1) {
                break;
            }

            builder.append(",");
        }

        return builder.toString();
    }

}
