package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class FileParser {
    
    public static Map<String, Double> parse(String file) throws Exception
    {
    	Map<String, Double> tempMap = new ConcurrentHashMap<String, Double>();
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    	
    	String next = null;
    	while((next = br.readLine()) !=null)
    	{
    		String [] letters = next.split(" ");
    		double frequency = Double.parseDouble(letters[1]);
    		tempMap.put(letters[0], frequency);
    	}
    	
    	br.close();
    	return tempMap;
    }
}
