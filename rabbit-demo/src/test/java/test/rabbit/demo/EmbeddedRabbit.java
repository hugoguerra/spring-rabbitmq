package test.rabbit.demo;


import com.google.common.io.Files;
import org.apache.qpid.server.Broker;
import org.apache.qpid.server.BrokerOptions;
import org.junit.rules.ExternalResource;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class EmbeddedRabbit extends ExternalResource {

    private static final String QPID_CONFIG_LOCATION = "src/test/resources/qpid-config.json";
    public static final String APPLICATION_CONFIG_LOCATION = "src/test/resources/application.properties";

    private Broker broker;

    @Override
    protected void before() throws Throwable {
        broker = new Broker();

        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(APPLICATION_CONFIG_LOCATION)));
        String rabbitmqPort = properties.getProperty("spring.rabbitmq.port");

        File folder = Files.createTempDir();
        String userDir = String.valueOf(System.getProperty("user.dir"));
        File file = new File(userDir);
        String homePath = file.getAbsolutePath();

        BrokerOptions brokerOptions = new BrokerOptions();
        brokerOptions.setConfigProperty("qpid.work_dir", folder.getAbsolutePath());
        brokerOptions.setConfigProperty("qpid.amqp_port", rabbitmqPort);
        brokerOptions.setConfigProperty("qpid.home_dir", homePath);
        brokerOptions.setInitialConfigurationLocation(QPID_CONFIG_LOCATION);
        broker.startup(brokerOptions);
    }

    @Override
    protected void after() {
        broker.shutdown();
    }
}
