package com.wygplay.service;

import com.wygplay.dao.HelloDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class HelloServiceTest {

    @Mock
    private HelloDao helloDao;
    @InjectMocks
    private HelloService helloService;

    @Test
    void hello() {
        Mockito.doReturn("hello mockito").when(helloDao).getHello();
        assertEquals("hello mockito", helloService.hello());
    }
}