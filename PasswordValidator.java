public class PasswordValidator {

    public static boolean validate(String password, PasswordConfig config) {
        if (password.length() < config.getLength()) {
            return false;
        }

        if (config.isUseUpperCase() && !password.matches(".*[A-Z].*")) {
            return false;
        }

        if (config.isUseNumber() && !password.matches(".*[0-9].*")) {
            return false;
        }

        if (config.isUseSpecialCaracter() && !password.matches(".*[!@#$%^&*()\\-_=+<>?].*")) {
            return false;
        }

        return true;
    }
}
