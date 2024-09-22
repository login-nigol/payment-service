package payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import payment.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
