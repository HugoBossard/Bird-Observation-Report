package com.mycorp.birdobs;

import com.password4j.Hash;
import com.password4j.Password;

public class PasswordHasher {
    public static String hashPassword(String plainPassword) {
        Hash hash = Password.hash(plainPassword)
            .addRandomSalt()
            .withArgon2();

        return hash.getResult();
    }

    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return Password.check(plainPassword, hashedPassword).withArgon2();
    }
}