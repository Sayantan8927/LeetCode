class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) return triangle;

        // First row is always [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Build each row from the previous one
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();

            row.add(1); // First element is always 1

            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1); // Last element is always 1
            triangle.add(row);
        }

        return triangle;
    }
}
