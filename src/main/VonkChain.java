package main;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class VonkChain {

    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {

        blockchain.add(new Block("this is the GENESIS block", "0"));
        blockchain.add(new Block("adding some more data", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("this is going marvelously", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("on block number 4 now!", blockchain.get(blockchain.size()-1).hash));

        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockChainJson);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        // loop through the blockchain to check hashes:
        for (int i = 0; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            // compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash()) ) {
                System.out.println("Current hashes not equal");
                return false;
            }

            // compare previous hash and registered previous hash:
            if (!previousBlock.hash.equals(previousBlock.calculateHash()) ) {
                System.out.println("Previous hashes not equal");
                return false;
            }
        }

        return true;
    }
}
