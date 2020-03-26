package com.news.user.profile.servcie;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.news.user.profile.model.UserPojo;

@FeignClient(name="authorization-service" )
@RibbonClient(name="authorization-service")
public interface AuthServiceProxy {
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<?> registerNewUser(@RequestBody UserPojo user) ;

}
