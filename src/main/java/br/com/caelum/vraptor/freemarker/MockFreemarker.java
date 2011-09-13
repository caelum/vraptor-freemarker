package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

public class MockFreemarker implements Freemarker {

	@Override
	public Template use(String name) throws IOException {
		return new MockTemplate();
	}

}
