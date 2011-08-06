package ext;


/**
 * Basic groovy server page extension for markdown
 * 
 * Usage: ${"**Hello** *world*".markdown().raw()}
 * 
 * @author olivier refalo
 */

import java.text.ParseException;

import markdown.Markdown;


import play.templates.JavaExtensions;

public class MarkdownExtensions extends JavaExtensions {

	public static String markdown(String mdString) {

		try {
			return Markdown.transformMarkdown(mdString);
		} catch (ParseException e) {
			return e.toString();
		}

	}

}
