package node.node.task.repository;

import node.node.task.entity.NodeRoot;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

public interface NodeRootRepository extends ReactiveMongoRepository<NodeRoot, Long> {
}
