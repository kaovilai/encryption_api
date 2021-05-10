package com.example.restservice;

import java.util.Arrays;

/**
 * EncryptedMessage
 */
public class EncryptedMessage {
    // This is the text array that contain encrypted messages
    private final String textArray[];

    /**
     * Encrypts this unencrypted array of strings
     * 
     * @param unencryptedTextArray Array of unencrypted texts to encrypt
     * @param encryptionKey        encryption key to use to encrypt text
     */
    public EncryptedMessage(String[] unencryptedTextArray, int encryptionKey) {
        // encrypts message
        System.out.println("received" + Arrays.toString(unencryptedTextArray));
        int length = unencryptedTextArray.length;
        this.textArray = new String[length];
        for (int i = 0; i < unencryptedTextArray.length; i++) {
            this.textArray[i] = encryptText(unencryptedTextArray[i], encryptionKey);
        }
    }

    /**
     * "Encrypts" text using provided key
     * 
     * @param text Text to encrypt with key provided
     * @param key  key to use to encrypt text
     * @return encrypted text
     */
    private static String encryptText(String text, int key) {
        // This is encryptedText we are building with given text and key
        String encryptedText = "";
        // This string is used for concatenating to the encrypted text
        String concating = "";
        for (int i = 0; i < text.length(); i++) {
            concating = Character.toString((char) (Character.valueOf(text.charAt(i)) + key));
            encryptedText = encryptedText.concat(concating);
        }
        return encryptedText;
    }

    public String[] getTextArray() {
        return this.textArray;
    }
}