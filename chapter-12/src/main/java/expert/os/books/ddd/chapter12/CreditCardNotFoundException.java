package expert.os.books.ddd.chapter12;

public class CreditCardNotFoundException extends CreditCardException {
    public CreditCardNotFoundException(String message) {
        super(message);
    }

    public CreditCardNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
