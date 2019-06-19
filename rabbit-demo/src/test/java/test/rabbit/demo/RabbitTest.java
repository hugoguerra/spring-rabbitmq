package test.rabbit.demo;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {

    @ClassRule
    public static EmbeddedRabbit embeddedRabbit = new EmbeddedRabbit();

    private final static String QUEUE_ROUTINGKEY = "queue-spring-boot";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void initMessages() throws InterruptedException {
        this.rabbitTemplate.convertAndSend(QUEUE_ROUTINGKEY, "Hello from RabbitMQ Sent 1!");

        Thread.sleep(5000);

        System.out.println("foi");
    }
}
