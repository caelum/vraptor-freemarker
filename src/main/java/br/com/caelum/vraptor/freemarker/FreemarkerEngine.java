package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Result;
import freemarker.template.Configuration;

@RequestScoped
public class FreemarkerEngine implements Freemarker {

	private HttpServletResponse response;
	private Result result;
	private Configuration cfg;

	@Deprecated // CDI eyes only
	public FreemarkerEngine() {}

	@Inject
	public FreemarkerEngine(Result result, HttpServletResponse
			response, FreemarkerConfiguration cfg) {
		this.result = result;
		this.response = response;
		this.cfg = cfg.getConfiguration();
	}

	@Override
	public Template use(String name) throws IOException {
		return use(name, cfg);
	}
	
	@Override
	public Template use(String name, Configuration configuration) throws IOException {
		freemarker.template.Template template = configuration.getTemplate(name + ".ftl");
		return new DefaultTemplate(template, response, result);
	}

}
