package node.node.task.service;

import node.node.task.entity.NodeRoot;
import node.node.task.repository.NodeRootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NodeRootServiceImpl implements NodeRootService {

    @Autowired
    ReactiveMongoTemplate mongoTemplate;

    @Override
    public Mono<NodeRoot> save(NodeRoot nodeRoot) {
        return mongoTemplate.save(nodeRoot);
    }

    @Override
    public Flux<NodeRoot> getAll() {
        return mongoTemplate.findAll(NodeRoot.class);
    }
}
