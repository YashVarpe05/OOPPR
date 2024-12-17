import java.util.*;
import java.util.function.Predicate;

abstract class CollectionCounter<T> {
    public long countElements(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return 0;
        }

        return collection.stream()
                .filter(this::hasSpecificProperty)
                .count();
    }

    protected abstract boolean hasSpecificProperty(T element);
}

class EvenNumberCounter extends CollectionCounter<Integer> {
    @Override
    protected boolean hasSpecificProperty(Integer number) {
        return number % 2 == 0;
    }
}

class OddNumberCounter extends CollectionCounter<Integer> {
    @Override
    protected boolean hasSpecificProperty(Integer number) {
        return number % 2 != 0;
    }
}

class PrimeNumberCounter extends CollectionCounter<Integer> {
    @Override
    protected boolean hasSpecificProperty(Integer number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}

class PalindromeCounter extends CollectionCounter<String> {
    @Override
    protected boolean hasSpecificProperty(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}

public class TemplateMethodDemo07 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        List<String> words = Arrays.asList("level", "hello", "radar", "world", "deified");

        CollectionCounter<Integer> evenCounter = new EvenNumberCounter();
        System.out.println("Even Numbers Count: " +
                evenCounter.countElements(numbers));

        CollectionCounter<Integer> oddCounter = new OddNumberCounter();
        System.out.println("Odd Numbers Count: " +
                oddCounter.countElements(numbers));

        CollectionCounter<Integer> primeCounter = new PrimeNumberCounter();
        System.out.println("Prime Numbers Count: " +
                primeCounter.countElements(numbers));

        CollectionCounter<String> palindromeCounter = new PalindromeCounter();
        System.out.println("Palindrome Words Count: " +
                palindromeCounter.countElements(words));
    }
}