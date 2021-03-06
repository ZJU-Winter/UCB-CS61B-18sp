/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        int length = 0;
        String[] copy = new String[asciis.length];
        System.arraycopy(asciis, 0, copy, 0, asciis.length);
        for (String string : asciis) {
            length = Math.max(length, string.length());
        }
        for (int i = length - 1; i >= 0; i -= 1) {
            sortHelperLSD(copy, i);
        }
        return copy;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        int[] counts = new int[257];
        for (String string : asciis) {
            counts[asciiAt(string, index) + 1] += 1;
        }

        int position = 0;
        int[] start = new int[257];
        for (int i = 0; i < 257; i += 1) {
            start[i] = position;
            position += counts[i];
        }

        String[] sorted = new String[asciis.length];
        for (String string : asciis) {
            int item = asciiAt(string, index) + 1;
            int place = start[item];
            sorted[place] = string;
            start[item] += 1;
        }
        System.arraycopy(sorted, 0, asciis, 0, asciis.length);
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }

    private static int asciiAt(String string, int index) {
        if (index >= string.length()) {
            return -1;
        } else {
            return (int) string.charAt(index);
        }
    }
}
