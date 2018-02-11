package sparkchain;

import utils.StringUtil;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;

    public void setData(String data) {
        this.data = data;
    }

    private String data; // our data will be a simple message for now
    private long timestamp; // as a number of milliseconds since 1/1/1970

    private int nonce;

    // Constructor
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    // calculate hash from all parts of the block we don't want tampered with
    public String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                previousHash + Long.toString(timestamp) + Integer.toString(nonce) + data
        );

        return calculatedHash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

}
