# springBootDevelopByHongPark
### 스프링부트3 자바 백엔드 개발 입문, 홍팍 지음

---
## Part2 : 3~8장(CRUD 관련)
### chapter5, 게시글 읽기: READ
* DB에 저장된 데이터를 조회해 웹 페이지에 출력하기 
---
#### 5.1 데이터 조회 과정
1. 사용자가 데이터를 조회를 URL 요청
2. 서버의 컨트롤러가 요청을 받아 해당 URL을 찾아 데이터 정보를 repository에 전달
3. 리파지토리가 정보를 가지고 DB 데이터 조회
4. DB는 해당 데이터를 찾아 엔티티로 반환
5. 엔티티는 모델을 통해 뷰 템플릿으로 전달
6. 뷰 페이지가 완성 돼 사용자의 화면에 출력
---
#### 데이터를 조회해 출력하기 위한 단계
1. `id`를 조회하여 DB에서 해당 데이터를 가져오도록 한다.
   * `Repository`를 이용하여 데이터를 가져옴. 
   * `Repository` 이용 방법 : `@Autowired` 을 이용하여 객체 주입받기 
   * `엔티티클래스` 변수 = `repository객체`.findById(`id`) 를 할 경우, `findById()`로 찾은 값을 반환할 때 반환형이 Entity가 아니라서 오류가 발생함. 
     * 이 때 반환형은 `Optional<엔티티클래스>`로 수정하면 된다. => `findById()`를 반환하려면 `Optional<클래스>`로 해야함.
2. 모델에 데이터 등록하기
   * show() 메서드의 매개변수로 model 객체를 받아오기 위해, `Model model`을 추가한다. 
   * 모델에 데이터를 등록할 때는 `addAttribute()` 메서드를 사용한다.
     * ```java
       // 형식: model.addAttribute(String name, Object value) = name 이라는 이름으로 value 객체 추가 
       model.AddAttribute("article", articleEntity); // article이라는 이름으로 articleEntity 객체 등록.
       ```
   * 가져온 데이터를 모델에 등록했으니, 사용자에게 보여줄 뷰 페이지를 반환 `return "articles/show"`
   
* ***`@PathVariable`***  : URL 요청으로 들어온 전달값을 컨트롤러의 매개변수로 가져오는 어노테이션이다.
* ***`findById()`*** : JPA의 `CrudRepository`가 제공하는 메서드로, 특정 엔티티의 id값을 기준으로 데이터를 찾아 `Optional`타입으로 반환한다.
---
#### 5.3 데이터 목록 조회하기
1. DB에서 모든 Entity 데이터 가져오기
   * `Repository`를 이용하여 데이터를 가져온다. 
   * 모든 데이터를 가져오는 메서드 : `findAll()`
   * 이때 모든 Entity는 데이터 묶음이기 때문에, `List<Entity>` 로 하여, `List<Entity> 변수명 = repository가주입된변수.findAll()`로 한다.
     * 중요한 것은 `List<객체>`가 `findAll()`의 반환의 타입과 맞지 않아 오류가 일어나는데, `findAll()`은 `Iterable`이라는 interface이다. 
       * Iterable(가장 상위의 interface) > Collection(interface) > List(interface) 순서이다.
       * 이것을 해결하기 위해서는 캐스팅(casting), 형변환을 해줘야 하는데 넓은 범위로 해석 : 업캐스팅(Upcasting) 또는 좁은 범위 해석 : 다운캐스팅(Downcasting)을 한다. 
       * 예시 : '고양이'를 생물로 해석했다면 업캐스팅, '생물'을 다시 '동물'로 해석했다면 다운캐스팅이다.
       * 따라서, `List<객체> 변수명 = (List<객체>)repository가주입된변수.findAll()`을 하면 다운 캐스팅,
       * `Iterable<객체> 변수명 = repository가주입된변수.findAll()`을 하면 업캐스팅
       * **해당 책에서는 많이 사용하는 다운 캐스팅(List 하위의 ArrayList(Class)로 변환)함.**
2. 가져온 Entity 묶음을 모델에 등록하기
3. 사용자에게 보여 줄 뷰 페이지 설정하기