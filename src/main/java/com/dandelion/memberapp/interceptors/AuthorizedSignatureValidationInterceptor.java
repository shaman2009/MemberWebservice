package com.dandelion.memberapp.interceptors;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dandelion.memberapp.dao.data.AccountMapper;
import com.dandelion.memberapp.dao.data.WSUserSessionInfoMapper;
import com.dandelion.memberapp.dao.model.User;
import com.dandelion.memberapp.dao.model.Wsusersession;
import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.exception.WebserviceErrors;

public class AuthorizedSignatureValidationInterceptor extends
		HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		try {
			logger.debug("Getting into AuthorizedSignatureValidationInterceptor");
			String j = null;
			if (request instanceof MultipartHttpServletRequest) {
				MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
				j = mRequest.getParameter("j");
			} else {
				j = request.getParameter("j");
			}
			if (j == null) {
				logger.error("The request parameter j is null");
				throw new MemberAppException(
						WebserviceErrors.SERVER_INTERNAL_ERROR_CODE,
						WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE);
			}
			logger.info("Request parameter j: " + j);
			JSONObject json = new JSONObject(j);
			if(!json.has("sid")){
				logger.error("sid not found in json string");
				throw new MemberAppException(
						WebserviceErrors.SERVER_INTERNAL_ERROR_CODE,
						WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE);
			}
			String sid = json.getString("sid");
//			UUID usid = UUID.fromString(sid);
			Wsusersession actualSession = wsUserSessionInfoMapper.getKeyByID(sid);
			if (actualSession == null) {
				logger.info("Couldn't get user info, because session was expired");
				throw new MemberAppException(WebserviceErrors.SESSION_EXPIRED_CODE,
						WebserviceErrors.SESSION_EXPIRED_MESSAGE);
			}

			User user = accountMapper.getBySessionID(sid);
			if (user == null) {
				logger.error("Couldn't get user by the requested sid: " + sid);
				throw new MemberAppException(
						WebserviceErrors.SERVER_INTERNAL_ERROR_CODE,
						WebserviceErrors.SERVER_INTERNAL_ERROR_MESSAGE);
			}
			userAuthentication.authorize(user);
			return true;
		} catch (JSONException e) {
			logger.error("Parse json error", e);
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
	private static Logger logger = Logger.getLogger(AuthorizedSignatureValidationInterceptor.class);
}
