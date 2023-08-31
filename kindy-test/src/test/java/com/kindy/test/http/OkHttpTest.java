package com.kindy.test.http;

import cn.zhxu.okhttps.HttpResult;
import cn.zhxu.okhttps.OkHttps;
import org.junit.jupiter.api.Test;

public class OkHttpTest {

    @Test
    public void testGet() {
        for (int i = 0; i < 100; i++) {
            HttpResult.Body body1 = OkHttps.async("http://localhost:8080/kindy-system/kindy/user?aaa=bbb&ccc=ddd").get().getResult().getBody();
            System.out.println(body1.toString());
        }
    }
}
