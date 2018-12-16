package com.nephelo.api.vo.authority;

import com.nephelo.api.vo.user.TUserVo;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Data
public class SessionInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8081309947551163572L;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 登录名
	 */
    private String username;

	/**
	 * 用户基本信息
	 */
	private TUserVo tUserVo;

	/**
	 * 权限标识集合
	 */
	private String[] permissions;

	/**
	 * 角色集合
	 */
	private String[] roles;


}
