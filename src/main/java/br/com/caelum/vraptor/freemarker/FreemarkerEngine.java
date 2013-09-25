package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Result;

@RequestScoped
public class FreemarkerEngine implements Freemarker {

	private HttpServletResponse response;
	private Result result;
	private FreemarkerConfiguration cfg;

	@Deprecated // CDI eyes only
	public FreemarkerEngine() {}

	@Inject
	public FreemarkerEngine(Result result, HttpServletResponse
			response, FreemarkerConfiguration cfg) {
		this.result = result;
		this.response = response;
		this.cfg = cfg;
	}

	@Override
	public Template use(String name) throws IOException {
		freemarker.template.Template template = cfg.getConfiguration().getTemplate(name + ".ftl");

		return new DefaultTemplate(template, response, result);
	}

}
