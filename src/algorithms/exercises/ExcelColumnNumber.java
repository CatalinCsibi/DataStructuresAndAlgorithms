package algorithms.exercises;

public class ExcelColumnNumber {

/*  Excel Sheet Column Number
    Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

    For example:

    A -> 1
    B -> 2
    C -> 3
            ...
    Z -> 26
    AA -> 27
    AB -> 28
            ...


    Example 1:

    Input: columnTitle = "A"
    Output: 1
    Example 2:

    Input: columnTitle = "AB"
    Output: 28
    Example 3:

    Input: columnTitle = "ZY"
    Output: 701


    Constraints:

    1 <= columnTitle.length <= 7
    columnTitle consists only of uppercase English letters.
    columnTitle is in the range ["A", "FXSHRXW"].*/

    public static void main(String[] args) {
        excelColumnNumber("ZY");
    }

    private static void excelColumnNumber(String columnTitle) {
        if (columnTitle.isEmpty() || columnTitle.length() > 7 || !columnTitle.equals(columnTitle.toUpperCase()))
            throw new IllegalArgumentException();

        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int value = c - 'A' + 1; // 'A' = 1, ..., 'Z' = 26
            result = result * 26 + value;
        }
        System.out.println(result);
    }
}
