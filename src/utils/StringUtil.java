package utils;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class StringUtil {

    private StringUtil() {}

    //applies Sha256 to a String and returns the result
    public static String applySha256(String input) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            //Applies sha256 to our input
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(); // this will contain hash as hexidecimal
            for (byte aHash : hash) {
                String hex = Integer.toHexString(0xff & aHash);

                if (hex.length() == 1) hexString.append('0');

                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            //@TODO define and throw dedicated Exception
            throw new RuntimeException(e);
        }
    }

    //Applies ECDSA Signature and returns the result ( as bytes ).
    // ECDSA = Elliptical Curve Digital Signature Algorithm
    // BC = Bouncy Castle is the provider?
    public static byte[] applyECDSASig(PrivateKey privateKey, String input) {
        Signature dsa;
        byte[] output = new byte[0];
        try {
            dsa = Signature.getInstance("ECDSA", "BC");
            dsa.initSign(privateKey);
            byte[] strByte = input.getBytes();
            dsa.update(strByte);
            byte[] realSig = dsa.sign();
            output = realSig;
        } catch (Exception e) {
            //@TODO define and throw dedicated Exception
            throw new RuntimeException(e);
        }
        return output;
    }

    //Verifies a String signature
    public static boolean verifyECDSASig(PublicKey publicKey, String data, byte[] signature) {
        try {
            Signature ecdsaVerify = Signature.getInstance("ECDSA", "BC");
            ecdsaVerify.initVerify(publicKey);
            ecdsaVerify.update(data.getBytes());
            return ecdsaVerify.verify(signature);
        }catch(Exception e) {
            //@TODO define and throw dedicated Exception
            throw new RuntimeException(e);
        }
    }

    public static String getStringFromKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}
