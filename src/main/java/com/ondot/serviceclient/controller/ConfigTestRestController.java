package com.ondot.serviceclient.controller;

import com.ondot.serviceclient.service.DynamicConfigTestService;
import com.ondot.serviceclient.service.StaticConfigTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author jared (SangWon.Park@ondotsystems.com)
 * @version 1.0 2018-11-08
 */
@RestController
@RequiredArgsConstructor(onConstructor=@__(@Inject))
public class ConfigTestRestController
{
	@Value("${ondot.config.profile}")
	private                String                   profile;
	@Value("${ondot.config.level}")
	private                String                   level;

	private final @NotNull DynamicConfigTestService dynamicConfigTestService;
	private final @NotNull StaticConfigTestService  staticConfigTestService;

	@RequestMapping(value="/rest/static", method= RequestMethod.GET)
	public Map<String, String> getKeywordByStatic() {
		return staticConfigTestService.getKeyword();
	}

	@RequestMapping(value="/rest/dynamic", method= RequestMethod.GET)
	public Map<String, String> getKeywordByDynamic() {
		return dynamicConfigTestService.getKeyword();
	}
}
