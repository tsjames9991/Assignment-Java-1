import org.knoldus.*;

public class Operations {
    public static void main(String[] args) {
        WordCount wc = new WordCount();
        Movie movie = new Movie();
        int[] list1 = new int[]{1, 2, 3, 4, 5};
        int[] list2 = new int[]{5, 4, 3, 2, 1};
        MathFunctions operation = new MathFunctions();
        System.out.println("1. Find Primes Between 1 to 100");
        operation.findPrimes().forEach(System.out::println);
        System.out.println("\n2. Get Word Count From File");
        wc.findWordsCountInFile();
        System.out.println("\n3. Get Word Count From A Sentence");
        wc.wordCountInSentence("You can’t, if you can’t feel it, if it never" +
                "Rises from the soul, and sways" +
                "The heart of every single hearer" +
                "With deepest power, in simple ways" +
                "You’ll sit forever, gluing things together" +
                "Cooking up a stew from other’s scraps" +
                "Blowing on a miserable fire" +
                "Made from your heap of dying ash" +
                "Let apes and children praise your art" +
                "If their admiration’s to your taste" +
                "But you’ll never speak from heart to heart" +
                "Unless it rises up from your heart’s space");
        System.out.println("\n4. Multiply Two Lists");
        int[] result = operation.multiplyTwoLists(list1, list2);
        for (int number : result) {
            System.out.println(number);
        }
        System.out.println("\n5. Movies With Rating More Than 8 And Genre Comedy");
        movie.filterGenreWithRating("Comedy", 8);
        System.out.println("\n6. Movies With Release Year More Than 2000 And Rating Less Than 8");
        movie.filterYearWithRating(2000, 8);
        System.out.println("\n5. Movies With Rating As An Even Number");
        movie.filterAsEvenRating();
        System.out.println("\n5. Movies With Rating Equal To 7 And Genre Sci Fi");
        movie.filterGenreWithRating("Sci Fi", 7);
    }
}