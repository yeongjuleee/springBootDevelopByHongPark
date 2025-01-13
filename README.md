# springBootDevelopByHongPark
### 스프링부트3 자바 백엔드 개발 입문, 홍팍 지음

---
## Part2 : 3~8장(CRUD 관련)
### chapter4, 롬복과 리팩터링
1. 롬복(lombok)이란? 코드를 간소화해주는 라이브러리. `getter()`, `setter()`, `constructor()` 등 개발을 할 때 필수적으로 사용하는 메서드를 반복해서 사용하지 않고 코드를 간편하게 작성할 수 있도록 하는 것 
2. 로깅(logging) : 프로그램의 수행 과정을 기록으로 남기는 것으로, log를 찍는다 와 같은 활동을 말함. `@Slf4`

* 롬복의 기능 : 코드 반복 최소화(`@Data`), 로깅 기능 지원(`@Slf4j`)
  * `@Slf4j` : Simple Logging Facade for Java의 약자로 로깅 기능을 사용할 수 있다. 
  ```java
    log.info(객체.toString()); // 주의사항 : 부르는 객체에 toString() 메서드를 담당하는 어노테이션 또는 메서드가 없으면 사용을 못 함!
  ```

3. 리팩터링(refactoring) : 코드의 기능에는 변함 없이 **코드의 구조 또는 성능을 개선하는 작업**
---
## 현재 4장 문제점
* `ArticleForm.java`과 `Article.java`에서 `@Getter`만 이용하여 값을 전달받을 수 있다고 했으나 받을 수 없었음.
* 그런 이유로 `ArticleForm.java`에 기존 추가해야하는 어노테이션 `@AllArgsConsturctor`와 `@Getter`뿐 아니라 `@NoArgsConstructor`와 `@Setter`를 추가해줬음
  * `@NoArgsConstructor` 추가 이유 : 매개변수가 없는 생성자의 값을 받아 초기화 하기 위해. `@AllArgsConstructor`만 있으면 오류 표시가 생겼음.
  * `@Setter`를 추가하지 않으면 처음, DTO 에서 부터 값을 전달받지 못하는 문제가 있어 `@Setter`를 추가해주었음. 
* `MemberForm.java`와 `Member.java` 또한 위와 같이 설정해둔 상태이다.
