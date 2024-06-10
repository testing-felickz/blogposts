package guru.springframework.blog.util;

import org.owasp.encoder.Encode;


public class EncodeUtil {

    public static String encodeForJava(String input) {
        return Encode.forJava(input);
    }

}
