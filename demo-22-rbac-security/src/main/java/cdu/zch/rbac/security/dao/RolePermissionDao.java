package cdu.zch.rbac.security.dao;

import cdu.zch.rbac.security.model.RolePermission;
import cdu.zch.rbac.security.model.unionkey.RolePermissionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 角色-权限 DAO
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-10 13:45
 */
public interface RolePermissionDao extends JpaRepository<RolePermission, RolePermissionKey>, JpaSpecificationExecutor<RolePermission> {
}
