package lab1;

import java.util.Comparator;

public class CompareTwo implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < o1.length(); ++i) {
            if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9')
                sum1 += o1.charAt(i) - '0';
        }
        for (int i = 0; i < o2.length(); ++i) {
            if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9')
                sum2 += o2.charAt(i) - '0';
        }
        int res = 0;
        if (sum1 > sum2) res = 1;
        else  if (sum1 < sum2) res = -1;
        return res;
    }
}
