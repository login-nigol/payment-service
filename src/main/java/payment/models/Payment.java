package payment.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private String payer;

    @Getter
    @Column(nullable = false)
    private String payee;

    @Getter
    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Payment() {}

    public Payment(String payer, String payee, Double amount) {
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Getters и Setters
}
