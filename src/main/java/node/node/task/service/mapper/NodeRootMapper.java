package node.node.task.service.mapper;

import node.node.task.entity.NodeRoot;
import node.node.task.entity.dto.NodeRootDto;
import org.springframework.stereotype.Service;

@Service
public class NodeRootMapper {

    public NodeRootDto mapEntityToDto(NodeRoot nodeRoot) {
        NodeRootDto nodeRootDto = new NodeRootDto();
        nodeRootDto.setId(nodeRoot.getId());
        nodeRootDto.setName(nodeRoot.getName());
        return nodeRootDto;
    }

    public NodeRoot mapDtoToEntity(NodeRootDto nodeRootDto) {
        NodeRoot nodeRoot = new NodeRoot();
        nodeRoot.setId(nodeRootDto.getId());
        nodeRoot.setName(nodeRootDto.getName());
        return nodeRoot;
    }
}
