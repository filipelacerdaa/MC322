public class Client {
    private String name;
    private String securityNum;
    private String birthDate;
    private String address;
    private int age;

    // Constructor of the class
    public Client(String name, String securityNum, String birthDate, String address, int age) {
        this.name = name;
        this.securityNum = securityNum;
        this.birthDate = birthDate;
        this.address = address;
        this.age = age;
    }

    // Name getter
    public String getName() {
        return this.name;
    }

    // Name setter
    public void setName(String name) {
        this.name = name;
    }

    // Security number getter
    public String getSecurityNum() {
        return this.securityNum;
    }

    // Security number setter
    public void setSecurityNum(String securityNum) {
        this.securityNum = securityNum;
    }

    // Birth date getter
    public String getBirthDate() {
        return this.birthDate;
    }

    // Birth date setter
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    // Address getter
    public String getAddress() {
        return this.address;
    }

    // Address setter
    public void setAddress(String address) {
        this.address = address;
    }

    // Age getter
    public int getAge() {
        return this.age;
    }

    // Age setter
    public void setAge(int age) {
        this.age = age;
    }

    // Validate the security number using https://ogeradordecpf.com.br/algoritmo/
    public boolean validateSecurityNum() {
        String securityNum = this.securityNum.replaceAll("[^0-9]", "");

        if (securityNum.length() != 11) {
            return false;
        }

        boolean equal = true;
        for (int i = 1; i < 11; i++) {
            if (securityNum.charAt(i) != securityNum.charAt(i-1)) {
                equal = false;
                break;
            }
        }

        if (equal) {
            return false;
        }

        int[] digits = new int[11];

        for (int i = 0; i < 11; i++) {
            digits[i] = Character.getNumericValue(securityNum.charAt(i));
        }

        // First validation digit
        int stValidationDigit = (
            digits[0] * 10 + digits[1] * 9 + digits[2] * 8 +
            digits[3] * 7  + digits[4] * 6 + digits[5] * 5 +
            digits[6] * 4  + digits[7] * 3 + digits[8] * 2
        );

        stValidationDigit = (10 * stValidationDigit) % 11;

        if (stValidationDigit == 10) {
            stValidationDigit = 0;
        }

        // Check with the security number 10th digit
        if (stValidationDigit != digits[9]) {
            return false;
        }

        // Second validation digit
        int ndValidationDigit = (
            digits[0] * 11 + digits[1] * 10 + digits[2] * 9 + digits[3] * 8 + digits[4] * 7 +
            digits[5] * 6  + digits[6] * 5  + digits[7] * 4 + digits[8] * 3 + digits[9] * 2
        );

        ndValidationDigit = (10 * ndValidationDigit) % 11;

        if (ndValidationDigit == 10) {
            ndValidationDigit = 0;
        }

        // Check with the security number 11th digit
        if (ndValidationDigit != digits[10]) {
            return false;
        }

        return true;
    }
}
