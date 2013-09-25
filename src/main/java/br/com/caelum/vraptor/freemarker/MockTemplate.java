package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Vetoed;

import freemarker.template.TemplateException;

@Vetoed
public class MockTemplate implements Template {

	@Override
	public Template with(String key, Object value) {
		return this;
	}

	@Override
	public void render() throws IOException, TemplateException {
		// Does nothing
	}

	@Override
	public String getContent() throws IOException, TemplateException {
		return "are you mocking me?";
	}

}
