package sparkchain;

import utils.StringUtil;

import java.security.*;
import java.util.ArrayList;

public class Transaction {

    public String transactionId; //this is also the hash of the transaction
    public PublicKey sender; // the public key/address of the sender
    public PublicKey receiver; // the public key/address of the receiver
    public float value; // the amount of coin in the transaction
    public byte[] signature; // this is to prevent anyone else spending funds in our wallet

    public ArrayList<TransactionInput> inputs;
    public ArrayList<TransactionOutput> ouputs = new ArrayList<>();

    private static int sequence = 0; // this is the rough count of how many transactions have been generated

    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.receiver = to;
        this.value = value;
        this.inputs = inputs;
    }

    private String calculateHash() {
        sequence++; //increment the sequense to avoid 2 transactions having the same hash

        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(receiver) +
                        Float.toString(value) + sequence
        );
    }

    //Signs all the data we dont wish to be tampered with.
    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(receiver) + Float.toString(value)	;
        signature = StringUtil.applyECDSASig(privateKey,data);
    }
    //Verifies the data we signed hasnt been tampered with
    public boolean verifiySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(receiver) + Float.toString(value)	;
        return StringUtil.verifyECDSASig(sender, data, signature);
    }
}
