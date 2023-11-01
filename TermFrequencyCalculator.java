package Lab6;

import java.util.TreeMap;

/**
 * TermFrequencyCalculator -- Calculates the frequency in which words appear throughout their respective
 * songs and maps the word to this value.
 * @author nathanielserrano
 *
 */
public class TermFrequencyCalculator implements ITermFrequency {

    @Override
    public TreeMap<String, TreeMap<String, Double>> getTermFrequency(TreeMap<String, String> songLyrics) {
        TreeMap<String, TreeMap<String, Double>> result = new TreeMap<String, TreeMap<String, Double>> ();
        
        for(String songTitle: songLyrics.keySet())
        {
            // For each song you have to create TF values
            TreeMap<String, Double> tempMap = new TreeMap<String, Double>();

            // current lyrics
            String lyric = songLyrics.get(songTitle);
            String[] words = lyric.split(" ");
            
            // Calculate the Term Frequency (TF) Values here and save them in tempMap
            for (String word: words) {
            	int localFreq = calcFreq(word, words);
            	double termFreq = (localFreq * (2.2))/(localFreq + (1.2*(0.25+0.75*(words.length/calcAvg(songLyrics)))));
            	tempMap.put(word, termFreq);
            }
            
            // You might need to introduce other methods and additional variables
            
            // TF for Term (word) X in Song S is calculated as 
            // f(X,S) . (2.2) / (f(X,S) + 1.2 . (0.25+0.75 .|S|/AvgS)
            // where f(X,S) is the frequency of term X in song S
            // |S| is the length of song in terms of number of words
            // AvgS is the average length of songs based on number of words
            
            ////////////////////////////
            //WRITE HERE
            //////////////////////////
            
            
            
            // After Calculaion
            result.put(songTitle, tempMap);
        }
        
        
        return result;
    }
    
    /**
     * calcFreq - Helper method to count the total appearances of a word in an Array of words
     * @param word - String
     * @param words - Array of Strings
     * @return count - int
     */
    private int calcFreq(String word, String[] words) {
    	int count = 0;
    	for (String current: words) {
    		if (current.equals(word))
    			count++;
    	}
    	return count;
    }
    
    /**
     * calcAvg - Helper method to calculate the average number of words across treeMap of songs
     * @param songLyrics - TreeMap<String, String>
     * @return avg - double
     */
    private double calcAvg(TreeMap<String, String> songLyrics) {
    	double total=0.0;
        for (String songTitle: songLyrics.keySet()) {
        	  String lyric = songLyrics.get(songTitle);
              String[] words = lyric.split(" ");
              total +=words.length;
        }
        double avg = total/songLyrics.size();
        return avg;
    }

}
