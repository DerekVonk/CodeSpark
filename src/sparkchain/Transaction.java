package sparkchain;

import utils.StringUtil;

import java.security.*;
import java.util.ArrayList;

public class Transaction {

    private String transactionId; //this is also the hash of the transaction
    public PublicKey sender; // the public key/address of the sender
    public PublicKey receiver; // the public key/address of the receiver
    public float value; // the amount of coin in the transaction
    public byte[] signature; // this is to prevent anyone else spending funds in our wallet

    public ArrayList<TransactionInput> inputs;
    public ArrayList<TransactionOutput> outputs = new ArrayList<>();

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

    //Returns true if new transaction could be created.	
    public boolean processTransaction() {

        if(!verifiySignature()) {
            System.out.println("#Transaction Signature failed to verify");
            return false;
        }

        //gather transaction inputs (Make sure they are unspent):
        for(TransactionInput i : inputs) {
            i.UTXO = SparkChain.UTXOs.get(i.transactionOutputId);
        }

        //check if transaction is valid:
        if(getInputsValue() < SparkChain.minimumTransaction) {
            System.out.println("#Transaction Inputs to small: " + getInputsValue());
            return false;
        }

        //generate transaction outputs:
        float leftOver = getInputsValue() - value; //get value of inputs then the left over change:
        transactionId = calculateHash();
        outputs.add(new TransactionOutput( this.receiver, value,transactionId)); //send value to recipient
        outputs.add(new TransactionOutput( this.sender, leftOver,transactionId)); //send the left over 'change' back to sender		

        //add outputs to Unspent list
        for(TransactionOutput o : outputs) {
            SparkChain.UTXOs.put(o.id , o);
        }

        //remove transaction inputs from UTXO lists as spent:
        for(TransactionInput i : inputs) {
            if(i.UTXO == null) continue; //if Transaction can't be found skip it 
            SparkChain.UTXOs.remove(i.UTXO.id);
        }

        return true;
    }

    //returns sum of inputs(UTXOs) values
    public float getInputsValue() {
        float total = 0;
        for(TransactionInput i : inputs) {
            if(i.UTXO == null) continue; //if Transaction can't be found skip it 
            total += i.UTXO.value;
        }
        return total;
    }

    //returns sum of outputs:
    public float getOutputsValue() {
        float total = 0;
        for(TransactionOutput o : outputs) {
            total += o.value;
        }
        return total;
    }
}
