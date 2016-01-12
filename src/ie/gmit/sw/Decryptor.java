package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decryptor implements Runnable{
    
    private BlockingQueue<Resultable> queue;
    private String cypherText;
    private int key;
    private TextScorer ts;
    
    public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key, TextScorer ts){
        super();
        this.queue = queue;
        this.cypherText = cypherText;
        this.key = key;
        this.ts = ts;
    }
    
    public void run(){
        RailFence rf = new RailFence();
        String plainText = rf.decrypt(cypherText, key);
        
        //get score
        double score = ts.getScore(plainText);
        Resultable r = new Result(plainText, key, score);
        
        try {
        	System.out.println("Put in the score for the key " +key + " in the queue");
			queue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("Thread for " + key + " is done");
    }
}