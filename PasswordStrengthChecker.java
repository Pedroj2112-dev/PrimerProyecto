public class PasswordStrengthChecker {

    public enum Strength {
        WEAK, MEDIUM, STRONG
    }

    public static Strength checkStrength(String password) {
        int strengthPoints = 0;

        if (password.length() >= 8) {
            strengthPoints++;
        }
        if (password.matches(".*[A-Z].*")) {
            strengthPoints++;
        }
        if (password.matches(".*[0-9].*")) {
            strengthPoints++;
        }
        if (password.matches(".*[!@#$%^&*()\\-_=+<>?].*")) {
            strengthPoints++;
        }

        switch (strengthPoints) {
            case 4:
                return Strength.STRONG;
            case 3:
                return Strength.MEDIUM;
            default:
                return Strength.WEAK;
        }
    }
}
