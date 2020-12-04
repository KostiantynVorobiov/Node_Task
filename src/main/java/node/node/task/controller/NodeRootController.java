package node.node.task.controller;

import node.node.task.entity.NodeRoot;
import node.node.task.entity.dto.NodeRootDto;
import node.node.task.service.NodeRootService;
import node.node.task.service.mapper.NodeRootMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/noderoot")
public class NodeRootController {
    private final NodeRootService nodeRootService;
    private final NodeRootMapper nodeRootMapper;

    @Autowired
    public NodeRootController(NodeRootService nodeService, NodeRootMapper nodeRootMapper) {
        this.nodeRootService = nodeService;
        this.nodeRootMapper = nodeRootMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<NodeRoot> addNode(@RequestBody NodeRootDto nodeRootDto) {
        return nodeRootService.save(nodeRootMapper.mapDtoToEntity(nodeRootDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<NodeRootDto> getAll() {
        return nodeRootService.getAll().map(nodeRootMapper::mapEntityToDto);
    }
}
