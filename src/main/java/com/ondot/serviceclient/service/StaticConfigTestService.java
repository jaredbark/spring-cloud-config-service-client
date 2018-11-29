package com.ondot.serviceclient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jared (SangWon.Park@ondotsystems.com)
 * @version 1.0 2018-11-08
 */
@Service
public class StaticConfigTestService
{
	@Value("${ondot.config.profile}")
	private String profile;
	@Value("${ondot.config.level}")
	private String              level;

	Logger logger = LoggerFactory.getLogger(StaticConfigTestService.class);

	public  Map<String, String> getKeyword() {
		Map<String, String> keyword = new HashMap();
		keyword.put("profile", profile);
		keyword.put("level", level);
		logger.trace("StaticConfig - A TRACE log message");
		logger.debug("StaticConfig - A DEBUG log message");
		logger.info("StaticConfig - An INFO log message");
		logger.warn("StaticConfig - A WARN log message");
		logger.error("StaticConfig - An ERROR log message");
		return keyword;
	}
}
