package node.node.task.controller;

import node.node.task.entity.NodeDesc;
import node.node.task.entity.dto.NodeDescDto;
import node.node.task.service.NodeDescService;
import node.node.task.service.mapper.NodeDescMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/nodedesc")
public class NodeDescController {
    private final NodeDescService nodeDescService;
    private final NodeDescMapper nodeDescMapper;

    @Autowired
    public NodeDescController(NodeDescService nodeDescService, NodeDescMapper nodeDescMapper) {
        this.nodeDescService = nodeDescService;
        this.nodeDescMapper = nodeDescMapper;
    }

    @PostMapping
    public Mono<NodeDesc> addNode(@RequestBody NodeDescDto nodeDescDto) {
        return nodeDescService.save(nodeDescMapper.mapDtoToEntity(nodeDescDto));
    }

    @GetMapping
    public Flux<NodeDescDto> getAll() {
        return nodeDescService.getAll().map(nodeDescMapper::mapEntityToDto);
    }
}
