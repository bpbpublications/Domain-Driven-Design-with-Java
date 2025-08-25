package expert.os.books.ddd.chapter12;

public class CreditCardException extends MyCompanyException {
    public CreditCardException(String message) {
        super(message);
    }

    public CreditCardException(String message, Throwable cause) {
        super(message, cause);
    }
}