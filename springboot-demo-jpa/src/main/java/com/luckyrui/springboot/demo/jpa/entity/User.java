package com.luckyrui.springboot.demo.jpa.entity;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import javax.persistence.*;

/**
 * 位于系统外部，与系统交互的人，是使用软件的人。 系统的登录，即认证。 可以对其授予角色 {@link Role}、权限
 * {@link Permission}和用户组 <code> UserGroup </code>
 *
 * @author lucas
 */
@Entity
@DiscriminatorValue("USER")
@NamedQueries({
		@NamedQuery(name = "User.loginByUserAccount", query = "SELECT _user FROM User _user WHERE _user.userAccount = :userAccount AND _user.password = :password"),
		@NamedQuery(name = "User.count", query = "SELECT COUNT(_user.id) FROM User _user")})
public class User extends Actor  {

	private static final long serialVersionUID = 7849700468353029794L;

	private static final String INIT_PASSWORD = "888888";

	@Column(name = "USER_ACCOUNT", nullable = false)
	private String userAccount;

	@Column(name = "PASSWORD")
	private String password = INIT_PASSWORD;

	// @Email
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DISABLED")
	private boolean disabled = false;

	@Column(name = "TELE_PHONE")
	private String telePhone;

	/**
	 * 加密盐值
	 */
	@Column(name = "SALT")
	private String salt;

	/**
	 * 用户类型,0:admin,1:普通用户
	 */
	@Column(name = "USER_TYPE")
	private int userType;

	protected User() {
	}


	public void disable() {
		disabled = true;
	}

	public void enable() {
		disabled = false;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public String getSalt() {
		return salt;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}