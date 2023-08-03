package programmers.lv2.스킬트리;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            int tmp = 0;
            String tree = skill_trees[i];
            boolean wrong = false;
            for (int j = 0; j < tree.length(); j++) {
                if (tmp == skill.length()) {
                    answer++;
                    wrong = true;
                    break;
                }
                if (skill.charAt(tmp) == tree.charAt(j)) {
                    tmp++;
                    continue;
                } else {
                    for (int k = tmp; k < skill.length(); k++) {
                        if (skill.charAt(k) == tree.charAt(j)) {
                            wrong = true;
                            break;
                        }
                    }
                    if (wrong) {
                        break;
                    }
                }
            }
            if (!wrong) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        sol.solution(skill, skill_trees);
    }
}