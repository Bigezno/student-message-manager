package pojo;

import java.io.Serializable;
     import javax.validation.constraints.NotNull;
     import javax.validation.constraints.Pattern;
     import validator.ValidatorGroup1;
     
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Pattern(regexp = "enzo", message = "账号错误", groups = { ValidatorGroup1.class })
	@NotNull(message = "账号不能为空", groups = { ValidatorGroup1.class })
	private String manager_name;

	@Pattern(regexp = "123456", message = "密码错误", groups = { ValidatorGroup1.class })
	@NotNull(message = "密码不能为空", groups = { ValidatorGroup1.class })
	private String password;

	public String getManager_name() {
		return this.manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Manamger [manager_name=" + this.manager_name + ", password=" + this.password + "]";
	}
}

