package node.node.task.controller;

import node.node.task.entity.NodeDesc;
import node.node.task.repository.NodeDescRepository;
import node.node.task.service.NodeDescService;
import node.node.task.service.NodeRootService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest(controllers = NodeDescController.class)
@Import(NodeDescService.class)
class NodeDescControllerTest {

    @MockBean
    NodeDescRepository repository;

    @Autowired
    private WebTestClient webClient;

//    @MockBean
//    private MongoTemplate mongoTemplatel;

    @Test
    void addNode() {
    }

    @Test
    void getAll() {
        NodeDesc nodeDescOne = new NodeDesc(1L, "nodeOne", "firstNode");
        NodeDesc nodeDescSecond = new NodeDesc(2L, "nodeTwo", "secondNode");
        NodeDesc nodeDescThird = new NodeDesc(3L, "nodeThree", "thirdNode");
        List<NodeDesc> nodeDescList = new ArrayList<>();
        nodeDescList.add(nodeDescOne);
        nodeDescList.add(nodeDescSecond);
        nodeDescList.add(nodeDescThird);
        Flux<NodeDesc> nodeDescFlux = Flux.fromIterable(nodeDescList);
        Mockito.when(repository.findAll()).thenReturn(nodeDescFlux);
        webClient.get().uri("/nodedesc")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(NodeDesc.class);
    }
}