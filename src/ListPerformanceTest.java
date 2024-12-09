import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {
    public static void main(String[] args) {
        int testSize = 100000; // 要素数
        int iterations = 1000; // テスト回数

        // リストの生成
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // 要素の追加速度テスト
        System.out.println("Adding elements...");
        measurePerformanceAdd("ArrayList Add", arrayList, testSize);
        measurePerformanceAdd("LinkedList Add", linkedList, testSize);

        // 要素の検索速度テスト
        System.out.println("Searching elements...");
        measureSearchPerformance("ArrayList Search", arrayList, iterations);
        measureSearchPerformance("LinkedList Search", linkedList, iterations);

        // 要素の削除速度テスト
        System.out.println("Removing elements...");
        measurePerformanceRemove("ArrayList Remove", arrayList, iterations);
        measurePerformanceRemove("LinkedList Remove", linkedList, iterations);
    }

    // 要素追加のパフォーマンス測定メソッド
    private static void measurePerformanceAdd(String testName, List<Integer> list, int testSize) {
        long start = System.nanoTime();
        for (int i = 0; i < testSize; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.println(testName + " took " + (end - start) / 1_000_000.0 + " ms");
    }

    // 要素削除のパフォーマンス測定メソッド
    private static void measurePerformanceRemove(String testName, List<Integer> list, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            if (!list.isEmpty()) {
                list.remove(list.size() / 2); // 中央の要素を削除
            }
        }
        long end = System.nanoTime();
        System.out.println(testName + " took " + (end - start) / 1_000_000.0 + " ms");
    }

    // 検索パフォーマンス測定メソッド
    private static void measureSearchPerformance(String testName, List<Integer> list, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.contains((int) (Math.random() * list.size()));
        }
        long end = System.nanoTime();
        System.out.println(testName + " took " + (end - start) / 1_000_000.0 + " ms");
    }
}