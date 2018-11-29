package com.ondot.serviceclient.controller;

import com.ondot.serviceclient.service.DynamicConfigTestService;
import com.ondot.serviceclient.service.StaticConfigTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 * @author jared (SangWon.Park@ondotsystems.com)
 * @version 1.0 2018-11-08
 */
@Controller
@RequiredArgsConstructor(onConstructor=@__(@Inject))
@RequestMapping(value = "/config", produces = MediaType.TEXT_HTML_VALUE)
public class ConfigTestController
{
	private final @NotNull DynamicConfigTestService dynamicConfigTestService;
	private final @NotNull StaticConfigTestService staticConfigTestService;

	@GetMapping(value = "/static")
	public String getKeywordByStatic(Model model) {
		model.addAllAttributes(staticConfigTestService.getKeyword());
		return "viewKeyword";
	}

	@GetMapping(value = "/dynamic")
	public String getKeywordByDynamic(Model model) {
		model.addAllAttributes(dynamicConfigTestService.getKeyword());
		return "viewKeyword";
	}
}
