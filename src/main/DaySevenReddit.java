package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DaySevenReddit {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("test/day7input.txt"));
            String line = "";
            ArrayList<String> lines = new ArrayList<>();
            ArrayList<Disc> discs = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                lines.add(line);
                String name = line.substring(0, line.indexOf(" "));
                String weight = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
                Disc disc = new Disc();
                disc.setName(name);
                disc.setWeight(new Integer(weight));
                discs.add(disc);
            }
            br.close();
            for (String s : lines) {
                if (s.contains("->")) {
                    String name = s.substring(0, s.indexOf(" "));
                    Disc parent = null;
                    for (int i = 0; i < discs.size(); i++) {
                        if (discs.get(i).getName().equals(name)) {
                            parent = discs.get(i);
                        }
                    }
                    String supportingDiscs = s.substring(s.indexOf("->") + 3);
                    String[] supportingDiscsArray = supportingDiscs.split(", ");
                    ArrayList<Disc> children = new ArrayList<>();
                    for (String supportingDisc : supportingDiscsArray) {
                        for (int i = 0; i < discs.size(); i++) {
                            if (discs.get(i).getName().equals(supportingDisc)) {
                                Disc child = discs.get(i);
                                children.add(child);
                            }
                        }
                    }
                    parent.setChildren(children);
                }
            }
            ArrayList<Disc> mismatchedWeight = new ArrayList<>();
            for (Disc disc : discs) {
                if (disc.getChildren() != null) {
                    ArrayList<Disc> children = disc.getChildren();
                    int weight = children.get(0).totalWeight();
                    for (int i = 1; i < children.size(); i++) {
                        int newweight = children.get(i).totalWeight();
                        if (newweight != weight) {
                            mismatchedWeight.add(disc);
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < mismatchedWeight.size(); i++) {
                Boolean hasChildren = false;
                for (int j = 0; j < mismatchedWeight.size(); j++) {
                    if (i != j) {
                        if (mismatchedWeight.get(i).hasChild(mismatchedWeight.get(j))) {
                            hasChildren = true;
                        }
                    }
                }
                if (hasChildren == false) {
                    Disc offBalance = mismatchedWeight.get(i);
                    for (Disc disc : offBalance.getChildren()) {
                        System.out.println(disc.totalWeight() + ": " + disc);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }

    private static class Disc {
        private String name = "";
        private int weight = 0;
        private ArrayList<Disc> children;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name
         *            the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the weight
         */
        public int getWeight() {
            return weight;
        }

        /**
         * @param weight
         *            the weight to set
         */
        public void setWeight(int weight) {
            this.weight = weight;
        }

        /**
         * @return the children
         */
        public ArrayList<Disc> getChildren() {
            return children;
        }

        /**
         * @param children
         *            the children to set
         */
        public void setChildren(ArrayList<Disc> children) {
            this.children = children;
        }

        public int totalWeight() {
            int weight = this.getWeight();
            if (this.getChildren() != null) {
                for (Disc child : this.getChildren()) {
                    weight += child.totalWeight();
                }
            }
            return weight;
        }

        public Boolean hasChild(Disc disc) {
            Boolean hasChild = false;
            if (this.getChildren() != null) {
                for (Disc child : this.getChildren()) {
                    if (disc.getName().equals(child.getName())) {
                        hasChild = true;
                    }
                }
            }
            return hasChild;
        }

        @Override
        public String toString() {
            String returnString = Integer.toString(this.getWeight());
            if (this.getChildren() != null) {
                for (Disc child : this.getChildren()) {
                    returnString += " + ";
                    returnString += child.toString();
                }
            }
            return returnString;
        }

    }
}
