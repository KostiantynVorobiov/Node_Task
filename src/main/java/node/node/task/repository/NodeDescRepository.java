package node.node.task.repository;


import node.node.task.entity.NodeDesc;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

public interface NodeDescRepository extends ReactiveMongoRepository<NodeDesc, Long> {
}
