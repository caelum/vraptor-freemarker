package br.com.caelum.vraptor.freemarker;

import java.io.IOException;

import freemarker.template.TemplateException;

/**
 * A simple template to be rendered. Add the variables and then render it.
 * @author Andrew Kurauchi
 * @author Guilherme Silveira
 * @author Victor Harada
 *
 */
public interface Template {

	/**
	 * Adds a variable to the current template
	 */
	Template with(String key, Object value);

	/**
	 * Renders this template to the end user
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	void render() throws IOException, TemplateException;
	
	/**
	 * Renders this template and returns its content
	 * @throws IOException
	 * @throws TemplateException
	 */
	String getContent() throws IOException, TemplateException;

}
