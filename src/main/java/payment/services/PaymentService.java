package payment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payment.dto.PaymentRequestDTO;
import payment.dto.PaymentResponseDTO;
import payment.exeption.PaymentNotFoundException;
import payment.models.Payment;
import payment.repositories.PaymentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment(paymentRequestDTO.getPayer(),
                paymentRequestDTO.getPayee(),
                paymentRequestDTO.getAmount());
        Payment savedPayment = paymentRepository.save(payment);
        return new PaymentResponseDTO(savedPayment.getId(),
                savedPayment.getPayer(),
                savedPayment.getPayee(),
                savedPayment.getAmount(),
                savedPayment.getTimestamp());
    }

    public List<PaymentResponseDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(payment -> new PaymentResponseDTO(payment.getId(),
                        payment.getPayer(),
                        payment.getPayee(),
                        payment.getAmount(),
                        payment.getTimestamp()))
                .collect(Collectors.toList());
    }

    public PaymentResponseDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
        return new PaymentResponseDTO(payment.getId(),
                payment.getPayer(),
                payment.getPayee(),
                payment.getAmount(),
                payment.getTimestamp());
    }
}
