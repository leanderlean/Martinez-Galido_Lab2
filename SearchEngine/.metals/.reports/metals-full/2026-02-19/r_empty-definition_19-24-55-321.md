error id: file:///C:/Users/User/OneDrive/Desktop/Algo-labs/Lab2/SearchEngine/AutoComplete/src/Term.java:
file:///C:/Users/User/OneDrive/Desktop/Algo-labs/Lab2/SearchEngine/AutoComplete/src/Term.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 919
uri: file:///C:/Users/User/OneDrive/Desktop/Algo-labs/Lab2/SearchEngine/AutoComplete/src/Term.java
text:
```scala
import java.util.Comparator;

public class Term implements Comparable<Term> {
    private final String query;
    private final long weight;

    public Term(String query, long weight) {
        if (query == null || weight < 0) {
            throw new IllegalArgumentException()
        }

        this.query = query;
        this.weight = weight;
    }

    public static Comparator<Term> byReverseWeightOrder() {
        return new ReverseWeightOrder();
    }

    private static class ReverseWeightOrder implements Comparator<Term> {
        public int compare (Term a, Term b) {
            return Long.compare(b.weight, a.weight);
        }
    }

    private static class PrefixOrder implements Comparator<Term> {
        private final int r;

        PrefixOrder(int r) {
            this.r = r;
        }

        public int compare(Term a, Term b) {
            int lenA = Math@@
        }
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 