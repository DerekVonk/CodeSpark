package main;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;

public class SF2CharacterSelection {

    private final static int[] UP = {0, 1};
    private final static int[] DOWN = {0, -1};
    private final static int[] RIGHT = {1, 0};
    private final static int[] LEFT = {-1, 0};

    private static final int[][] select = new int[4][{},{},{},{}]

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves){
        ArrayList<String> selectionHistory = new ArrayList<>();

        try {
            for (String move : moves) {

            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        return (String[]) selectionHistory.toArray();

    }
}
