package main;

public class DayThree {

    public int steps;
    public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;

    int[][] spiralMatrix;

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
        int c = 0; // counter
        int value = 1; // current value being inserted

        int[] nextCoordinate;

        int steps = 1;

        // determine starting point for matrix
        x = (int) (Math.floor(matrix.length / 2.0));
        y = (int) (Math.floor(matrix.length / 2.0));

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                for (int rep = 1; rep <= 2; rep++) {

                    // odd matrix needs only one row added, not a new column
                    if (i == matrix.length - 1) {
                        break;
                    }

                    for (int move = 0; move < steps; move++) {
                        matrix[x][y] = value;
                        System.out.println("coordinate (" + x + "," + y + ") is filled with " + value);
                        value++;

                        nextCoordinate = moveCoordinate(direction, x, y);
                        x = nextCoordinate[0];
                        y = nextCoordinate[1];
                    }
                    direction = rotateCCW(direction);

                }
                steps++;
            }
        }

        System.out.println("wrote " + c + " values to matrix");
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

    public int getShortestPath(int square) {
        return 0;
    }

}
