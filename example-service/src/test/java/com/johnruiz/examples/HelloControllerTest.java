package com.johnruiz.examples;

import com.johnruiz.examples.controllers.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by jar349 on 1/23/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class HelloControllerTest {

    private MockMvc mvc;


    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }


    @Test
    public void should_get_hello() throws Exception {

        mvc
            .perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk())
            .andExpect(content().string(is("Greetings from Spring Boot!\n")));

    }
}
