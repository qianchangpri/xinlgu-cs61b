import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /* You must use this palindrome, and not instantiate
     new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("dad"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("Dad"));
        assertFalse(palindrome.isPalindrome("Daad"));
    }

    @Test
    public void testNewIsPalindrome() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("zbcy", cc));
        assertTrue(palindrome.isPalindrome("%&", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertFalse(palindrome.isPalindrome("dad", cc));
        assertFalse(palindrome.isPalindrome("Flake", cc));
    }
}
