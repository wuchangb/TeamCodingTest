package fastcampus_codingtest.firstTest.no3;

public class Solution2 {
    public int solution(String s) {

        int num = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.contains("aa") ||
                    s.contains("bb") ||
                    s.contains("cc") ||
                    s.contains("dd") ||
                    s.contains("ee") ||
                    s.contains("ff") ||
                    s.contains("gg") ||
                    s.contains("hh") ||
                    s.contains("ii") ||
                    s.contains("jj") ||
                    s.contains("kk") ||
                    s.contains("ll") ||
                    s.contains("mm") ||
                    s.contains("nn") ||
                    s.contains("oo") ||
                    s.contains("pp") ||
                    s.contains("qq") ||
                    s.contains("rr") ||
                    s.contains("ss") ||
                    s.contains("tt") ||
                    s.contains("uu") ||
                    s.contains("vv") ||
                    s.contains("ww") ||
                    s.contains("xx") ||
                    s.contains("yy") ||
                    s.contains("zz")
            ) {
                s.replace("aa", "");
                s.replace("bb", "");
                s.replace("cc", "");
                s.replace("dd", "");
                s.replace("ee", "");
                s.replace("ff", "");
                s.replace("gg", "");
                s.replace("hh", "");
                s.replace("ii", "");
                s.replace("jj", "");
                s.replace("kk", "");
                s.replace("ll", "");
                s.replace("mm", "");
                s.replace("nn", "");
                s.replace("oo", "");
                s.replace("pp", "");
                s.replace("qq", "");
                s.replace("rr", "");
                s.replace("ss", "");
                s.replace("tt", "");
                s.replace("uu", "");
                s.replace("vv", "");
                s.replace("ww", "");
                s.replace("xx", "");
                s.replace("yy", "");
                s.replace("zz", "");
            }
        }
        if (s.length() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
