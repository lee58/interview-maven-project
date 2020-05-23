package com.interview;

import com.interview.reflex.service.ReflexService;
import com.interview.reflex.entity.User;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 大都督
 * @create 2020/5/18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReflexTest {
    @Autowired
    private ReflexService reflexService;
    @Test
    public void testClazz() {
        reflexService.printClass();
        reflexService.printClassName("int.class", int.class);
        reflexService.printClassName("int[].class", int[].class);
        reflexService.printClassName("int[][].class", int[][].class);
        reflexService.printClassName("String.class", String.class);
        reflexService.printClassName("String[].class", String[].class);
        reflexService.printClassName("HashMap.class", HashMap.class);
        reflexService.printClassName("Map.Entry.class", Map.Entry.class);
    }
    @Test
    public void printFieldInfo() {
        reflexService.printFieldInfo(User.class);
    }
}
