package cn.coder.tacos.web.repository;

import cn.coder.tacos.web.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
