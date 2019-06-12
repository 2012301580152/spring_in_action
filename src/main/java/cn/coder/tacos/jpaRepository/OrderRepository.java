package cn.coder.tacos.jpaRepository;

import cn.coder.tacos.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
