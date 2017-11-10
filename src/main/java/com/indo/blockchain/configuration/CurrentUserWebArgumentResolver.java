package com.indo.blockchain.configuration;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.indo.blockchain.repository.IUserDao;

public class CurrentUserWebArgumentResolver implements HandlerMethodArgumentResolver {

	@Autowired
	private IUserDao userDao;

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer arg1,
			NativeWebRequest webRequest, WebDataBinderFactory arg3) throws Exception {
		if (this.supportsParameter(methodParameter)) {
			System.out.println("ON PASSSE LA ?????");
			Principal principal = webRequest.getUserPrincipal();
			String username = principal.getName();
			System.out.println("WEB ARGUMENT RESOLVER : " + username);
			System.out.println(userDao);
			return userDao.findByUsername(username);
		} else {
			return WebArgumentResolver.UNRESOLVED;
		}
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return false;
	}
}