package serverside;

public class SentenceProcessor {
	
	private int size = 65535;
	
	private String sentence;
	
	
	public SentenceProcessor(byte[] byteData) {
		
		this.sentence = new String(byteData);
	}
	
	public String getSentence() {
		
		return sentence;
	}
	
	/**
	 * This method convert value into an array of byte
	 * @param length
	 * @return
	 */
	public byte[] convertToByteArray(int value) {
		
		byte[] outData = new byte[size];
		
		String stringValue = Integer.valueOf(value).toString();
		
        outData = stringValue.getBytes();
        
        return outData;
	}
	
	/**
	 * This method count the number of characters in a sentence
	 * @return
	 */
	public int countCharacters() {
		
        int index = 0;
        char currentChar = sentence.charAt(index);
        while (currentChar != '\0') {
        	
        	currentChar = sentence.charAt(index++);
        }
        

        return index - 1;
	}
	
	/**
	 * This method count the number of punctions in a sentence
	 * @return
	 */
	
	public int countPunctions() {
		// Count the number of punctuation in the message
        int punctuations = 0;
        for (char character : sentence.toCharArray()) {
            if (character == '.' || character == ',' || character == ';' || character == ':' || character == '!' ||
                character == '?' || character == '-' || character == '_' || character == '"' || character == '\'') {
                punctuations++;
            }
        }
		return punctuations -1;
	}
	
	/**
	 * This method count the number of vowels in a sentence
	 * @return
	 */
	
	public int countVowels() {
		// Count the number of vowels in the message
        int vowels = 0;
        for (char character : sentence.toCharArray()) {
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u' ||
                character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U') {
                vowels++;
            }
		
	}
		return vowels -1;
}
	
	/**
	 * This method count the number of constants in a sentence
	 * @return
	 */
	
	public int countConstants() {
		// Count the number of constants in the message
        int constants = 0;
        for (char character : sentence.toCharArray()) {
            if (character == 'b' || character == 'c' || character == 'd' || character == 'f' || character == 'g' ||
                    character == 'h' || character == 'j' || character == 'k' || character == 'l' || character == 'm' ||
                    character == 'n' || character == 'p' || character == 'q' || character == 'r' || character == 's' ||
                    character== 't' || character == 'v' || character == 'w' || character == 'x' || character == 'y' ||
                    character == 'z' || character == 'B' || character == 'C' || character == 'D' || character == 'F' ||
                    character == 'G' || character == 'H' || character == 'J' || character == 'K' || character == 'L' ||
                    character == 'M' || character == 'N' || character == 'P' || character == 'Q' || character == 'R' ||
                    character == 'S' || character == 'T' || character == 'V' || character == 'W' || character == 'X' ||
                    character == 'Y' || character == 'Z') {
                constants++;
            }
	}
		return constants -1;
}
}
