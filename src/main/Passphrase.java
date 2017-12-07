package main;

public class Passphrase {

    public String passphrase;
    public String[] words;

    public Passphrase(String input) {
        passphrase = input;
        words = input.split(" ");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            sb.append(" ");
            if (i == words.length -1) {
                break;
            }
        }
        return sb.toString();
    }
}
