package main;


import java.util.ArrayList;
import java.util.Arrays;

public class DaySix {

    int[] memory;
    private ArrayList<int[]> memoryLog;
    private int loopCycles;

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

    /**
     * getter fo size of the loop: starting from a state that has already been seen, how many block redistribution cycles
     * have been performed before that same state is seen again?
     *
     * @return int number of cycles
     */
    public int getLoopCycles() {
        return loopCycles;
    }

    private void calculateCycles() {
        int blocks;
        int index;
        do {
            // log memory state to memoryLog
            memoryLog.add(Arrays.copyOf(memory, memory.length));

            // retrieve number of blocks from memory bank
            blocks = getNumberOfBlocksFromLargestBank(memory);

            // retrieve index number which holds the largest number of blocks
            index = getLargestMemoryBlock(blocks);

            // set memory index that holds the most blocks back to zero for redistribution
            memory[index] = 0;

            // distribute blocks over the other memory banks till all blocks run out
            distributeBlocks(blocks, index);

            // if memory state already existed, exit the infinite loop
            if (memoryStateExists(memory)) {
                break;
            }

        } while (true);
    }

    private boolean memoryStateExists(int[] currentMemoryState) {
        for (int i = 0; i < memoryLog.size(); i++) {
            if (Arrays.equals(memoryLog.get(i), currentMemoryState)) {

                loopCycles = memoryLog.size() - i;

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
