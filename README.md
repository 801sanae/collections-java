# Collection & Stream Java Study

# 1. Collection

- 배열 : 크기 고정. 가장 단순한 형태
- Iterable : 순차 열람을 지원하는 컬렉션
- Collection : 원소 추가, 제거 기능
  - ArrayList : 기본 구현체이다.
- List : 원소의 순서가 있으며, 위치 정보(index)를 통해 접근 가능
  - ArrayList : 원소 검색시 장점이 있다
  - LinkedList : 원소 수정시 장점이 있다.
- Set : 중복된 원소가 없는 컬렉션
  - HashSet : 빠르지만 순서는 보장하지 않는다
  - LinkedHashSet : 순서를 보장하지만 조금 느리다
  - TreeSet : 원소를 정렬해주지만 수정시 logN에 비례한다.
- SortedSet : 중복 원소가 없으면서 원소간 순서가 정해진 컬렉션
- Map : 키(key)에 의해 원소에 접근
  - HashMap: 빠르지만 순서는 보장하지 않는다
  - LinkedHashMap : 원소간 순서를 보장한다
  - TreeMap : 키에 따라 순차열람이 가능하지만 수정시 logN에 비례한다.
  
# 2. Stream
- 컬렉션과 스트림
  - Stream은 Collection을 대체하려고 만든 것이 아니다.
조합해서 잘 쓰면 된다.
- 다섯 형태만 기억하자
  - consumer : input만 있는 형태
  - supplier : output만 있는 형태
  - function : input/output이 모두 있는 형태
  - predict : 참/거짓을 판별하는 형태
  - runner : input/output 이 없는 형태
