package node.node.task.service;

import node.node.task.entity.NodeDesc;
import node.node.task.entity.NodeRoot;
import node.node.task.repository.NodeDescRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@RunWith(SpringRunner.class)
class NodeDescServiceImplTest {
    NodeDescRepository repository = Mockito.mock(NodeDescRepository.class);

    @Test
    void save() {
        NodeDesc nodeDesc = new NodeDesc(1L, "nodeOne", "First Node");
        Mono<NodeDesc> nodeMono = Mono.just(nodeDesc);
        Mockito.when(repository.save(nodeDesc)).thenReturn(nodeMono);
        StepVerifier.create(nodeMono)
                .expectSubscription()
                .expectNextMatches(e -> (e.getId() != null
                        && e.getName().equals(nodeDesc.getName())))
                .verifyComplete();
    }

    @Test
    void getAll() {
        Flux<NodeDesc> descFlux = Flux.just(new NodeDesc(1L, "nodeOne", "firstNode"),
                new NodeDesc(2L, "nodeTwo", "secondNode"),
                new NodeDesc(3L, "nodeThree", "thirdNode"));
        Mockito.when(repository.findAll()).thenReturn(descFlux);
        StepVerifier.create(repository.findAll())
                .expectSubscription()
                .expectNextCount(3)
                .verifyComplete();
    }
}
