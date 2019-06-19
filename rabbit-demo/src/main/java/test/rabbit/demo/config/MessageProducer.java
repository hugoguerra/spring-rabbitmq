package test.rabbit.demo.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import test.rabbit.demo.vo.SampleRequest;

@Component
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(ConnectionFactory connectionFactory){
        this.rabbitTemplate = new RabbitTemplate(connectionFactory);
    }

    public void sendMessage(SampleRequest request) {
        rabbitTemplate.convertAndSend("SAMPLE-INPUT-2", request.toString());
    }
}
