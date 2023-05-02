import java.util.*;

public class ClientLP extends Client {
    private final String cnpj;
    private Date foundationDate;

    // Constructor of the class
    public ClientLP(String name, String address, String cnpj, Date foundationDate) {

        // Call the Client constructor function
        super(name, address);

        this.cnpj = cnpj;
        this.foundationDate = foundationDate;
    }

    // CNPJ getter
    public String getCNPJ() {
        return this.cnpj;
    }

    // Foundation date getter
    public Date getFoundationDate() {
        return this.foundationDate;
    }

    // Foundation date setter
    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    // Validate the CNPJ using https://www.macoratti.net/alg_cnpj.htm
    public boolean validateCNPJ() {
        String cnpj = this.cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        }

        boolean equal = true;
        for (int i = 1; i < 14; i++) {
            if (cnpj.charAt(i) != cnpj.charAt(i-1)) {
                equal = false;
                break;
            }
        }

        if (equal) {
            return false;
        }

        int[] digits = new int[14];

        for (int i = 0; i < 14; i++) {
            digits[i] = Character.getNumericValue(cnpj.charAt(i));
        }

        // First validation digit
        int stValidationDigit = (
            digits[0] * 5 + digits[ 1] * 4 + digits[ 2] * 3 +
            digits[3] * 2 + digits[ 4] * 9 + digits[ 5] * 8 +
            digits[6] * 7 + digits[ 7] * 6 + digits[ 8] * 5 + 
            digits[9] * 4 + digits[10] * 3 + digits[11] * 2
        );

        stValidationDigit = stValidationDigit % 11;

        if (stValidationDigit < 2) {
            stValidationDigit = 0;
        } else {
            stValidationDigit = 11 - stValidationDigit;
        }

        // Check with the CNPJ 13th digit
        if (stValidationDigit != digits[12]) {
            return false;
        }

        // Second validation digit
        int ndValidationDigit = (
            digits[0] * 6 + digits[ 1] * 5 + digits[ 2] * 4 +
            digits[3] * 3 + digits[ 4] * 2 + digits[ 5] * 9 +
            digits[6] * 8 + digits[ 7] * 7 + digits[ 8] * 6 + 
            digits[9] * 5 + digits[10] * 4 + digits[11] * 3 + digits[12] * 2
        );

        ndValidationDigit = ndValidationDigit % 11;

        if (ndValidationDigit < 2) {
            ndValidationDigit = 0;
        } else {
            ndValidationDigit = 11 - ndValidationDigit;
        }

        // Check with the CNPJ 14th digit
        if (ndValidationDigit != digits[13]) {
            return false;
        }

        return true;
    }

    // Represent the Legal Person Client object as a string
    @Override
    public String toString(int tab) {
        String space = "│  ".repeat(tab);

        return String.format(
            "Client Legal Person\n%s├─ Name: %s\n%s├─ CNPJ: %s\n%s├─ Address: %s\n%s└─ Foundation date: %s",
            space, this.getName(), space, this.cnpj, space, this.getAddress(), space, this.foundationDate
        );
    }
}
