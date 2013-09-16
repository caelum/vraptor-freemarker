package br.com.caelum.vraptor.freemarker;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Result;
import freemarker.core.Environment;
import freemarker.template.TemplateException;

public class DefaultTemplate implements Template {

	private freemarker.template.Template template;
	private final Map<String, Object> root = new HashMap<String, Object>();
	private HttpServletResponse response;
	private Result result;

	public DefaultTemplate(freemarker.template.Template template,
			HttpServletResponse response, Result result) {
		this.template = template;
		this.response = response;
		this.result = result;
	}

	@Override
	public void render() throws IOException, TemplateException {
		PrintWriter writer = response.getWriter();
		Environment processingEnv = template.createProcessingEnvironment(root, writer);
		processingEnv.setOutputEncoding("UTF-8");
		processingEnv.process();
		writer.flush();

		result.nothing();
	}

	@Override
	public Template with(String key, Object value) {
		root.put(key, value);
		return this;
	}

	@Override
	public String getContent() throws IOException, TemplateException {
		StringWriter writer = new StringWriter();
		Environment processingEnv = template.createProcessingEnvironment(root, writer);
		processingEnv.setOutputEncoding("UTF-8");
		processingEnv.process();
		writer.flush();

		return writer.getBuffer().toString();
	}
}
