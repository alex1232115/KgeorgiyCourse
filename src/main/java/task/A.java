package task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class A {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(task(new double[]{-1, 2,1,4,2,3})));
    }

    public static double[] task(double[] a){
        Map<Double, Integer> digitIndex = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                throw new IllegalStateException("Element less than 0");
            }

            if (!digitIndex.containsKey(a[i])) {
                digitIndex.put(a[i], i);
            } else {
                int index = digitIndex.get(a[i]);
                a[index] = -1;
                digitIndex.put(a[i], i);
            }
        }
        return Arrays.stream(a).filter(x -> x > -1).distinct().toArray();
    }
}
/*
    select t1.*
        from Table1 t1
        where not exists (
        select t2.*
        from Table2 t2
        where t1."id" = t2."id"
        and t1."NAME" = t2."NAME"
        )

        select distinct t1.*
        from Table1 t1
        inner join Table2 t2 on t1."id" = t2."id" and t1."NAME" = t2."NAME"
*/