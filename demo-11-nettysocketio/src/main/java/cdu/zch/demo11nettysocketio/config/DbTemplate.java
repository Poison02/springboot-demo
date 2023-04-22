package cdu.zch.demo11nettysocketio.config;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zch
 **/
@Component
public class DbTemplate {

    /**
     * 模拟数据库存储 user_id 与 session_id的关系
     */
    public static final ConcurrentHashMap<String, UUID> DB = new ConcurrentHashMap<>();

    /**
     * 获取所有SessionId
     * @return SessionId列表
     */
    public List<UUID> findAll() {
        return CollUtil.newArrayList(DB.values());
    }

    /**
     * 根绝UserId查询SessionId
     * @param userId 用户id
     * @return SessionId
     */
    public Optional<UUID> findByUserId(String userId) {
        return Optional.ofNullable(DB.get(userId));
    }

    /**
     * 保存/更新 user_id 与 session_id 的关系
     * @param userId
     * @param sessionId
     */
    public void save(String userId, UUID sessionId) {
        DB.put(userId, sessionId);
    }

    /**
     * 删除 user_id 与 session_id 的关系
     * @param userId
     */
    public void deleteByUserId(String userId) {
        DB.remove(userId);
    }
}
