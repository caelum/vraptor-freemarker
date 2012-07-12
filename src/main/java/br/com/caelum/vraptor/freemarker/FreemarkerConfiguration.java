package br.com.caelum.vraptor.freemarker;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;

@Component
@ApplicationScoped
public class FreemarkerConfiguration {

	private Configuration cfg;

	public FreemarkerConfiguration() {
		cfg = new Configuration();
		ClassTemplateLoader loader = new ClassTemplateLoader(getClass(), "/templates/");
		cfg.setTemplateLoader(loader);
		cfg.setDefaultEncoding("UTF-8");
	}

	public Configuration getConfiguration() {
		return cfg;
	}

}
