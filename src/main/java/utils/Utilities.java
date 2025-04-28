package utils;

import java.util.Random;

public class Utilities {
    private Utilities(){}
    private static final Random RANDOM = new Random();


    public static String generateRandomNumber(int length) {

        StringBuilder sb = new StringBuilder(length);
        sb.append(RANDOM.nextInt(9) + 1);
        for (int i = 1; i < length; i++) {
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }

}
