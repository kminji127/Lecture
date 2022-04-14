import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCheck {

	public static void main(String[] args) throws FileNotFoundException {
		
		Set<String> dictionaryWords = readWords("src/words.txt");
		Set<String> documentWords = readWords("src/test.txt");
		
		for(String word : documentWords)
		{
			if(!dictionaryWords.contains(word))
				System.out.println(word);
		}

	}
	
	public static Set<String> readWords(String filename) throws FileNotFoundException {
		Set<String> words = new HashSet<String>();
		Scanner in = new Scanner(new File(filename));
		
		in.useDelimiter("[^a-zA-Z]+");
		while(in.hasNext())
			words.add(in.next().toLowerCase());
		
		return words;
	}

}
