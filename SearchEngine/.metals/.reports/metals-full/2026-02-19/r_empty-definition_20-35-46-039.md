error id: file:///C:/Users/User/OneDrive/Desktop/Algo-labs/Lab2/SearchEngine/AutoComplete/src/AutoComplete.java:_empty_/Term#
file:///C:/Users/User/OneDrive/Desktop/Algo-labs/Lab2/SearchEngine/AutoComplete/src/AutoComplete.java
empty definition using pc, found symbol in pc: _empty_/Term#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 118
uri: file:///C:/Users/User/OneDrive/Desktop/Algo-labs/Lab2/SearchEngine/AutoComplete/src/AutoComplete.java
text:
```scala
import java.lang.IllegalArgumentException;
import  java.util.Arrays;
public class AutoComplete {
    private final @@Term[] terms;

    public AutoComplete(Term[] terms) {
        if (terms == null) {
            throw new IllegalArgumentException();
        }

        for (Term t: terms) {
            if (t == null) {
                throw new IllegalArgumentException();
            }
        }

        this.terms = Arrays.copyOf(terms, terms.length);
        Arrays.sort(this.terms);
    }

    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException();
        } 

        if (terms.length == 0) {
            return new Term[0];
        }

        int r = prefix.length();
        Term key = new Term(prefix, 0);

        int first = BinarySearchDeluxe.firstIndexOf(terms, key, Term.byPrefixOrder(r));

        if (first == -1) {
            return new Term[0];
        }

        int last = BinarySearchDeluxe.lastIndexOf(
            terms, key, Term.byPrefixOrder(r));

        int m  = last - first + 1;
        
        Term[] matches = new Term[m];
        for (int i = 0; i < m; i++) {
            matches[i] = terms[first + 1];
        }

        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }


    public int numberOfMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException();
        }

        if (terms.length == 0) {
            return 0;
        }

        int r = prefix.length();
        Term key = new Term(prefix,0);

        int first = BinarySearchDeluxe.firstIndexOf(terms, key, Term.byPrefixOrder(r));
        if (first == -1) {
            return 0;
        } 

        int last = BinarySearchDeluxe.lastIndexOf(terms, key, Term.byPrefixOrder(r));
        return last - first + 1;

    }


    public static void main(String[] args) {
        Term[] a = {
            new Term("auto", 10),
            new Term("automobile", 5),
            new Term("automatic", 20),
            new Term("comp", 7),
            new Term("company", 15)
        };

        AutoComplete ac = new AutoComplete(a);

        Term[] res = ac.allMatches("auto");
        System.out.println("Matches for 'auto':");
        for (Term t : res) {
            System.out.println(t);
        }
        System.out.println("numberOfMatches(\"auto\") = " +
                           ac.numberOfMatches("auto"));
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Term#