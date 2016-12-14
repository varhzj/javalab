package com.varhzj.lab.springmvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorMessage", exception.getMessage());
		return extracted(mv);
	}

	private ModelAndView extracted(ModelAndView mv) {
		return mv;
	}

	@ModelAttribute
	public void addAttribute(Model model) {
		model.addAttribute("msg", "extra message");
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		// 下面这一句将会导致id被忽略
//		webDataBinder.setDisallowedFields("id");
	}

}
