package Lab6;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class InverseDocumentFrequencyCalculator implements IInverseFreq {

    @Override
    public TreeMap<String, Double> getInverseDocumentFrequency(TreeMap<String, String> songLyrics) {
        TreeMap<String, Double> result = new TreeMap<String, Double> ();
        
        for(String songTitle: songLyrics.keySet())
        {
            // current lyrics
            String lyric = songLyrics.get(songTitle);
            String[] words = lyric.split(" ");
            
            
            // Calculate the Inverse Document Frequency (IDF) Values here
            // You might need to introduce other methods and additional variables
            
            // IDF for term X is calculated as ln of (N-n(X)+0.5)/(n(X)+0.5) plus 
            // where N is total number of songs
            // and n(X) is the number of songs having term X
            
            ////////////////////////////
            //WRITE HERE
            //////////////////////////
            int n = 0;
            int N = songNum(songLyrics);
            Set<String> songs = songLyrics.keySet();
            Iterator<String> itr = songs.iterator();
            //find number of times X is repeated; iterates through list of words
            for(int i = 0; i < words.length; i++) {
                //iterates through all songs in treemap
                for(int j = 0; j < N; j++) {
                    if(itr.next().contains(words[i])) {
                        n++;
                    }
                }
                //find frequency by breaking up equation into smaller parts
                double innerE = (N - n + 0.5)/(n + 0.5) + 1;
                double outerE = Math.log(innerE);
                //add to result tree
                result.put(words[i], outerE);
            }          
        }  
        return result;
    }
    
    //find number of songs (N)
    public static int songNum(TreeMap<String, String> songLyrics) {
        int count = 0;
        if(!songLyrics.isEmpty()) {
            for(int i = 0; i < songLyrics.size(); i++) {
                count++;
            }
        } 
        return count;
    }
}
