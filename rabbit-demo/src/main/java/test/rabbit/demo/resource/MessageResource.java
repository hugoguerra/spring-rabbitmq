package test.rabbit.demo.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.rabbit.demo.config.MessageProducer;
import test.rabbit.demo.vo.SampleRequest;

@RestController
@RequestMapping("/message/rabbit")
public class MessageResource {

    private MessageProducer messageProducer;

    public MessageResource(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> message(@RequestBody SampleRequest sampleRequest) {
        try {
            messageProducer.sendMessage(sampleRequest);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
