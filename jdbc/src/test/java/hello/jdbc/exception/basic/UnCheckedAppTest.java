package hello.jdbc.exception.basic;

import java.net.ConnectException;
import java.sql.SQLException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnCheckedAppTest {

    @Test
    void unchecked(){
        Controller controller = new Controller();

        Assertions.assertThatThrownBy(()-> controller.request())
                .isInstanceOf(RuntimeSqlException.class);
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

        public void logic() {
            repository.call();
            nerworkClient.call();
        }
    }

    static class NerworkClient{
        public void call() {
            throw new RuntimeConnectException("연결 실패");
        }
    }

    static class Repository{
        public void call()  {
            try {
                runSQL();
            }
            catch (SQLException e){
                throw new RuntimeSqlException(e);
            }
        }

        public void runSQL() throws SQLException {
            throw new SQLException("ex");
        }
    }

    static class RuntimeConnectException extends RuntimeException{
        public RuntimeConnectException(String message){
            super(message);
        }
    }

    static class RuntimeSqlException extends RuntimeException{

        public RuntimeSqlException(Throwable cause) {
            super(cause);
        }
    }

}
