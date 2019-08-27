package com.nephelo.gate.feign;

import com.nephelo.api.vo.authority.PermissionInfo;
import com.nephelo.api.vo.user.TUserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * Created by nephelo on 2018/12/21.
 */
@FeignClient("nephelo-user")
public interface IUserServiceFeign {
	
	@RequestMapping(value = "/tUserServiceFeign/user/username/{username}", method = RequestMethod.POST)
	TUserVo getByUsername(@PathVariable("username") String username);

	/**
	 * 通过角色名查询菜单
	 *
	 * @param roles 角色名称  分号隔开
	 * @return 菜单列表
	 */
	@RequestMapping(value = "/tElementServiceFeign/findPermissionInfoByRoles/{roles}", method = RequestMethod.POST)
	Set<PermissionInfo> findPermissionInfoByRoles(@PathVariable("roles") String roles);

	@RequestMapping(value = "/v1/tUser/register")
	Set<PermissionInfo> findPermissionInfoByRole(@PathVariable("roles") String roles);

}
