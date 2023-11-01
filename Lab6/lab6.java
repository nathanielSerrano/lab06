package Lab6;

import java.io.IOException;

public class lab6 {

	public static void main(String[] args) {
		LyricsReader lyricsChecker = null;
		try {
			lyricsChecker = new LyricsReader("/Users/nathanielserrano/Downloads/Queen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ITermFrequency termChecker = new TermFrequencyCalculator();
		IInverseFreq inverseChecker = new InverseDocumentFrequencyCalculator();
		SearchEngine test = new SearchEngine(lyricsChecker, termChecker, inverseChecker);
		System.out.println(test.search("All we hear is"));
		
	}

}
