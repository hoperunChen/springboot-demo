package com.luckyrui.springboot.demo.jpa.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * 参与者, 它是一个抽象的概念。
 * 是 {@link User} 和  <code>UserGroup </code>的共同基类。
 * 可以对该类进行扩展，以达到您所希望的业务。
 * 可以对其授予角色 {@link Role} 和 权限 {@link Permission}。
 *
 * @author lucas
 */
@Entity
@Table(name = "UC_ACTOR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING)
public abstract class Actor implements org.dayatang.domain.Entity {

	private static final long serialVersionUID = -6279345771754150467L;

	@Id
	@Column(name = "id", length = 36)
	private String id;
	@Version
	@Column(name = "version")
	private int version;

	/**
	 * 名称
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * 最后更新时间
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_MODIFY_TIME")
	private Date lastModifyTime;

	/**
	 * 创建者
	 */
	@Column(name = "CREATE_OWNER")
	private String createOwner;

	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE")
	private Date createDate = new Date();

	/**
	 * 描述
	 */
	@Column(name = "DESCRIPTION")
	private String description;

	public Actor() {
	}

	public Actor(String name) {
//        checkName(name);
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	/**
	 * 更改最后修改时间。
	 */
	public void changeLastModifyTime() {
		this.lastModifyTime = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public String getCreateOwner() {
		return createOwner;
	}

	public void setCreateOwner(String createOwner) {
		this.createOwner = createOwner;
	}

	public Date getCreateDate() {
		return createDate;
	}
}
