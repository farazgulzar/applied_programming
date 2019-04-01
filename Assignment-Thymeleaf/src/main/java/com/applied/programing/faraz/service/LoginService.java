package com.applied.programing.faraz.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applied.programing.faraz.entity.User;
import com.applied.programing.faraz.entity.vo.LoginVo;
import com.applied.programing.faraz.entity.vo.UserVo;
import com.applied.programing.faraz.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public UserVo auth(LoginVo loginVo) {
		UserVo userVo = null;
		User user = null;
		user = userRepository.findByLoginIdAndPassword(loginVo.getLoginId(), loginVo.getPassword());
		
		if(user != null) {
			userVo = new UserVo();
			BeanUtils.copyProperties(user, userVo);
		}
		return userVo;
	}
	
	
	
}
