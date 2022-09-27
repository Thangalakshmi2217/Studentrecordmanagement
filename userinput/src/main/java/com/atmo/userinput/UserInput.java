package com.atmo.userinput;

import java.util.Scanner;

/**
 * <p>
 * Gets the input from the users.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class UserInput {

    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * <p>
     * Display the input's specifics.
     * </p>
     *
     * @param text represents the user's input.
     */
    public static String getString(final String text) {
        System.out.println(text);
        return SCANNER.next().trim();
    }
}
