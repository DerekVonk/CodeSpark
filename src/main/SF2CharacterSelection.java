package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SF2CharacterSelection {

    private static final Map<String, int[]> select = new HashMap();

    static {
        select.put("up", new int[] {0, -1});
        select.put("down", new int[] {0, 1});
        select.put("right", new int[] {1, 0});
        select.put("left", new int[] {-1, 0});
    }

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves){
        ArrayList<String> selectionHistory = new ArrayList<>();

        for (String move : moves) {
            int[] selection = select.get(move);

            try {

                if (move.equalsIgnoreCase("LEFT") | move.equalsIgnoreCase("RIGHT")) {



                }
                selectionHistory.add(fighters[position[0] + selection[0]][position[1] + selection[1]]);
                position[0] += selection[0];
                position[1] += selection[1];

            } catch (ArrayIndexOutOfBoundsException e) {
                selectionHistory.add(fighters[position[0]][position[1]]);
            }

        }

        return (String[]) selectionHistory.toArray();

    }
}
