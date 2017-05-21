 package exception;
 
 
 //自定义学生异常类
public class StudentException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public StudentException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

