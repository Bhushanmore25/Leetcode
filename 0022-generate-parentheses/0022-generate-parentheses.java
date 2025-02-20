class Solution {
    public static void generate(List<String> ans, StringBuilder sb, int open, int closed, int n) {
        if (open == n && closed == n) {
            ans.add(sb.toString()); 
            return;
        }
        if (open < n) {
            sb.append("(");
            generate(ans, sb, open + 1, closed, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closed < open) {
            sb.append(")");
            generate(ans, sb, open, closed + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> li = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(li, sb, 0, 0, n);
        return li;
    }
}