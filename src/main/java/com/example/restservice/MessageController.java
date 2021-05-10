package com.example.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private static final int encryptionKey = 5;

    /**
     * Endpoint for receiving post request to encrypt messages
     * 
     * @param textArrayRequest arrays of text separated by ","
     * @return array of encrypted messages separated by ","
     */
    @PostMapping("/encrypt")
    public EncryptedMessage encrypt(@RequestParam(value = "text", defaultValue = "") String textArrayRequest) {
        // split incoming request
        String[] textArray = textArrayRequest.split(",");
        // get size
        return new EncryptedMessage(textArray, encryptionKey);
    }

    /**
     * Endpoint for receiving post request to decrypt messages
     * 
     * @param textArrayRequest arrays of text separated by ","
     * @return array of decrypted messages separated by ","
     */
    @PostMapping("/decrypt")
    public DecryptedMessage decrypt(@RequestParam(value = "text", defaultValue = "") String textArrayRequest) {
        // split incoming request
        String[] textArray = textArrayRequest.split(",");
        // get size
        return new DecryptedMessage(textArray, encryptionKey);
    }
}
