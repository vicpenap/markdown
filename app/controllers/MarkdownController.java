package controllers;


import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import markdown.Markdown;

import play.Play;
import play.mvc.Controller;

public class MarkdownController extends Controller {

	public static void transform(String page) throws Exception {

		File f = new File(Play.applicationPath, "app/views/docs/" + page
				+ ".md");
		if (!f.exists()) {
			notFound("Tutorial page for " + page + " not found");
		}
		Reader pageReader = new FileReader(page);
		String html = Markdown.transformMarkdown(pageReader);
		render(html);
	}

	public static void image(String name) {
		File image = new File(Play.applicationPath, "app/views/docs/images/"
				+ name);

		if (!image.exists()) {
			notFound();
		}
		renderBinary(image);
	}
}
