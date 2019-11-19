package com.transfer.video.vtms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Override
	public boolean isLogin(Account account) {
		// 1. 계정을 조회한다.
		Account result = this.accountMapper.select(account);
		// 2. 조회 결과가 존재하는가?
		if (result != null) {
			// 3. 비밀번호가 일치 하는가?
			if ((account.getPassword()).equals(result.getPassword()) == true) {
				// 4. 세션을 등록한다.
				HttpSession session = httpServletRequest.getSession();
				session.setAttribute("id", "true");
				return true;
			}
		}
		return false;
	}

	@Override
	public void logout() {
		// 1. 세션을 삭제한다.
		HttpSession session = httpServletRequest.getSession(false);
		session.invalidate();
	}
	
}
