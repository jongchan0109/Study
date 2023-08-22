## Chapter10 정렬(Sorting)
### 1.단순한 정렬 알고리즘
+ 버블 정렬(Bubble Sort)
  + 인접한 두 개의 데이터를 비교해가면서 정렬을 진행하는 방식
  + 시간 복잡도: O(n^2)
+ 선택 정렬(Selection Sort)
  + 정렬 순서상 가장 앞서는 것을 선택해서 가장 왼쪽으로 이동시키고, 원래 그 자리에 있던 데이터는 빈 자리에 가져다 놓음
  + 시간 복잡도: O(n^2)
+ 삽입 정렬(Insertion Sort)
  + 정렬 안 된 부분에 있는 데이터를 정렬 된 부분의 특정 위치에 삽입해 가면서 정렬을 진행하는 방식
  + 시간 복잡도: O(n^2)

### 2. 복잡하지만 효율적인 정렬 알고리즘
+ 힙 정렬(Heap Sort)
  + 힙의 루트노드에 저장된 값이 정렬순서상 가장 앞선 것을 나타내도록 하면, 쉽게 정렬을 할 수 있다.
  + 시간 복잡도: O(nlogn)
+ 병합 정렬(Merge Sort)
  + 병합 정렬은 '분할 정복(divide and conquer)'이라는 알고리즘 디자인 기법에 근거하여 만들어진 정렬 방법이다.
  + 분할 정복이란, 말 그대로 복잡한 문제를 복잡하지 않은 문제로 '분할'하여 '정복'하는 방법이다. 단, 분할해서 정복했으니 정복한 후에는 '결합'의 과정을 거쳐야 한다.
  + 시간 복잡도: O(nlogn)

+ 퀵 정렬(Quick Sort)
  + 퀵 정렬도 병합 정렬과 마찬가지로 '분할 정복'에 근거하여 만들어진 정렬 방법이다.
  + 시간 복잡도: O(n^2) // 최악의 경우
  + 시간 복잡도: O(nlogn) // 평균적인 경우
    
+ Code
  + SimpleSort
    + BubbleSort.c
    + SelectionSort.c
    + InsertionSort.c
  + HeapSort
    + UsefulHeap.h
    + UsefulHeap.c
    + HeapSort.c
  + CompleSort
    + MergeSort.c
    + QuickSort.c
