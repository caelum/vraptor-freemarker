package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Vetoed;

@Vetoed
public class MockFreemarker implements Freemarker {

	@Override
	public Template use(String name) throws IOException {
		return new MockTemplate();
	}

}
