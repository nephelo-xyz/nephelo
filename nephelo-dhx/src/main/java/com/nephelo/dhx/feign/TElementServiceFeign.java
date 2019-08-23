package com.nephelo.dhx.feign;

import com.nephelo.api.vo.authority.PermissionInfo;
import com.nephelo.dhx.po.TElementVo;
import com.nephelo.dhx.service.TElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("tElementServiceFeign")
public class TElementServiceFeign {
	@Autowired
	private TElementService tElementService;

	/**
	 *
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/findPermissionInfoByRoles/{roles}", method = RequestMethod.POST)
	public Set<PermissionInfo> findPermissionInfoByRoles(@PathVariable("roles") String roles) {
		Set<PermissionInfo> resultList = new HashSet<>();
		try {
			String[] roleList = roles.split(";");
			for(int i=0;i<roleList.length;i++){
				String role = roleList[i];
				List<TElementVo> tElements = tElementService.getListByRole(role);
				tElements.forEach(tElement -> {
					PermissionInfo permissionInfo = new PermissionInfo();
					permissionInfo.setCode(tElement.getCode());
					permissionInfo.setMethod(tElement.getMethod());
					permissionInfo.setType(tElement.getType());
					permissionInfo.setUri(tElement.getUri());
					resultList.add(permissionInfo);
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
}