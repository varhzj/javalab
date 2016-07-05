package com.varhzj.lab.springmvc.messageconverter;

import java.io.IOException;
import java.nio.charset.Charset;

import com.varhzj.lab.springmvc.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

	public MyMessageConverter() {
		super(new MediaType("application", "x-zhijianlab", Charset.forName("UTF-8")));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return DemoObj.class.isAssignableFrom(clazz);
	}

	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		String tmp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		String[] tmpArr = tmp.split("-");
		return new DemoObj(new Long(tmpArr[0]), tmpArr[1]);
	}

	@Override
	protected void writeInternal(DemoObj t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out = "hello: " + t.getId() + "-" + t.getName();
		outputMessage.getBody().write(out.getBytes());
	}

}
