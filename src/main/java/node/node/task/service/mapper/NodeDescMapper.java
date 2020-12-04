package node.node.task.service.mapper;

import node.node.task.entity.NodeDesc;
import node.node.task.entity.dto.NodeDescDto;
import org.springframework.stereotype.Service;

@Service
public class NodeDescMapper {

    public NodeDescDto mapEntityToDto(NodeDesc nodeDesc) {
        NodeDescDto nodeDescDto = new NodeDescDto();
        nodeDescDto.setId(nodeDesc.getId());
        nodeDescDto.setName(nodeDesc.getName());
        nodeDescDto.setDescription(nodeDesc.getDescription());
        return nodeDescDto;
    }

    public NodeDesc mapDtoToEntity(NodeDescDto nodeDescDto) {
        NodeDesc nodeDesc = new NodeDesc();
        nodeDesc.setId(nodeDescDto.getId());
        nodeDesc.setName(nodeDescDto.getName());
        nodeDesc.setDescription(nodeDescDto.getDescription());
        return nodeDesc;
    }
}
