package com.example.math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CalculateController.class)
public class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddition() throws Exception {
        mockMvc.perform(get("/math/calculate")
                .accept(MediaType.TEXT_PLAIN)
                .param("operation", "add")
                .param("x", "4")
                .param("y", "6"))
                .andExpect(status().isOk()).andExpect(content().string("4 + 6 = 10"));

    }

    @Test
    public void testMultiplication() throws Exception {
        mockMvc.perform(get("/math/calculate")
                .accept(MediaType.TEXT_PLAIN)
                .param("operation", "multiply")
                .param("x", "4")
                .param("y", "6"))
                .andExpect(status().isOk()).andExpect(content().string("4 * 6 = 24"));

    }

    @Test
    public void testSubtraction() throws Exception {
        mockMvc.perform(get("/math/calculate")
                .accept(MediaType.TEXT_PLAIN)
                .param("operation", "subtract")
                .param("x", "4")
                .param("y", "6"))
                .andExpect(status().isOk()).andExpect(content().string("4 - 6 = -2"));

    }

    @Test
    public void testDivision() throws Exception {
        mockMvc.perform(get("/math/calculate")
                .accept(MediaType.TEXT_PLAIN)
                .param("operation", "divide")
                .param("x", "30")
                .param("y", "5"))
                .andExpect(status().isOk()).andExpect(content().string("30 / 5 = 6"));
    }

    @Test
    public void testDefault() throws Exception {
        mockMvc.perform(get("/math/calculate")
                .accept(MediaType.TEXT_PLAIN)
                .param("x", "30")
                .param("y", "5"))
                .andExpect(status().isOk()).andExpect(content().string("30 + 5 = 35"));

    }
}
