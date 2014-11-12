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
        if (inp.length == 1 && inp[0] > 0)
            return "NONE";

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

        if (inp.length > 2 && inp[inp.length - 1] != ans[inp.length - 1] + ans[inp.length - 2])
            return "NONE";

        return answer;
    }

    int[] toIntArray(String inp) {
        int[] input = new int[inp.length()];
        for (int i = 0; i < inp.length(); i++) {
            input[i] = inp.charAt(i) - '0';
        }
        return input;
    }

    public static void main(String[] args) {
        for (String s : new BinaryCode().decode("12221112222221112221111111112221111"))
            System.out.println(s);

        // M: 01101001101101001101001001001101001
        // A: 01101001101101001101001001001101001

        // M: 10110010110110010110010010010110010
        // A: 10110010110110010110010010010110010
    }
}
