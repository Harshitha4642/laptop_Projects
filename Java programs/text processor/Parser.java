package textProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Parser {
	public static String UNDO = "$";
	public static String BACK = "#";
	
	private String text;
	
	public List<String> parse(String pathOfFile) throws IOException 
	{
		Path path = FileSystems.getDefault().getPath("", pathOfFile);
		BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		
		while(reader.ready())
		{
			text = reader.readLine();
		}
		
		text = text.replace("<bksp>", BACK);
		text = text.replace("<undo>", UNDO);
		
		String arr[]=text.split("");
		List<String> list = Arrays.asList(arr);
		
		return(list);
	}	
}
