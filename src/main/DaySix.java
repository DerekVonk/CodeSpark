package main;


import java.util.ArrayList;
import java.util.Arrays;

public class DaySix {

    int[] memory;
    private ArrayList<int[]> memoryLog;
    private int redistributionCycles = 0;

    public DaySix(int... banks) {
        initMemoryBank(banks);
        this.memoryLog = new ArrayList<>();
    }

    /**
     * Check method for day six
     *
     * @return number of cycles the memory bank has traversed before it's seen a configuration that has occurred before
     */
    public int getRedistributionCycles() {
        calculateCycles();
        return memoryLog.size();
    }

    private void calculateCycles() {
        // log memory state to memoryLog
        memoryLog.add(Arrays.copyOf(memory, memory.length));

        // retrieve number of blocks from memory bank
        int blocks = getNumberOfBlocksFromLargestBank(memory);

        // retrieve index number which holds the largest number of blocks
        int index = getLargestMemoryBlock(blocks);

        do {
            // set memory index that holds the most blocks back to zero for redistribution
            memory[index] = 0;

            // distribute blocks over the other memory banks till all blocks run out
            distributeBlocks(blocks, index);


            blocks = getNumberOfBlocksFromLargestBank(memory);

            index = getLargestMemoryBlock(blocks);

            if (memoryStateExists(memory)) {
                break;
            }

            // log latest state change to memory log
            memoryLog.add(memory);

        } while (true);

    }

    private boolean memoryStateExists(int[] memory) {
        for (int[] state : memoryLog) {
            if (Arrays.equals(memory, state)) {
                return true;
            }
        }
        return false;
    }

    private void distributeBlocks(int blocks, int index) {
        // distribute the blocks over the other memory banks
        for (int i = blocks; i > 0; i--) {

            if (index != memory.length - 1 && (index + 1) != memory.length - 1) {
                memory[index + 1]++;
                index++;
            } else if ((index + 1) == memory.length - 1) {
                memory[index + 1]++;
                index++;
            } else {
                index = 0;
                memory[index]++;
//                index++;
            }
        }
    }

    /**
     * Uses the integer as input to retrieve the index from an array where the value equals the input
     *
     * @param input integer value to search for in the array
     * @return the index of the array which holds the input
     */
    private int getLargestMemoryBlock(int input) {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == input) {
                return i;
            }
        }
        throw new UnsupportedOperationException("Should not get here... - this input is based on a value in this.memory");
    }

    /**
     * sorts an array of integers in ascending order and returns the value of the highest index
     *
     * @param array array of integers
     * @return integer from last index of sorted array
     */
    private int getNumberOfBlocksFromLargestBank(int[] array) {
        int[] ints = Arrays.copyOf(array, array.length);
        Arrays.sort(ints);
        return ints[ints.length - 1];
    }

    /**
     * Initialize number of blocks per bank in the memory array.
     *
     * @param banks varargs int array of number of blocks
     */
    private void initMemoryBank(int[] banks) {
        this.memory = new int[banks.length];

        for (int i = 0; i < banks.length; i++) {
            memory[i] = banks[i];
        }
    }

}
