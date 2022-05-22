//https://leetcode.com/problems/prison-cells-after-n-days/
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        ArrayList<String> list = new ArrayList<>();

        String str = intArrayToString(cells);
        String next = null;
        boolean hasCycle = false;

        for (int i = 0; i < n; i++) {
            next = calculateNextday(str);
            if (!list.contains(next)) {
                list.add(next);
                str = next;
            } else {
                hasCycle = true;
                break;
            }
        }

        int idx = list.indexOf(next);
        int res = 0;
        if (hasCycle) {
            int cycle = list.size() - idx;
            int mod = (n - idx) % cycle;

            res = (mod - 1 >= 0 ? mod - 1 : cycle - 1) + idx;
        } else {
            res = idx;
        }


        int ints[] = new int[8];
        for (int i = 0; i < 8; i++) {
            ints[i] = list.get(res).charAt(i) - '0';
        }

        return ints;
    }

    String calculateNextday(String today) {
        StringBuilder nextDay = new StringBuilder("00000000");
        for (int j = 1; j < 7; j++) {
            nextDay.setCharAt(j, today.charAt(j - 1) == today.charAt(j + 1) ? '1' : '0');
        }

        return nextDay.toString();
    }

    String intArrayToString(int[] ints) {
        StringBuilder str = new StringBuilder("00000000");
        for (int i = 0; i < 8; i++) {
            str.setCharAt(i, ints[i] == 1 ? '1' : '0');
        }

        return str.toString();
    }
}
