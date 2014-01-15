package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

import freemarker.template.Configuration;

/**
 * A freemarker template renderer
 * 
 * @author Andrew Kurauchi
 * @author Guilherme Silveira
 *
 */
public interface Freemarker {

	Template use(String name) throws IOException;

	Template use(String name, Configuration configuration) throws IOException;

}
