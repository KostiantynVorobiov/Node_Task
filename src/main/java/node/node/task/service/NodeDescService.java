package node.node.task.service;

import node.node.task.entity.NodeDesc;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NodeDescService {
    Mono<NodeDesc> save(NodeDesc nodeDesc);

    Flux<NodeDesc> getAll();
}
