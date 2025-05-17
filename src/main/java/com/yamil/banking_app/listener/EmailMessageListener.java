package com.yamil.banking_app.listener;

import com.yamil.banking_app.dto.EmailMessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.yamil.banking_app.config.RabbitMQConfig.QUEUE;

@Component
public class EmailMessageListener {

    @RabbitListener(queues = QUEUE)
    public void handleEmailMessage(EmailMessageDto emailMessageDto) {
        System.out.println("📧 Enviando correo a: " + emailMessageDto.getTo());
        System.out.println("Asunto: " + emailMessageDto.getSubject());
        System.out.println("Mensaje: " + emailMessageDto.getBody());
    }
}
