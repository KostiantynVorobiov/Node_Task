package node.node.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
public class NodeTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(NodeTaskApplication.class, args);
    }

}
