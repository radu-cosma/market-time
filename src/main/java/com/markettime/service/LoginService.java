package com.markettime.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markettime.context.SessionContext;
import com.markettime.model.User;

/**
 *
 * @author Radu Cosma
 *
 */
@Service
@Transactional
public class LoginService {

	private static final Map<String, String> USERS;

	static {
		USERS = new HashMap<String, String>();
		USERS.put("radu", "radu");
	}

	@Autowired
	private SessionService sessionService;

	@Autowired
	private SessionContext sessionContext;

	public String doLogin(User user) {
		String password = USERS.get(user.getUsername());
		String uuid = null;
		if (password != null && password.equals(user.getPassword())) {
			sessionContext.setLoggedIn(true);
			sessionContext.setUsername(user.getUsername());
			uuid = sessionService.createSession(user.getUsername(), user.getPassword().toCharArray());
		}
		return uuid;
	}

}
