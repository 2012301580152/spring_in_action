package cn.coder.tacos.jpaRepository;

import cn.coder.tacos.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
