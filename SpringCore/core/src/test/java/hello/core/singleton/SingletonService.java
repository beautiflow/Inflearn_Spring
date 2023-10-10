package hello.core.singleton;

public class SingletonService {

    // 내부적으로 실행을 해서 이 객체를 생성한 다음에 자기 자신을 생성해서 여기 인스턴스 찬조를 넣어 논다
    // 자기 자신을 인스턴스 객체 하나 딱 생성해서 여기안에만 딱 들어간다.
    // 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    // 2. public 으로 열어서 객체 인스턴스가 필요하면 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 3. 생성자를 private 으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
