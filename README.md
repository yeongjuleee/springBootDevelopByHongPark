# springBootDevelopByHongPark
### 스프링부트3 자바 백엔드 개발 입문, 홍팍 지음
#### 이 책의 SpringBoot 버전은 3.1.0 으로, 기존 3.4.1에서 3.1.0 으로 변경, 
#### dependency 버전은 기존 1.1.7을 그대로 사용 중이다.

---
~~dependency 버전도 기존 1.1.7 에서 1.1.0 으로 변경했다.~~
~~서버가 실행되지 않는 문제가 있어 다시 기존 버전 3.4.1 과 1.1.7로 바꾸어 보았다. (2025/01/09/17:09)~~
---
### part2course1 : 3장, 게시판 만들고 새 글 작성하기 Create 
#### 간단한 게시판을 만들며 데이터로 CRUD 하는 방법 알아보기 
* 게시글 생성(Create), 조회(Read), 수정(Update), 삭제(Delete) 실습 
---
#### 3.1 폼 데이터란? (98p) 
* Form Data : `HTML` 요소인 `<form>` 태그에 실려 전송되는 데이터 
* DTO : `<form>` 태그에 실어 보낸 데이터를 서버의 컨트롤러가 객체에 담는데 이 객체를 `DTO(Data Transfer Object)`라고 한다. `DTO`로 받은 데이터는 최종적으로 데이터베이스에 저장된다. 

#### 3.2.5 DTO 만들기 (104p)
```java
    // 생략
    // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가 
    public ArticleForm(Strimg title, String content) {
        this.title = title;
        this.content = content;
    }
    
    // 데이터를 잘 받았는지 확인할 toString() 메서드 
    @Override
    public ...
```
* `toString()` 메서드를 만든 이유 : 폼에서 전송한 데이터가 DTO에 잘 담겼는지 확인하기 위한 출력문(로그)을 찍기 위한 메서드. 
* 이후 `ArticleForm` 클래스의 메서드에서 `System.out.println()`을 이용하여 서버에 값이 전달됐는지 로그를 확인한다.

#### 3.2.7 입력 폼과 DTO 필드 연결하기 (109p)
* 전송한 데이터를 DTO로 받기 위해 필드 2개를 선언했고, 이 필드에 값이 들어가려면 뷰 템플릿(`new.mustache`)의 입력 폼에 필드명을 지정해줘야 값을 전달받는다. 
  * 이때 `HTML`이 서버에 값을 전달 받기 위해서는 `name` 속성을 추가하여 값을 DTO의 필드에 선언한 값과 동일하게 하면 된다.
  * Q. `id` 속성과 `name` 속성의 차이는 무엇인가요? `id` 속성은 `HTML`이 이용하는 `JavaScript` 또는 `Css`의 값을 불러올 때 사용한다. 그렇기 떄문에 서버에서 값을 전달 받으려면 `name` 속성을 이용해야 한다.

#### 3.3 DTO를 데이터베이스에 저장하기 (111p)
* 데이터베이스(DB)에 데이터를 기록하려면 JAVA 언어가 아닌 SQL(Structured Query Language) 언어를 이용해 기록해야 한다. DB는 JAVA를 이해할 수 없다.
  * Q. DB에 자바 명령을 내릴 수 있는 방법은? `JPA(Java Persistence API)`를 이용하여 자바 언어로 DB에 명령을 내리는 도구이다.
  * 엔티티(Entity) : 테이블을 만든다.
  * 리파지토리(Repository) : 엔티티가 DB 속 테이블에 저장 및 관리될 수 있게 하는 인터페이스이다.

#### 3.3.3 Repository 로 엔티티를 DB에 저장하기 (119p)
* `CrudRepository<T, ID>` : JPA에서 제공하는 인터페이스로 이것을 상속해 엔티티를 관리(생성, 조회, 수정, 삭제)할 수 있다. 
  * `<T>` : 관리 대상 엔티티의 클래스 타입으로 관리 대상 클래스명을 작성하면 된다. 
  * `<ID>` : 관리 대상 엔티티의 대푯값이다. 관리 대상 클래스의 `id`의 타입을 작성하면 된다.

* 객체 주입하기 : SpringBoot 에서는 `클래스명Impl()`와 같은 구현체(객체)를 만들지 않아도 알아서 객체를 만들 수 있다. `@Autowired` 어노테이션을 사용하면 SpringBoot 가 미리 생성한 객체를 가져와 연결해준다.
  * 이것을 의존성 주입(DI, Dependency Injection) 이라고 한다.

* 데이터 저장 확인하기 (추후에는 PostMan을 이용하여 서버의 값이 갔는지 보는 것이 더 좋다.)
  * `DTO`가 엔티티로 잘 변환되는지 `Article` 에 `toString()` 메서드를 이용하여 `ArticleController`에서 `System.out.println()`을 이용하여 로그를 찍어본다.
  * `article` 내용이 DB에 잘 저장되는지 `articleRepository`의 `saved`를 이용하여 `toString()` 메서드를 호출하고 `System.out.println()`을 이용하여 로그를 찍어본다.
  ```
    // 서버창에서 로그 확인
    1. ArticleForm{title='입력한내용', content='입력한내용'} : 폼 데이터를 받는 객체인 DTO에 값이 저장되었음을 확인할 수 있다. DTO의 클래스 타입은 ArticleForm 이다.
    2. Article{id=null, title='입력한내용', content='입력한내용'} : DTO가 엔티티로 변환되어 id=null(ArticleForm 에는 id 필드가 정의되어 있지 않음. 그래서 값이 null), title과 content에 입력한 값이 저장됐다. 엔티티의 클래스 타입은 Article이다. 
    3. Article{id=1, title='입력한내용', content='입력한내용'} : 마지막으로 repository가 엔티티를 DB에 저장해 saved라는 엔티티 변수에 반환한다. saved 변수에 저장된 결과는 title과 content는 똑같고, id는 자동으로 설정되었다. saved 변수는 엔티티 타입이고, 엔티티의 클래스 타입은 Article 이다.
  ```
