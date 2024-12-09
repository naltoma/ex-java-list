## ArrayList vs LinkedList

### コード
- `ListPerformanceTest.java`: 通常の実装。
- `ListPerformanceTest2.java`: ラムダ式を用いた実装（少し実装が短くなる）。
- コード補足
    - [System.nanoTime()](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#nanoTime())で現在時刻取得。
    - [Javaのラムダ式とは？ラムダ式のメリットや使い方を解説](https://www.bold.ne.jp/engineer-club/java-lambda-expression)

### 検証内容
- 追加操作:
    - ArrayListは末尾への追加が高速（定数時間）。サイズ変更が必要になると再配置のため時間がかかる。
    - LinkedListはリストの末尾に追加する場合でもリンクを更新する必要があるためやや遅い。
- 検索操作:
    - ArrayListはインデックスを直接使えるため高速。
    - LinkedListは線形探索が必要で遅い。
- 削除操作:
    - ArrayListは削除後にシフト操作が発生するため、中央付近の削除が遅い。
    - LinkedListはリンクを更新するだけで済むため、特定のノードの削除は高速。
