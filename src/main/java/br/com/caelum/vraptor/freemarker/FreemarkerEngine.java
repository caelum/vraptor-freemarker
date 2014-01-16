package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import freemarker.template.Configuration;

@Component
@RequestScoped
public class FreemarkerEngine implements Freemarker {

	private final HttpServletResponse response;
	private final Result result;
	private final Configuration cfg;
	
	public FreemarkerEngine(Result result, HttpServletResponse response, FreemarkerConfiguration cfg) {
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
