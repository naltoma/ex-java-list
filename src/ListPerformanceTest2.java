import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest2 {
    public static void main(String[] args) {
        int testSize = 100000; // 要素数
        int iterations = 1000; // テスト回数

        // リストの生成
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // 要素の追加速度テスト
        System.out.println("Adding elements...");
        measurePerformance("ArrayList Add", arrayList, testSize, (list, value) -> list.add(value));
        measurePerformance("LinkedList Add", linkedList, testSize, (list, value) -> list.add(value));

        // 要素の検索速度テスト
        System.out.println("Searching elements...");
        measureSearchPerformance("ArrayList Search", arrayList, iterations);
        measureSearchPerformance("LinkedList Search", linkedList, iterations);

        // 要素の削除速度テスト
        System.out.println("Removing elements...");
        measurePerformance("ArrayList Remove", arrayList, iterations, (list, value) -> list.remove(list.size() / 2));
        measurePerformance("LinkedList Remove", linkedList, iterations, (list, value) -> list.remove(list.size() / 2));
    }

    // パフォーマンス測定メソッド
    private static void measurePerformance(String testName, List<Integer> list, int testSize, ListOperation operation) {
        long start = System.nanoTime();
        for (int i = 0; i < testSize; i++) {
            operation.perform(list, i);
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

    // インターフェース: リスト操作
    @FunctionalInterface
    interface ListOperation {
        void perform(List<Integer> list, int value);
    }
}