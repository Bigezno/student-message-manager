package exception.resolver;

import exception.StudentException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {
	
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		
		System.out.println("异常开始-----");
		arg3.printStackTrace();
		System.out.println("异常结束------");
		StudentException studentException = null;
		if ((arg3 instanceof StudentException))
			studentException = (StudentException) arg3;
		else {
			studentException = new StudentException("异常信息：不知名错误!!!");
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", studentException.getMessage());
		mav.setViewName("error");  //跳转到错误页面
		return mav;
	}
	
}

