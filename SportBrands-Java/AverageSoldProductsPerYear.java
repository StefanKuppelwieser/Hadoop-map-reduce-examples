import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class AverageSoldProductsPerYear extends Configured implements Tool{
  public static class MapClass extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text>{
    private Text brand = new Text();
    private Text rating = new Text();

    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException{
      String[] split = value.toString().split("\t");

		try{
			String brand_temp = split[0];
			String city = split[2];
			String state = split[3];

			brand.set(brand_temp);
			rating.set(city + "\t" + state); 
			output.collect(brand, rating);
		} catch (Exception e){
			output.collect(brand, new Text ("1"));
		}
      
    }
  }

  public static class Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text>
  {
    @Override
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException{
		
		int current_year = Calendar.getInstance().get(Calendar.YEAR);
		
		while(values.hasNext()){
			
			String tokens[] = (values.next().toString()).split("\t");
			
			int allSoldProducts = Integer.parseInt(tokens[0]);
			int year = Integer.parseInt(tokens[1]);
			
			int compan_years = current_year - year;
			int product_per_years = allSoldProducts / compan_years;
			
			
			output.collect(key, new Text(compan_years + "\t" + product_per_years));
		}
    }
  }

  
  static int printUsage(){
    System.out.println("MarketRatings [-m <maps>] [-r <reduces>] <input> <output>");
    return 0;
  }

  @Override
  public int run(String[] args) throws IOException
  {
    return 0;
  }
  

  public static void main(String[] args) throws IOException{
    JobConf conf = new JobConf(AverageSoldProductsPerYear.class);
    conf.setJobName("Average sold products per year");

    conf.setOutputKeyClass(Text.class);
    conf.setOutputValueClass(Text.class);

    conf.setMapperClass(MapClass.class);
    conf.setReducerClass(Reduce.class);

    conf.setInputFormat(TextInputFormat.class);
    conf.setOutputFormat(TextOutputFormat.class);

    FileInputFormat.setInputPaths(conf, new Path(args[0]));
    FileOutputFormat.setOutputPath(conf, new Path(args[1]));

    JobClient.runJob(conf);
  }
}