package com.yamil.banking_app.publisher;

import com.yamil.banking_app.dto.EmailMessageDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.yamil.banking_app.config.RabbitMQConfig.*;

@Component
public class EmailMessagePublisher {

    private final RabbitTemplate rabbitTemplate; //Me permite enviar mensajes a RabbitMQ (como si fuera un cliente)

    public EmailMessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    } //Aquí hay inyección de dependencias

    public void sendEmailMessage(EmailMessageDto emailMessageDto) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, emailMessageDto);
    } // El mensaje que envía el Publisher (Productor) es un objeto EmailMessageDto
}
