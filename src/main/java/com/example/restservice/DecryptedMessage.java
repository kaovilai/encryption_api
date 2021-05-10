package com.example.restservice;

import java.util.Arrays;

public class DecryptedMessage {

    private final String[] textArray;

    /**
     * Decrypts a text given encryption key
     * 
     * @param textArray
     */
    public DecryptedMessage(String[] decryptedTextArray, int encryptionKey) {
        System.out.println("received" + Arrays.toString(decryptedTextArray));
        int length = decryptedTextArray.length;
        this.textArray = new String[length];
        for (int i = 0; i < decryptedTextArray.length; i++) {
            this.textArray[i] = decryptText(decryptedTextArray[i], encryptionKey);
        }
    }

    /**
     * "Decrypts" text using provided key
     * 
     * @param text Text to decrypt with key provided
     * @param key  key to use to decrypt text
     * @return decrypted text
     */
    private static String decryptText(String text, int key) {
        // This is encryptedText we are building with given text and key
        String decryptedText = "";
        // This string is used for concatenating to the encrypted text
        String concating = "";
        for (int i = 0; i < text.length(); i++) {
            concating = Character.toString((char) (Character.valueOf(text.charAt(i)) - key));
            decryptedText = decryptedText.concat(concating);
        }
        return decryptedText;
    }

    public String[] getTextArray() {
        return this.textArray;
    }
}
