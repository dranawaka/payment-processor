package com.aurelius.tech.paymentprocessor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessorImpl implements PaymentProcessor{


    private static final Logger log = LoggerFactory.getLogger(PaymentProcessorImpl.class);

    @KafkaListener(
            topics = "${topics.payment-requested:payments.topic}",
            groupId = "${spring.kafka.consumer.group-id:payment-processor-group}"
    )
    public void onMessage(com.aurelius.tech.paymentprocessor.model.PaymentRequest request) {
        log.info("Received PaymentRequest | paymentId={} | orderId={} | amount={} {} | correlationId={} | eventId={}",
                request.getPaymentId(),
                request.getOrderId(),
                request.getAmount(),
                request.getCurrency(),
                request.getCorrelationId(),
                request.getEventId()
        );

        // No DB updates here.
        // You can add gateway call / validation / publish result event later.
    }


}
