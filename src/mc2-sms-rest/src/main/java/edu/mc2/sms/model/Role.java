package edu.mc2.sms.model;

public class Role {

	public static final String ROLE_PREFIX = "ROLE_";
	//TODO:BAD DESIGN : Also defined in Database.
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_STAFF = "STAFF";
	public static final String ROLE_STUDENT = "STUDENT";
	
	
	public static String getDBRole(String role){
		return ROLE_PREFIX + role;
	}

	
	private int roleId;
	private String roleName;
	
	
	public Role() {
		super();
	}
	
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
