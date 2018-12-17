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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TUserVo gettUserVo() {
		return tUserVo;
	}

	public void settUserVo(TUserVo tUserVo) {
		this.tUserVo = tUserVo;
	}

	public String[] getPermissions() {
		return permissions;
	}

	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
}
