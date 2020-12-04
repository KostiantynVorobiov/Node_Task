package node.node.task.service;

import node.node.task.entity.NodeRoot;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NodeRootService {
    Mono<NodeRoot> save(NodeRoot root);

    Flux<NodeRoot> getAll();
}
