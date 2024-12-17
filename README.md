# design-pattern-practice
- 디자인 패턴 연습

## 행동 패턴

### 전략 패턴(strategy pattern)
- 알고리즘군(family of algorithms)을 정의하고 캡슐화해서 각각의 알고리즘군을 수정해서 쓸 수 있게 함
  - 전략 패턴을 사용하면 클라이언트로부터 알고리즘을 분리해서 독립적으로 변경 가능
  - (리팩토링 구루) 전략 패턴은 실제 동작은 중첩된 객체(nested object)를 호출하여 수행하고, 그 중첩된 객체를 setter를 이용해 다른 객체로 변경할 수 있는지에 의해 판별할 수 있음
- Java 실제 사용 사례
  - 리팩토링 구루(<https://refactoring.guru/design-patterns/strategy/java/example#example-0--Demo-java>)
    - Collections의 sort()로부터 호출되는 java.util.Comparator의 compare()
    - jakarta.servlet.http.HttpServlet의 service()와 HttpServletRequest와 HttpServletResponse type 객체를 argument로 받는 doXxx() 메서드들
    - jakarta.servlet.Filter의 doFilter()
    - cf. lambda function을 전략 패턴의 간단한 대안으로 사용할 수 있음 

### 옵저버 패턴(observer pattern)
- 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체에서 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many) 의존성을 정의
  - observer는 상태를 사용하지만 소유할 필요는 없음, 주제에서 상태가 바뀌었다는 사실을 알려주길 기다리므로 주제에 의존
    - 여러 객체가 동일한 데이터를 직접 제어하는 방법보다 더 깔끔한 객체지향 디자인을 만들 수 있음
  - subject는 observer 객체들의 구현 클래스는 알 필요가 없고, 자세한 코드도 알 필요가 없음
    - 새로운 형식의 observer를 추가할 때도 subject를 변경할 필요가 없음 → 독립적으로 재사용 가능
  - 두 방식 psuh vs. pull
    - push: subject의 상태가 바뀌면 subject가 observer에게 데이터를 보냄
    - pull: subject의 상태가 바뀌면 subject는 상태 변경을 observer에게 알리고, observer는 subject로부터 데이터를 가져옴
    - 일반적으로 pull 방식이 확장에 용이하기 때문에 더 나은 방식으로 여겨짐
  - cf. 출판-구독(publish-subscribe) 패턴은 observer 패턴과 유사하게 들릴 수 있지만 다른 패턴
    - pub-sub 패턴은 여러 주제와 메시지 유형이 있는 복잡한 상황, 주로 미들웨어 시스템에서 사용 
- Java 실제 사용 사례
  - 헤드퍼스트 디자인패턴 개정판 p.101
    - JDK JavaBean의 PropertyChangeListener, Java Swing 라이브러리의 JButton
    - cf. (p.104) Java 9 이후로 JDK 내장 클래스 Observable(subject 역할)과 Observer는 deprecated → 필요하면 직접 interface를 작성
    - 12장 MVC와도 연관
  - 리팩토링 구루(<https://refactoring.guru/design-patterns/observer/java/example>)
    - java.util.EventListener의 구현체 → 주로 Swing 컴포넌트들
    - javax.servlet.http.HttpSessionBindingListener, javax.servlet.http.HttpSessionAttributeListener, javax.faces.event.PhaseListener

## 기타 참고할 말들
- 소프트웨어 개발 불변의 진리: 변화(헤드퍼스트 디자인패턴 개정판, p.44)
  - 아무리 잘 디자인 된 애플리케이션이라도 시간이 지남에 따라 변화하고 성장해야 한다.

### 디자인 원칙(헤드퍼스트 디자인패턴 개정판)
- 1\. 애플리케이션에서 달라지는 부분을 찾아내고, 달라지지 않는 부분과 분리한다.(p.45)
  - 달라지는 부분을 찾아서 나머지 코드에 영향을 주지 않도록 '캡슐화'한다.
    - 그러면 코드를 변경하는 과정에서 의도치 않게 발생하는 일을 줄이면서 시스템의 유연성을 향상시킬 수 있다.
  - 바뀌는 부분은 따로 뽑아서 캡슐화한다. 그러면 나중에 바뀌지 않는 부분에는 영향을 미치지 않고 그 부분만 고치거나 확장할 수 있다.
  - 모든 디자인 패턴은 '시스템의 일부분을 다른 부분과 독립적으로 변화시킬 수 있는' 방법을 제공한다.
- 2\. 구현보다는 인터페이스에 맞춰서 프로그래밍한다.(p.46)
  - supertype에 맞춰서 프로그래밍하라.
    - 실제 실행 시에 쓰이는 객체가 코드에 고정되지 않도록 supertype에 맞춰 프로그래밍해서 다형성을 활용해야 한다.
  - 변수를 선언할 때 supertype으로 선언해야 한다. 그러면 변수를 선언하는 클래스에서 실제 객체의 type을 몰라도 된다.
- 3\. 상속보다는 구성(composition)을 활용한다.(p.59)
  - 행동을 상속받는 대신 올바른 행동 객체로 구성되어 행동을 부여받도록 한다.
    - 알고리즘군(family of algorithms)을 별도의 클래스 집합으로 캡슐화할 수 있으며,
    - 구성 요소로 사용하는 객체에서 올바른 행동 인터페이스를 구현하기만 하면 실행 시에 행동을 바꿀 수 있다.
  - 클래스 다이어그램에서 각 클래스가 "A는 B이다" 관계인지, "A에는 B가 있다" 관계인지, "A가 B를 구현"하는 관계인지 구분한다.
    - 특히 알고리즘군으로 묶을 수 있는 어떤 행동을 type으로 추출하여 "A에는 B(행동)가 있다"가 될 수 있는지 생각해보자.
- 4\. 상호작용하는 객체 사이에는 가능하면 느슨한 결합을 사용해야 한다.(p.90)
  - 객체 사이의 상호의존성을 최소화하여 한 코드를 수정할 때 다른 코드까지 수정할 필요는 없도록 유연하게 작성하는 것이 좋다. 
