public class Mainn {
    public static void main(String[] args) {
        // Crear una configuración de contraseña (desde aquí configuras cómo quieres la contraseña)
        PasswordConfig config = new PasswordConfig(12, true, true, true);

        // Crear una instancia de PasswordManager para gestionar las contraseñas, Creamos la lista donde vamos a almacenar las contraseñas
        PasswordManager passwordManager = new PasswordManager();

        // Generar una nueva contraseña con la configuración especificada
        try {
            // Generar la contraseña utilizando PasswordManager
            String newPassword = passwordManager.createPassword(config);
            System.out.println("Nueva contraseña generada: " + newPassword);

            // Validar la contraseña generada
            boolean isValid = passwordManager.isValidPassword(newPassword, config);
            System.out.println("¿Es válida la contraseña? " + isValid);

            // Revisar la fuerza de la contraseña
            PasswordStrengthChecker.Strength strength = passwordManager.checkPasswordStrength(newPassword);
            System.out.println("Fuerza de la contraseña: " + strength);

        } catch (IllegalArgumentException e) {
            // Manejar errores si la configuración o contraseña no es válida
            System.out.println("Error: " + e.getMessage());
        }
    }
}
