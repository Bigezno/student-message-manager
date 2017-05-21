package validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<phone,String>{
	//手机号码正则表达式
	private String phoneRegex = "0?(13|14|15|18)[0-9]{9}";
	private Pattern phonePattern = Pattern.compile(phoneRegex);
	
//	private String message;
	
	//用于获取到限制类型，如phone中的message
	@Override
	public void initialize(phone arg0) {
//		message = arg0.message();
	}

	
	//用于校验输入的参数是否与限制类型phone是否匹配
	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext arg1) {
		if(phoneNo==null) {
			return false;
		}
		return phonePattern.matcher(phoneNo.toString().trim()).matches();
	}

}
