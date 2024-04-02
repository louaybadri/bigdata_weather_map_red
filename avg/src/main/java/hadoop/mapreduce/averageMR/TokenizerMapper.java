package hadoop.mapreduce.averageMR;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TokenizerMapper
        extends Mapper<Object, Text, Text, FloatWritable> {

    private Text capital = new Text();
    private FloatWritable temperature = new FloatWritable();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] tokens = value.toString().split(",");

        if (tokens.length >= 3) { // Ensure we have at least three columns
            String capitalName = tokens[1]; // Assuming capital is the second column
            String temp = tokens[4]; // Assuming avg_temp_c is the sixth column
            try {
                float tempValue = Float.parseFloat(temp);
                capital.set(capitalName);
                temperature.set(tempValue);
                context.write(capital, temperature);
            } catch (NumberFormatException e) {
                // Handle parsing errors
            }
        }
    }
}