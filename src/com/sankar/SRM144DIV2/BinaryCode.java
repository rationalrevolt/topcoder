package com.sankar.SRM144DIV2;

public class BinaryCode {

    public String[] decode(String inp) {
        int[] input = toIntArray(inp);
        String[] result = new String[2];

        result[0] = decoded(0, input);
        result[1] = decoded(1, input);

        return result;
    }

    String decoded(int p0, int[] inp) {
        int[] ans = new int[inp.length];
        String answer = "";

        ans[0] = p0;
        answer += p0;

        for (int i = 1; i < inp.length; i++) {
            if (i == 1)
                ans[i] = inp[0] - ans[0];

            else if (i == 2)
                ans[i] = inp[1] - inp[0];

            else
                ans[i] = inp[i - 1] - inp[i - 2] + ans[i - 3];

            if (ans[i] < 0 || ans[i] > 1)
                return "NONE";

            answer += ans[i];
        }

        return answer;
    }

    int[] toIntArray(String inp) {
        int[] input = new int[inp.length()];
        for (int i = 0; i < inp.length(); i++) {
            input[i] = inp.charAt(i) - '0';
        }
        return input;
    }
}
