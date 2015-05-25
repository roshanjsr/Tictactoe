package rkum;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, Text, NullWritable, Text>{
	public void reduce(Text key, Iterable<Text> values, Context context)
		throws IOException, InterruptedException {
		
		String result = "";
		for(Text iw:values)
		{
			if(result.length()!=0)
				result= result + ",";
			result = result + iw.toString();
				System.err.println("RKUMLOG:This is a log.");
		}
		context.write(NullWritable.get(),new Text(result));
	}
}