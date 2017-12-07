package main;

import java.math.BigInteger;
import java.util.Arrays;

public class DayThree {

    private int[][] spiralMatrix;
    private BigInteger[][] bigIntSpiralMatrix;
    private int[][] coordinates;
    private int[][] secondMatrixCoordinates;

    public DayThree(int n) {
        if (n % 2 == 0) {
            throw new UnsupportedOperationException("This class doesn't support even matrices");
        }
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

    public int getShortestPath(int input) {
        int[] coordinate = null;

        coordinate = locateCoordinate(input);

        if (coordinate == null) {
            throw new NullPointerException("Value " + input + " doesn't exist in this array");
        }

        // determine starting coordinate for matrix
        int x = (int) (Math.floor(spiralMatrix.length / 2.0));
        int y = (int) (Math.floor(spiralMatrix.length / 2.0));

        // calculate sum of the absolute values of the horizontal and vertical distance
        return Math.abs(coordinate[0] - x) + Math.abs(coordinate[1]-y);
    }

    // not very OO, but refactoring can come later...
    private int[] locateCoordinateBI(int value) throws NullPointerException {
        int[] result = null;

        for (int i = 0; i < bigIntSpiralMatrix.length; i++) {
            for (int j = 0; j < bigIntSpiralMatrix.length; j++) {

                BigInteger bigInteger = BigInteger.valueOf(value);
                int a = 0;
                if (bigIntSpiralMatrix[i][j].equals(BigInteger.valueOf(value))) {
                    return new int[] {i, j};
                }
            }
        }
        return result;
    }

    private int[] locateCoordinate(int value) throws NullPointerException {
        int[] result = null;

        for (int i = 0; i < spiralMatrix.length; i++) {
            for (int j = 0; j < spiralMatrix.length; j++) {

                if (spiralMatrix[i][j] == value) {
                    return new int[] {i, j};
                }
            }
        }
        return result;
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

    private BigInteger[][] clearGrid(int n) {
        spiralMatrix = new int[n][n];

        bigIntSpiralMatrix = new BigInteger[n][n];

        for (int i = 0; i < bigIntSpiralMatrix.length; i++) {
            for (int j = 0; j < bigIntSpiralMatrix[i].length; j++) {

                bigIntSpiralMatrix[i][j] = BigInteger.valueOf(spiralMatrix[i][j]);

            }
        }

        System.out.println("Grid cleared...");
        return bigIntSpiralMatrix;

    }

    public BigInteger getFirstValueLarger(int input) {
        BigInteger[][] longs = clearGrid(spiralMatrix.length);

        bigIntSpiralMatrix = initSecondMatrix(longs);

        int[] coordinate = locateCoordinateBI(input);

        int[] nextCoordinate = null;
        BigInteger result = BigInteger.valueOf(0l);
        for (int i = 0; i < secondMatrixCoordinates.length; i++) {

            if (Arrays.equals(coordinate, secondMatrixCoordinates[i])) {
                nextCoordinate = secondMatrixCoordinates[i+1];
                result = bigIntSpiralMatrix[nextCoordinate[0]][nextCoordinate[1]];
                break;
            }

        }

        return result;
    }

    private BigInteger[][] initSecondMatrix(BigInteger[][] spiralMatrix) {

        int x = 0; // current position; x
        int y = 0; // current position; y
        int[] direction = {1,0}; // direction is to the right
        BigInteger value = BigInteger.valueOf(1); // current value being inserted
        int nextValue = 1;

        // determine starting coordinate for matrix
        x = (int) (Math.floor(spiralMatrix.length / 2.0));
        y = (int) (Math.floor(spiralMatrix.length / 2.0));

        // array for storing next coordinate
        int[] nextCoordinate;
        // array for storing sequential coordinates with initial size of matrix.length to the power 2
        secondMatrixCoordinates = new int[(int) Math.pow(spiralMatrix.length, 2.0)][];
        // counter for coordinate to be added
        int counter = 0;
        // initial amount of movements before rotating the matrix
        int steps = 1;

        // loop over each coordinate
        outer:
        for (int row = 0; row < spiralMatrix.length; row++) {

            for (int column = 0; column < spiralMatrix.length; column++) {

                // repeat number of steps and rotation twice
                for (int repetition = 0; repetition < 2; repetition++) {

                    // for the odd matrix needs only one row added, not a new column
                    if (column == spiralMatrix.length - 1 && repetition == 1) {
                        break outer;
                    }

                    // loop over number of steps remaining
                    for (int k = 0; k < steps; k++) {

                        // write current value to matrix
                        spiralMatrix[x][y] = value;
                        System.out.println("coordinate (" + x + "," + y + ") is filled with " + value);

                        // save current coordinate to array for later reference
                        secondMatrixCoordinates[counter] = new int[] {x, y};

                        // increase counter
                        counter++;

                        // move to next position
                        nextCoordinate = moveCoordinate(direction, x, y);
                        x = nextCoordinate[0];
                        y = nextCoordinate[1];

                        // calculate next value;
                        value = (sumOfAdjacentSquares(bigIntSpiralMatrix, nextCoordinate));
                    }

                    // rotate matrix after steps have completed
                    direction = rotateCCW(direction);
                }
                steps++;
            }
        }

        System.out.println("wrote " + counter + " values to second matrix");
        return spiralMatrix;
    }

    private BigInteger sumOfAdjacentSquares(BigInteger[][] matrix, int[] coordinate) {
        BigInteger up = (getCoordinateValue(matrix, coordinate[0], coordinate[1]-1));
        BigInteger upRight = (getCoordinateValue(matrix, coordinate[0]+1, coordinate[1]-1));
        BigInteger right = (getCoordinateValue(matrix, coordinate[0]+1, coordinate[1]));
        BigInteger downRight = (getCoordinateValue(matrix, coordinate[0]+1, coordinate[1]+1));
        BigInteger down = (getCoordinateValue(matrix, coordinate[0], coordinate[1]+1));
        BigInteger downLeft = (getCoordinateValue(matrix, coordinate[0] - 1, coordinate[1] + 1));
        BigInteger left = (getCoordinateValue(matrix, coordinate[0]-1, coordinate[1]));
        BigInteger upLeft = (getCoordinateValue(matrix, coordinate[0]- 1, coordinate[1] - 1));

        BigInteger sum = BigInteger.valueOf(0l);

        sum = up.add(upRight)
                .add(right)
                .add(downRight)
                .add(down)
                .add(downLeft)
                .add(left)
                .add(upLeft);

        //        up + upRight + right + downRight + down + downLeft + left + upLeft

        return (sum.equals(0l)) ? BigInteger.valueOf(1l) : sum;
    }

    private BigInteger getCoordinateValue(BigInteger[][] matrix, int x, int y) {
        try {
            // if we want to retrieve a coordinate which doesn't exist we assume it's value is 0
            return matrix[x][y];
        } catch (IndexOutOfBoundsException e){
            return BigInteger.valueOf(0);
        }

    }
}
