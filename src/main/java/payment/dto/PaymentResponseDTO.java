package payment.dto;

import java.time.LocalDateTime;

public class PaymentResponseDTO {

    private Long id;
    private String payer;
    private String payee;
    private Double amount;
    private LocalDateTime timestamp;

    // Конструктор и Getters
    public PaymentResponseDTO(Long id, String payer, String payee, Double amount, LocalDateTime timestamp) {
        this.id = id;
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getPayer() {
        return payer;
    }

    public String getPayee() {
        return payee;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
