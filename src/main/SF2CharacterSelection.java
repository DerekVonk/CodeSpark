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
                // allow for circular movements on rows
                if (move.equalsIgnoreCase("LEFT") && position[0] == 0) {
                    position[0] = fighters[0].length;

                } else if (move.equalsIgnoreCase("RIGHT") && position[0] == fighters[0].length - 1) {
                    position[0] = -1;

                }

                selectionHistory.add(fighters[position[1] + selection[1]][position[0] + selection[0]]);
                position[0] += selection[0];
                position[1] += selection[1];

            // only up or down movements should throw an AIOOBE
            } catch (ArrayIndexOutOfBoundsException e) {
                selectionHistory.add(fighters[position[0]][position[1]]);
            }

        }

        return selectionHistory.toArray(new String[0]);

    }
}
