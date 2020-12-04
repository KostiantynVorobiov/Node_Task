package node.node.task.service;

import node.node.task.entity.NodeRoot;
import node.node.task.repository.NodeRootRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@RunWith(SpringRunner.class)
class NodeRootServiceImplTest {
    NodeRootRepository repository = Mockito.mock(NodeRootRepository.class);

    @Test
    void save() {
        NodeRoot node = new NodeRoot(1L, "nodeOne");
        Mono<NodeRoot> saved = Mono.just(node);
        Mockito.when(repository.save(node)).thenReturn(saved);
        StepVerifier.create(saved)
                .expectSubscription()
                .expectNextMatches(e -> (e.getId() != null
                        && e.getName().equals(node.getName())))
                .verifyComplete();
    }

    @Test
    void getAll() throws Exception {
        Flux<NodeRoot> rootFlux = Flux.just(new NodeRoot(1L, "nodeOne"),
                new NodeRoot(2L, "nodeTwo"));
        Mockito.when(repository.findAll()).thenReturn(rootFlux);
        StepVerifier.create(repository.findAll())
                .expectSubscription()
                .expectNextCount(2)
                .verifyComplete();
    }
}
