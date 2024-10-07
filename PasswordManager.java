public class PasswordManager {

    // Esta instancia permitirá verificar si una contraseña ha sido reutilizada
    private PasswordHistory passwordHistory;

    // Constructor para inicializar el historial de contraseñas
    public PasswordManager() {
        this.passwordHistory = new PasswordHistory();
    }

    // Método para generar una nueva contraseña basada en PasswordConfig
    public String createPassword(PasswordConfig config) throws IllegalArgumentException {
        // Primero validamos que la configuración sea válida (ejemplo: longitud mínima)
        config.validate();

        // Generamos la contraseña usando la configuración
        String password = PasswordGenerator.generate(config);

        // Verificamos si la contraseña ya ha sido usada antes
        if (passwordHistory.isPasswordReused(password)) {
            throw new IllegalArgumentException("La contraseña ya ha sido utilizada previamente.");
        }

        // Agregamos la contraseña al historial para evitar futuras reutilizaciones
        passwordHistory.addPassword(password);

        // Retornamos la nueva contraseña generada
        return password;
    }

    // Método para validar una contraseña dada con base en la configuración
    public boolean isValidPassword(String password, PasswordConfig config) {
        return PasswordValidator.validate(password, config);
    }

    // Método para verificar la fuerza de una contraseña
    public PasswordStrengthChecker.Strength checkPasswordStrength(String password) {
        return PasswordStrengthChecker.checkStrength(password);
    }

}
