import java.util.LinkedList;

public class PasswordHistory {

    private LinkedList<String> passwordHistory;

    public PasswordHistory() {
        passwordHistory = new LinkedList<>();
    }

    public void addPassword(String password) {
        if (passwordHistory.size() >= 5) {
            passwordHistory.removeFirst(); // Mantener un historial de 5 contraseñas
        }
        passwordHistory.add(password);
    }

    public boolean isPasswordReused(String password) {
        return passwordHistory.contains(password);
    }
}

