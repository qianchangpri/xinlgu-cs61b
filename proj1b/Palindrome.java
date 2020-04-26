public class Palindrome{
    /*create first method to transfer word to a Deque*/
    public Deque<Character> wordToDeque(String word){
        Deque<Character> words = new LinkedListDeque<>();
        for (int i = 0; i<word.length(); i += 1) {
            words.addLast(word.charAt(i));
        }
        return words;
    }

    /*create second method for Palindrome*/
    private boolean isPalindrome(Deque<Character> words) {
        if (words.size() <= 1) {
            return true;
        } else if (words.removeFirst() == words.removeLast()) {
            return isPalindrome(words);
        } else {
            return false;
        }
    }
    public boolean isPalindrome(String word) {
        Deque<Character> words = this.wordToDeque(word);
        return isPalindrome(words);
    }

    /*create third method for Palindrome*/
    private boolean newIsPalindrome(Deque<Character> words, CharacterComparator cc) {
        if (words.size() <= 1) {
            return true;
        } else if (cc.equalChars(words.removeFirst(), words.removeLast())) {
            return newIsPalindrome(words, cc);
        } else {
            return false;
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> words = this.wordToDeque(word);
        return newIsPalindrome(words, cc);
    }
}
