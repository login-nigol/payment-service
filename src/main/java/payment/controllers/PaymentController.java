package payment.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import payment.dto.PaymentRequestDTO;
import payment.dto.PaymentResponseDTO;
import payment.services.PaymentService;


import java.util.List;

@RestController
@RequestMapping("/payments")
@Validated
@Tag(name = "Payment API", description = "API для управления платежами")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Operation(summary = "Создать новый платеж")
    @PostMapping
    public PaymentResponseDTO createPayment(@Valid @RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentService.createPayment(paymentRequestDTO);
    }

    @Operation(summary = "Получить список всех платежей")
    @GetMapping
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @Operation(summary = "Получить платеж по ID")
    @GetMapping("/{id}")
    public PaymentResponseDTO getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }
}
