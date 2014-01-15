package br.com.caelum.vraptor.freemarker;

import java.util.List;

import freemarker.cache.TemplateLoader;

public interface CustomTemplateLoaders {
	List<TemplateLoader> getTemplateLoaders();
}
