package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class FreemarkerEngine implements Freemarker {

	private final HttpServletResponse response;
	private final Result result;
	private final FreemarkerConfiguration cfg;
	
	public FreemarkerEngine(Result result, HttpServletResponse response, FreemarkerConfiguration cfg) {
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
