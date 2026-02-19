import java.util.Comparator;

public class Term implements Comparable<Term> {
    private final String query;
    private final long weight;

    public Term(String query, long weight) {
        if (query == null || weight < 0) {
            throw new IllegalArgumentException();
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

    public static Comparator<Term> byPrefixOrder (int r) {
        if (r < 0) {
            throw new IllegalArgumentException();
        }
        return new PrefixOrder(r);
    }

    private static class PrefixOrder implements Comparator<Term> {
        private final int r;

        PrefixOrder(int r) {
            this.r = r;
        }

        public int compare(Term a, Term b) {
            int lenA = Math.min(a.query.length(), r);
            int lenB = Math.min(b.query.length(), r);
            int len = Math.min(lenA, lenB);

            for (int i = 0; i < len; i++) {
                char ca = a.query.charAt(i);
                char cb = a.query.charAt(i);

                if (ca != cb) {
                    return ca - cb;
                }
            }

            if (lenA==lenB) return 0;
            return lenA - lenB;
            
        }
    }


    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    public String toString() {
        return weight + "\t" + query;
    }



    //Testing
    public static void main(String[] args) {
        Term t1 = new Term("auto", 10);
        Term t2 = new Term("automobile", 5);
        Term t3 = new Term("automatic", 20);

        System.out.println("Natural order (lex by query):");
        System.out.println(t1.compareTo(t2)); // < 0
        System.out.println(t2.compareTo(t3)); // < 0 or > 0 depending on lex order

        System.out.println("\nBy reverse weight:");
        Comparator<Term> rw = Term.byReverseWeightOrder();
        System.out.println(rw.compare(t1, t2)); // 10 vs 5 (t1 comes first)
        System.out.println(rw.compare(t2, t3)); // 5 vs 20 (t3 comes first)

        System.out.println("\nBy prefix order (r = 3):");
        Comparator<Term> p3 = Term.byPrefixOrder(3);
        System.out.println(p3.compare(t1, t2)); // compares "aut" vs "aut" => 0

        System.out.println("\nToString examples:");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

    }
}
