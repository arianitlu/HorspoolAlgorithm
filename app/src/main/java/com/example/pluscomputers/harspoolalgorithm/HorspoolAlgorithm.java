package com.example.pluscomputers.harspoolalgorithm;

public class HorspoolAlgorithm {

    public static int SIZE = 500;
    public static int table[] = new int[500];

    public void shifttable(String pattern) {

        int i, j, m;
        char p[] = pattern.toCharArray();
        m = pattern.length();

        for (i = 0; i < SIZE; i++)
            table[i] = m;
        for (j = 0; j < m; j++)
            table[p[j]] = m - 1 - j;
    }

    public int horspool(String source, String pattern) {
        int i, k, pos, m;
        char s[] = source.toCharArray();
        char p[] = pattern.toCharArray();
        m = pattern.length();

        for (i = m - 1; i < source.length(); ) {
            k = 0;
            while ((k < m) && (p[m - 1 - k] == s[i - k]))
                k++;
            if (k == m) {
                pos = i - m + 2;
                return pos;
            } else
                i += table[s[i]];
        }
        return 0;
    }
}
