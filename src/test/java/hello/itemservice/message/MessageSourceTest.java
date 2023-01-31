package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

@SpringBootTest//이게 있어야 di를 해줌
public class MessageSourceTest {
    @Autowired
    private MessageSource ms;

    @Test
    public void 안녕(){
        String result = ms.getMessage("hello", null, Locale.KOREA);
        Assertions.assertThat(result).isEqualTo("안녕");
    }
    @Test
    public void hello(){
        String result = ms.getMessage("hello", null, Locale.ENGLISH);
        Assertions.assertThat(result).isEqualTo("hello");
    }
    @Test
    public void notFoundMessageCode(){
        Assertions.assertThatThrownBy(() -> ms.getMessage("no_code",null,null)).isInstanceOf(NoSuchMessageException.class);

    }
    @Test
    public void defaultMessage(){
        Assertions.assertThat(ms.getMessage("no_code",null,"default",null)).isEqualTo("default");
    }
    @Test
    public void argumentMessage(){
        Assertions.assertThat(ms.getMessage("hello.name",new Object[]{"Spring"},"default",null)).isEqualTo("안녕 Spring");
    }
}
