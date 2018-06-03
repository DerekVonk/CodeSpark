package sparkchain;

import utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;

public class Block {

    private String hash;
    private String previousHash;
    private String merkleRoot;
    private ArrayList<Transaction> transactions = new ArrayList<>(); //our data will be a simple message.

//    public void setData(String data) {
//        this.data = data;
//    }

    private String data; // our data will be a simple message for now
    private long timestamp; // as a number of milliseconds since 1/1/1970

    private int nonce;

    // Constructor
    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    // calculate hash from all parts of the block we don't want tampered with
    public String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timestamp) +
                        Integer.toString(nonce) +
                        //data
                        merkleRoot
        );

        return calculatedHash;
    }

    public void mineBlock(int difficulty) {
        merkleRoot = StringUtil.getMerkleRoot(transactions);
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

    //Add transactions to this block
    public boolean addTransaction(Transaction transaction) {
        //process transaction and check if valid, unless block is genesis block then ignore.
        if(transaction == null) return false;
        if((previousHash != "0")) {
            if( !transaction.processTransaction() ) {
                System.out.println("Transaction failed to process. Discarded.");
                return false;
            }
        }
        transactions.add(transaction);
        System.out.println("Transaction Successfully added to Block");
        return true;
    }

}
