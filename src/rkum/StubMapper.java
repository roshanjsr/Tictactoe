package rkum;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;


public class StubMapper extends Mapper<Object, Text, Text, Text>{
    
	@Override
	public void map(Object key, Text value, Context context)
	throws IOException, InterruptedException {
	
	//Split the lines into words with spaces or tabs as separators
	String[] words = value.toString().split("[ \t]+");
	for(String originalWord:words)
	{
		//Remove all alphanumeric characters
		originalWord = originalWord.replaceAll("[^a-zA-Z0-9]","");
		
		//Convert the words to lower case
		//word = word.toLowerCase();
	
		char[] chars = originalWord.toCharArray();
		Arrays.sort(chars);
		String sortedWord= new String(chars);
		context.write(new Text(sortedWord), new Text(originalWord));
		System.err.println("RKUMLOG:This is a mapper.");
	}
	}
}