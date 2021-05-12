package com.example.math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SumController.class)
public class SumControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSum3() throws Exception {

        RequestBuilder builder = post("/math/sum").contentType(MediaType.TEXT_PLAIN)
                .param("n", "4")
                .param("n", "5")
                .param("n", "6");
        mockMvc.perform(builder).andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }


    @Test
    public void testSum2() throws Exception {

        RequestBuilder builder = post("/math/sum").contentType(MediaType.TEXT_PLAIN)
                .param("n", "4")
                .param("n", "6");
        mockMvc.perform(builder).andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }
}
