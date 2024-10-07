public class PasswordConfig{

    private int length;
    private boolean useUpperCase;
    private boolean useNumber;
    private boolean useSpecialCaracter;

    public PasswordConfig(int length, boolean useUpperCase, boolean useNumber,boolean useSpecialCaracter){

        this.length = length;
        this.useUpperCase = useUpperCase;
        this.useSpecialCaracter = useSpecialCaracter;
        this.useNumber = useNumber;
    }

    public int getLength() {
        return length;
    }

    public boolean isUseUpperCase() {
        return useUpperCase;
    }

    public boolean isUseNumber() {
        return useNumber;
    }

    public boolean isUseSpecialCaracter() {
        return useSpecialCaracter;
    }


    public void validate() throws IllegalArgumentException{
        if(length < 8){

            throw new IllegalArgumentException("La contraseña de tener al menos 8 caracteres");
        }
    }


}