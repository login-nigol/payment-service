package payment.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class PaymentRequestDTO {

    @Getter
    @NotBlank(message = "Плательщик обязателен")
    private String payer;

    @Getter
    @NotBlank(message = "Получатель платежа обязателен")
    private String payee;

    @NotNull(message = "Сумма обязательна")
    @Min(value = 1, message = "Сумма должна быть больше 0")
    private Double amount;

    public PaymentRequestDTO(String payer, String payee, Double amount) {
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    // Getters и Setters
}
