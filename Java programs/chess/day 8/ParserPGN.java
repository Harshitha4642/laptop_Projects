package chess;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ParserPGN {
	public static void makeFile(String file_path) throws IOException
	{
		String temp;
		String[] arr;
		List<String[]> moves = new ArrayList<String[]>();
		Path path = FileSystems.getDefault().getPath("", file_path);
	    BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
	    while(reader.ready())
	    {
	    	temp = reader.readLine();
	    	arr = temp.split(" ");
	    	String[] x = {arr[1],arr[2]};
	    	moves.add(x);	
	    	//System.out.println(x[0]+ "    "+x[1]);
	    } 
	}
	
	public static void main(String args[]) throws IOException
	{
		makeFile("/home/harshithams/eclipse-workspace/oops/src/chess/first_pgn");
	}
	
}
