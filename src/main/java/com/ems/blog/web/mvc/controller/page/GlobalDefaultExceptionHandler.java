package com.ems.blog.web.mvc.controller.page;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ems.blog.exception.BlogException;
import com.ems.blog.web.mvc.json.JsonRpcError;

/**
 * @author manjit.singh
 * Exception handler controller class
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /**
     * The JSON response of application exception because of validation failure
     * 
     * @param BlogException the caught EmsBlogException
     * @return JsonRpcError the Json Error response
     */
	@ExceptionHandler(value = BlogException.class)
	@ResponseBody
	public JsonRpcError EmsBlogExceptionHandler(BlogException e){
		return new JsonRpcError(e.getCode(),e.getMessage(),e.getError());
	}
	
    /**
     * The JSON response of System exception 
     * 
     * @param Exception the caught java Exception
     * @return JsonRpcError the Json Error response
     */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JsonRpcError defaultExceptionHandler(Exception e){
		return new JsonRpcError(e.hashCode(),e.getMessage(),e);
	}
}
