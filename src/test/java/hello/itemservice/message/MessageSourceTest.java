package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

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
}
