package main;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // our data will be a simple message for now
    private long timestamp; // as a number of milliseconds since 1/1/1970

    // Constructor
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
    }


}
