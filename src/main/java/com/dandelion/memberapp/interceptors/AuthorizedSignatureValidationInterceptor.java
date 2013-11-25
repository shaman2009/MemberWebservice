package com.dandelion.memberapp.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dandelion.memberapp.dao.data.AccountMapper;
import com.dandelion.memberapp.dao.data.WSUserSessionInfoMapper;
import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.exception.WebserviceErrors;
import com.dandelion.memberapp.model.po.User;
import com.dandelion.memberapp.model.po.Wsusersession;

public class AuthorizedSignatureValidationInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		try {
			String j = null;
			if (request instanceof MultipartHttpServletRequest) {
				MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
				j = mRequest.getParameter("j");
			} else {
				j = request.getParameter("j");
			}
			if (j == null) {
				throw new MemberAppException(
						WebserviceErrors.SERVER_INTERNAL_ERROR_CODE,
						WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE);
			}
			JSONObject json = new JSONObject(j);
			if(!json.has("sid")){
				throw new MemberAppException(
						WebserviceErrors.SERVER_INTERNAL_ERROR_CODE,
						WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE);
			}
			String sid = json.getString("sid");
//			UUID usid = UUID.fromString(sid);
			Wsusersession actualSession = wsUserSessionInfoMapper.getKeyByID(sid);
			if (actualSession == null) {
				throw new MemberAppException(WebserviceErrors.SESSION_EXPIRED_CODE, WebserviceErrors.SESSION_EXPIRED_MESSAGE);
			}
			User user = accountMapper.getBySessionID(sid);
			if (user == null) {
				throw new MemberAppException(
						WebserviceErrors.SERVER_INTERNAL_ERROR_CODE,
						WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE);
			}
			userAuthentication.authorize(user);
			return true;
		} catch (JSONException e) {
			throw new MemberAppException(WebserviceErrors.SIGNATURE_ERROR_CODE,
					WebserviceErrors.SIGNATURE_ERROR_MESSAGE, e);
		}
	}



	@Autowired
	private WSUserSessionInfoMapper wsUserSessionInfoMapper;
	@Autowired
	private UserAuthentication userAuthentication;
	@Autowired
	private AccountMapper accountMapper;
}
