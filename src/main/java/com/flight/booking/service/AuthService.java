package com.flight.booking.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flight.booking.model.User;
import com.flight.booking.repository.BlockedTokenRepository;
import com.flight.booking.repository.UserRepository;
import com.flight.booking.repository.entity.BlockedTokensEntity;
import com.flight.booking.repository.entity.UsersEntity;
import com.flight.booking.utils.JwtUtils;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlockedTokenRepository blockedTokenRepository;

	@Value("${application.jwt.subject}")
	private String jwtSubject;

	@Value("${application.jwt.secret}")
	private String jwtSecret;

	@Value("${application.jwt.expTime}")
	private int expTime;

	public String signIn(String signInId, String password) {
		return Optional.ofNullable(userRepository.findByEmail(signInId).orElse(null))
				.filter(userEntity -> userEntity != null && userEntity.getUserCredentials() != null
						&& password.equals(userEntity.getUserCredentials().getPassword()))
				.map(userEntity -> {
					Map<String, Object> claimMap = new HashMap<>();
					claimMap.put("userId", userEntity.getUserId());
					claimMap.put("email", userEntity.getEmail());
					claimMap.put("name", userEntity.getUserName());
					claimMap.put("phone", userEntity.getPhone());
					claimMap.put("role", userEntity.getRole().getRoleName());
					LocalDateTime currentTime = LocalDateTime.now();
					Date iat = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());
					Date exp = Date.from(currentTime.plusHours(expTime).atZone(ZoneId.systemDefault()).toInstant());
					return JwtUtils.buildToken(claimMap, jwtSubject, jwtSecret, iat, exp);
				}).orElse(null);
	}

	public String signUp(User userRq) {
		return null;
	}

	public void signOut(String accessToken) {
		BlockedTokensEntity tokenEntity = new BlockedTokensEntity();
		tokenEntity.setToken(accessToken);
		blockedTokenRepository.save(tokenEntity);
	}

	public User updateUserDetails(User userRq) {
		UsersEntity usersEntity = new UsersEntity();
		usersEntity.setEmail(userRq.getEmail());
		usersEntity.setUserId(userRq.getUserId());
		usersEntity.setUserName(userRq.getUserName());
		usersEntity.setPhone(userRq.getPhone());
		usersEntity.setEmailVerified(userRq.isEmailVerified());
		return null;
	}

	public void updatePassword(String userId, String password) {
	}

}
