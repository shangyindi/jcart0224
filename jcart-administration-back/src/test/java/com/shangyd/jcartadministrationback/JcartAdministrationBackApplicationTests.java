package com.shangyd.jcartadministrationback;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JcartAdministrationBackApplicationTests {

    @Test
    public void aaa(){
        String bcryptHashString = BCrypt.withDefaults().hashToString(10, "123456".toCharArray());

        System.out.println(bcryptHashString);
    }

}
