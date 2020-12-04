package node.node.task.service;

import node.node.task.entity.NodeDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class NodeDescServiceImpl implements NodeDescService{

    @Autowired
    ReactiveMongoTemplate mongoTemplate;

    @Override
    public Mono<NodeDesc> save(NodeDesc nodeDesc) {
        return mongoTemplate.save(nodeDesc);
    }

    @Override
    public Flux<NodeDesc> getAll() {
        return mongoTemplate.findAll(NodeDesc.class);
    }
}
