package controller;

import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bo.User;

@Controller
public class RegistrationController {
	@Autowired
	private MessageSource messages;
	
	@ModelAttribute
	public User exposeUser(){
		System.out.println("creating @ModelAttribute object");
		return new User();
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String letsSee()
	{
		return "form";
	}
	
	@RequestMapping(value = "/submituser",method={RequestMethod.POST,RequestMethod.GET} )
	public  @ResponseBody UserJsonResponse submitUser(@Valid User user,BindingResult bindingResult)
	{
		
		System.out.println("Submited User Data : \n"+user);
		
		UserJsonResponse userJsonResponse=new UserJsonResponse();
		
		if(bindingResult.hasErrors())
		
		{
			Map<String ,String> errors=new HashMap<String, String>();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			
			for (FieldError fieldError : fieldErrors) {
				
				String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode(), fieldError.getCode());
				
				String string = resolveMessageCodes[0];
				//System.out.println("resolveMessageCodes : "+string);
				
				String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
				//System.out.println("Meassage : "+message);
				
				errors.put(fieldError.getField(), message)	;
			}
			
			userJsonResponse.setErrorsMap(errors);
			userJsonResponse.setUser(user);
			userJsonResponse.setStatus("ERROR");
		}else{
			userJsonResponse.setStatus("SUCCESS");
		}
		return userJsonResponse;
	}
	
	public MessageSource getMessages() {
		return messages;
	}
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}
	////////////////////////////////////////////////////////////
	class UserJsonResponse{
		private String status;
		private Map<String,String> errorsMap;
		private User user;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Map<String,String> getErrorsMap() {
			return errorsMap;
		}
		public void setErrorsMap(Map<String,String> errorsMap) {
			this.errorsMap = errorsMap;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
	}
	
	
	 @InitBinder
	 protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	     binder.registerCustomEditor(long.class, new PropertyEditorSupport() {
	     @Override
	     public void setAsText(String text) {
	    	 if(text.trim().length()==0){
	    		 text="0";
	    	 }
	         long ch = Long.parseLong(text);
	         setValue(ch);
	     }
	     });
	    
	 }
}
