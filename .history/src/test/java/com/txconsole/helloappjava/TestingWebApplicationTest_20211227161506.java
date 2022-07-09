package com.txconsole.helloappjava;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${greet.user}")
    private String greetuser;

    @Value("${greet.msg}")
    private String greetmsg;

    @Value("${app.version}")
    private String appversion;

    @Test
    public void shouldReturnResponseForRootPath() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(content().string(containsString(appversion)));
    }

    @Test
    public void shouldReturnGreet() throws Exception {
        this.mockMvc.perform(get("/api/greet")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user").value(greetuser))
                .andExpect(MockMvcResultMatchers.jsonPath("$.greet").value(greetmsg));
        // .andDo(print());

    }

    @Test
    public void shouldReturnAppVersion() throws Exception {
        this.mockMvc.perform(get("/api/version")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.appVersion").value(appversion));
    }

}