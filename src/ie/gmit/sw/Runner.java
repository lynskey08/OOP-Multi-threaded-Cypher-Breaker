package ie.gmit.sw;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {

	public static void main(String[] args) throws Exception {
		String plainText;
		String gram = "4grams.txt";
		Scanner console = new Scanner(System.in);
		System.out.print("Enter Text: ");
		plainText = console.nextLine();
		
		RailFence rf = new RailFence();
		String cypherText = rf.encrypt(plainText, 4);

		
		FileParser fp = new FileParser();
		
		Map<String, Double> map = new ConcurrentHashMap<String, Double>();
		map = fp.parse(gram);
		
		TextScorer ts = new TextScorer(map);
		
		CypherBreaker cb = new CypherBreaker(cypherText, ts);
		
		

	}

}
