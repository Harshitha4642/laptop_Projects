package textProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String args[]) throws IOException
	{
		try {
		Parser parser = new Parser();
		List<String> parsedText = parser.parse("/home/harshithams/eclipse-workspace/oops/src/textProcessor/contents");
		Excecute ex = new Excecute();
		String res = ex.processText(parsedText);
		Path fileName = Path.of("/home/harshithams/eclipse-workspace/oops/src/textProcessor/textfile");
	    Files.writeString(fileName, res);
		}
		catch(Exception e)
		{}
	}

}
