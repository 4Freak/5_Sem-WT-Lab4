package by.BSUIR.WT.Lab4.entity;

import java.io.Serializable;

public class User implements Identifiable, Serializable{

	private int id;
	private int userInformationId;
	private int roleId;
	
	public User() {}
	
	public User(int id, int userInformation, int roleId) {
		this.id = id;
		this.userInformationId = userInformation;
		this.roleId = roleId;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserInformationId() {
		return userInformationId;
	}
	
	public void setUserInformationId(int userInformationId) {
		this.userInformationId = userInformationId;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
		
        User user = (User)obj;
        return id == user.id &&
        		userInformationId == user.userInformationId &&
        		roleId == user.roleId;
	}
	
	@Override
	public int hashCode() {
		final int mul = 44;
		int result = 4;
        result = mul * result +  id;
        result = mul * result +  userInformationId;
        result = mul * result +  roleId;
        
        return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder("User{");
        result.append("id=").append(id);
        result.append(", roleId='").append(roleId);
        result.append(", userInfoermationId=").append(userInformationId);
        result.append('}');
		return result.toString();
	}
}
