package com.news.user.profile.servcie;

import com.news.user.profile.model.User;
import com.news.user.profile.model.UserRto;

public class Mapper {

	public static User mapUser(UserRto userRto) {
		User user = new User();
		user.setUsername(userRto.getUsername());
		user.setEmailId(userRto.getEmailId());
		user.setFirstName(userRto.getFirstName());
		user.setLastName(userRto.getLastName());
		user.setCountry(userRto.getCountry());
		user.setGender(userRto.getGender());
		user.setCity(userRto.getCity());
		return user;

	}

}
