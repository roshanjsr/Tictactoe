package rkum;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class StringValueWritable implements Writable {
	    private String first;
	    //private double second;

	    public  StringValueWritable() {
	        set(first);
	    }
	    public  StringValueWritable(String first) {
	        set(first);
	    }
	    public void set(String first) {
	        this.first = first;
	    }
	    public String getFirst() {
	        return first;
	    }
	    
	    @Override
	    public void write(DataOutput out) throws IOException {
	        out.writeChars(first);
	    }
	    @Override
	    public void readFields(DataInput in) throws IOException {
	        first = in.readUTF().toString();
	    }

	    @Override
	    public String toString() {
	        return first;
	    }
}
