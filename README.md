# Collection & Functional Promgramming & Stream Java Study

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
  
<br>
  
# 2. 함수형 프로그래밍
- 컬렉션과 스트림
  - Stream은 Collection을 대체하려고 만든 것이 아니다.
조합해서 잘 쓰면 된다.
- 다섯 형태만 기억하자
  - consumer : input만 있는 형태
  - supplier : output만 있는 형태
  - function : input/output이 모두 있는 형태
  - predict : 참/거짓을 판별하는 형태
  - runner : input/output 이 없는 형태
  
<br>

# 3. 스트림 연산과 파이프라인
- intermediate operation : return a new stream. They are always lazy; -> 리턴이 스트림이라 연속적으로 사용
  - stateless : filter, map, flatMap, peek -> 조작이 영향끼치지 않음.
  - stateful : distinct, sorted, skip, dropWhile
    - short-circuiting, limit, takeWhile
- terminal operation -> 스트림이 종료됨.
  - forEach, forEachOrdered, toArray, reduce, collect, toList, min, max, count
  - short-circuiting : anyMatch, allMatch, noneMatchj, findFirst, findAny

```java
int sum = widgets.stream()
                      .filter(w -> w.getColor() == RED)
                      .mapToInt(w -> w.getWeight())
                      .sum();
```

# 3-1. 스트림 필수 유틸 클래스 : Collectors
```java
 // Accumulate names into a List
 List<String> list = people.stream()
   .map(Person::getName)
   .collect(Collectors.toList());

 // Accumulate names into a TreeSet
 Set<String> set = people.stream()
   .map(Person::getName)
   .collect(Collectors.toCollection(TreeSet::new));

 // Convert elements to strings and concatenate them, separated by commas
 String joined = things.stream()
   .map(Object::toString)
   .collect(Collectors.joining(", "));

 // Compute sum of salaries of employee
 int total = employees.stream()
   .collect(Collectors.summingInt(Employee::getSalary));

 // Group employees by department
 Map<Department, List<Employee>> byDept = employees.stream()
   .collect(Collectors.groupingBy(Employee::getDepartment));

 // Compute sum of salaries by department
 Map<Department, Integer> totalByDept = employees.stream()
   .collect(Collectors.groupingBy(Employee::getDepartment,
            Collectors.summingInt(Employee::getSalary))
            );

 // Partition students into passing and failing
 Map<Boolean, List<Student>> passingFailing = students.stream()
   .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
```