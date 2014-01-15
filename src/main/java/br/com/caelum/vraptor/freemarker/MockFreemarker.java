package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

import freemarker.template.Configuration;

public class MockFreemarker implements Freemarker {

	@Override
	public Template use(String name) throws IOException {
		return new MockTemplate();
	}

	@Override
	public Template use(String name, Configuration configuration)
			throws IOException {
		return use(name);
	}

}
