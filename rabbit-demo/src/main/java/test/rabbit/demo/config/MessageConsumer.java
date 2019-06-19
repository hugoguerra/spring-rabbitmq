package test.rabbit.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import test.rabbit.demo.vo.SampleRequest;

import java.io.IOException;

@Component
public class MessageConsumer {

    @RabbitListener(queues = "SAMPLE-INPUT-2")
    public void handleForwardEngineeringRequest(String jsonString) throws IOException {
        SampleRequest request = new ObjectMapper().readValue(jsonString, SampleRequest.class);
        System.out.println("User Id **************" + request.getUserId());
        System.out.println("Password **************" + request.getPassword());
    }
}
