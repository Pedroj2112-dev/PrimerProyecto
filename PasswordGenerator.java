import java.util.Random;

public class PasswordGenerator {

    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static String generate(PasswordConfig config) {
        StringBuilder password = new StringBuilder(config.getLength());
        String characterPool = LOWER_CASE;

        if (config.isUseUpperCase()) {
            characterPool += UPPER_CASE;
        }
        if (config.isUseNumber()) {
            characterPool += NUMBERS;
        }
        if (config.isUseSpecialCaracter()) {
            characterPool += SPECIAL_CHARACTERS;
        }

        Random random = new Random();
        for (int i = 0; i < config.getLength(); i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
