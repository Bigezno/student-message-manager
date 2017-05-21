package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexValidator implements ConstraintValidator<Sex,String>{

	
	@Override
	public void initialize(Sex arg0) {
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		
		if(arg0.equals("男")) {
			return true;
		}else if(arg0.equals("女")) {
			return true;
		}
		
		return false;
	}

}

