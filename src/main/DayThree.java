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
//        int dir = 0; // current direction; 0=RIGHT, 1=DOWN, 2=LEFT, 3=UP
        int c = 0; // counter
//        int s = 1;
        int value = 1; // current value being inserted
        int steps = 1;
        int movements = 1;

        // starting point
        x = (int) (Math.floor(matrix.length / 2.0));
        y = (int) (Math.floor(matrix.length / 2.0));

        int[] direction = new int[] {1, 0}; // initial direction is to the right

        int[][] movement = new int[(int) Math.pow(matrix.length, 2)][];

        for (int i = 0; i < matrix.length; i++) {

            for (int k = 0; k < 2; k++) {

                    do {
                        // write and increment value to current position
                        matrix[x][y] = value;
                        System.out.println("position ("+x+","+y+") filled with value: " + value);
                        value++;
                        // log

                        // store current position in movement
                        movement[c] = new int[] {x, y};
                        c++;
                        x += 1;
                        steps++;
                    } while (steps < movements);

                movements += 1;
                direction = rotateCCW(direction);
            }
        }


//        for (int i = 0; i < matrix.length; i++) {
//
//            for (int j = 2; j > 0; j--) {
//                // for odd matrices only. On last iteration, only one direction change is needed.
//                if (i == matrix.length -1 && j == 1) {
//                    break;
//                }
//
//                for (int k = 0; k < s; i++) {
//
//                    matrix[x][y] = value++;
//                    System.out.println("Matrix point (" + x + "," + y + ") ");
//                    c++;
//
//                }
//            }
//            s++;
//        }


//        for (int k = 0; k < matrix.length; k++) {
//
//            for (int j = 0; j < matrix.length; j++) {
//
//                for (int i = 0; i < s; i++) ; {
//
//                    matrix[x][y] = value++;
//                    System.out.println("Matrix point (" + x + "," + y + ") ");
//                    c++;
//
//                    switch (dir) {
//                        case RIGHT: x = x + 1; break;
//                        case DOWN: y = y + 1; break;
//                        case LEFT: x = x - 1; break;
//                        case UP: y = y - 1; break;
//                    }
//                }
//                dir = (dir + 1) % 4;
//            }
//            s++;
//        }
        System.out.println(c + " times");
        return matrix;
    }

    private int[] rotateCCW(int[] direction) {
        int temp = direction[1];
        direction[1] = direction[-0];
        direction[0] = temp;
        return direction;
    }

    public int getShortestPath(int square) {
        return 0;
    }

}
