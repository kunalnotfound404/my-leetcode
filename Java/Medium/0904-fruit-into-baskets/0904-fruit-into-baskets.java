class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0;
        int high = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (high < n) {
            map.put(fruits[high],
                    map.getOrDefault(fruits[high], 0) + 1);

            if (map.size() <= 2) {
                count = Math.max(count, high - low + 1);
            } else {
                map.put(fruits[low], map.get(fruits[low]) - 1);

                if (map.get(fruits[low]) == 0) {
                    map.remove(fruits[low]);
                }

                low++;
            }

            high++;
        }

        return count;
    }
}