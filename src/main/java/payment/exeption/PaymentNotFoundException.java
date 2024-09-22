package payment.exeption;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(Long id) {
        super("Оплата с ID " + id + " не найдена1");
    }
}
