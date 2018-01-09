package cn.com.qxl.shiro.model;

public class SysUsers {
    private Long id;            //

    private String username;            //

    private String password;            //

    private String salt;            //

    private Boolean locked;            //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

	@Override
	public String toString() {
		return "SysUsers [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", locked=" + locked + "]";
	}
    
}