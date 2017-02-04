package org.smart4j.chatpper3.controller;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.bean.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AdrainHuang on 2017/1/26.
 */

@Controller
public class HelloController {

	@Action(value = "get:/test")
	public View testAction(){
		SimpleDateFormat dateFormatf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = dateFormatf.format(new Date());
		View view = new View("hello.jsp");
		view.addModel("currentTime",currentTime);
		return view;
	}
}

