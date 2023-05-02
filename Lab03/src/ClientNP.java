import java.util.*;

public class ClientNP extends Client {
    private final String cpf;
    private String gender;
    private String education;
    private String economicalClass;

    private Date birthDate;
    private Date licenseDate;

    // Constructor of the class
    public ClientNP(String name, String address, String cpf, String gender,
    String education, String economicalClass, Date birthDate, Date licenseDate) {

        // Call the Client constructor function
        super(name, address);

        this.cpf = cpf;
        this.gender = gender;
        this.education = education;
        this.economicalClass = economicalClass;

        this.birthDate = birthDate;
        this.licenseDate = licenseDate;
    }

    // CPF getter
    public String getCPF() {
        return this.cpf;
    }

    // Gender getter
    public String getGender() {
        return this.gender;
    }

    // Gender setter
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Education getter
    public String getEducation() {
        return this.education;
    }

    // Education setter
    public void setEducation(String education) {
        this.education = education;
    }

    // Economical class getter
    public String getEconomicalClass() {
        return this.economicalClass;
    }

    // Economical class setter
    public void setEconomicalClass(String economicalClass) {
        this.economicalClass = economicalClass;
    }

    // Birth date getter
    public Date getBirthDate() {
        return this.birthDate;
    }

    // Birth date setter
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // License date getter
    public Date getLicenseDate() {
        return this.licenseDate;
    }

    // License date setter
    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    // Validate the CPF using https://ogeradordecpf.com.br/algoritmo/
    public boolean validateCPF() {
        String cpf = this.cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        boolean equal = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(i-1)) {
                equal = false;
                break;
            }
        }

        if (equal) {
            return false;
        }

        int[] digits = new int[11];

        for (int i = 0; i < 11; i++) {
            digits[i] = Character.getNumericValue(cpf.charAt(i));
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

        // Check with the CPF 10th digit
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

        // Check with the CPF 11th digit
        if (ndValidationDigit != digits[10]) {
            return false;
        }

        return true;
    }

    // Represent the Natural Person Client object as a string
    @Override
    public String toString(int tab) {
        String space = "│  ".repeat(tab);

        return String.format(
            "Client Natural Person\n%s├─ Name: %s\n%s├─ CPF: %s\n%s├─ Address: %s\n%s├─ Gender: %s\n%s├─ Education: %s\n%s├─ Economical class: %s\n%s├─ Birth date: %s\n%s└─ License date: %s",
            space, this.getName(), space, this.cpf, space, this.getAddress(), space, this.gender, space,
            this.education, space, this.economicalClass, space, this.birthDate, space, this.licenseDate
        );
    }
}
