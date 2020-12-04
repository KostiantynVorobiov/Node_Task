package node.node.task.controller;

import node.node.task.entity.NodeRoot;
import node.node.task.entity.dto.NodeRootDto;
import node.node.task.repository.NodeRootRepository;
import node.node.task.service.NodeRootService;
import node.node.task.service.mapper.NodeDescMapper;
import node.node.task.service.mapper.NodeRootMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@WebFluxTest(NodeRootController.class)
@Import({NodeRootMapper.class})
class NodeRootControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    private TestRestTemplate template;


    @MockBean
    NodeRootService service;

//    @MockBean
//    private MongoTemplate mongoTemplatel;


    @Test
    void testCreateNodeRoot() {
//        NodeRoot nodeRoot = new NodeRoot(1L, "nodeRoot");
//        Mockito.when(repository.save(nodeRoot)).thenReturn(Mono.just(nodeRoot));
//        webTestClient.post()
//                .uri("/noderoot")
//                .contentType(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isCreated();
//        Mockito.verify(repository, times(1)).save(nodeRoot);

        NodeRoot nodeRoot = new NodeRoot(1L, "nodeRoot");
        Mockito.when(service.save(nodeRoot)).thenReturn(Mono.just(nodeRoot));
        webTestClient.post()
                .uri("/noderoot/creat")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(nodeRoot), NodeRootDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.id").isEqualTo(nodeRoot.getId())
                .jsonPath("$.name").isEqualTo(nodeRoot.getName());
        Mockito.verify(service, times(1)).save(nodeRoot);
    }
    
//    @Test
//    void getAllTest() {
//        NodeRoot nodeRootOne = new NodeRoot(1L, "nodeRootOne");
//        NodeRoot nodeRootTwo = new NodeRoot(2L, "nodeRootTwo");
//        List<NodeRoot> list = new ArrayList<>();
//        list.add(nodeRootOne);
//        list.add(nodeRootTwo);
//        Flux<NodeRoot> rootFlux = Flux.fromIterable(list);
//        Mockito.when(repository.findAll()).thenReturn(rootFlux);
//        webTestClient.get()
//                .uri("/")
//                .header(HttpHeaders.ACCEPT, "application/json")
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(NodeRoot.class);
//        Mockito.verify(repository, times(1)).findAll();
//    }
}