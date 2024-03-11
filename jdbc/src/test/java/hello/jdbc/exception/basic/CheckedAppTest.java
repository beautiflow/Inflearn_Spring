package hello.jdbc.exception.basic;

import java.net.ConnectException;
import java.sql.SQLException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckedAppTest {

    @Test
    void checked(){
        Controller controller = new Controller();

        Assertions.assertThatThrownBy(()-> controller.request())
                .isInstanceOf(Exception.class);
    }


    static class Controller{
        Service service = new Service();

        public void request() throws SQLException, ConnectException {
            service.logic();
        }
    }

    static class Service{
        Repository repository = new Repository();
        NerworkClient nerworkClient = new NerworkClient();

        public void logic() throws SQLException, ConnectException {
            repository.call();
            nerworkClient.call();
        }
    }

    static class NerworkClient{
        public void call() throws ConnectException {
            throw new ConnectException("연결 실패");
        }
    }

    static class Repository{
        public void call() throws SQLException {
            throw new SQLException("ex");
        }
    }

}
