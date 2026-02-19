import java.util.Comparator;

public class BinarySearchDeluxe {
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new IllegalArgumentException();
        }

        int lo = 0;
        int hi = a.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = comparator.compare(a[mid], key);

            if (cmp < 0) {
                lo = mid  + 1;
            } else if (cmp > 0) {
                hi = mid - 1;
            } else {
                result = mid;
                hi = mid - 1;
            }
        }
        return result;
    }

    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new IllegalArgumentException();
        }

        int lo = 0;
        int hi = a.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) /2;
            int cmp = comparator.compare(a[mid], key);

            if (cmp < 0) {
                lo = mid + 1;
            } else if (cmp > 0) {
                hi = mid - 1;

            } else {
                result = mid;
                lo = mid + 1;
            }
        }
        return result;
    }

     // simple unit testing
    public static void main(String[] args) {
        // Example with Integer
        Integer[] a = {1, 2, 2, 2, 3, 4, 4, 5};
        Comparator<Integer> cmp = Integer::compareTo;

        System.out.println(firstIndexOf(a, 2, cmp)); // 1
        System.out.println(lastIndexOf(a, 2, cmp));  // 3
        System.out.println(firstIndexOf(a, 4, cmp)); // 5
        System.out.println(lastIndexOf(a, 4, cmp));  // 6
        System.out.println(firstIndexOf(a, 6, cmp)); // -1
    }
}
