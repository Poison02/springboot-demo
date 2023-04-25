package cdu.zch.demo15jpa.mapper;

import cdu.zch.demo15jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zch
 * @data 2023/4/25
 **/
@Repository
public interface UserMapper extends JpaRepository<User, Long> {
}
