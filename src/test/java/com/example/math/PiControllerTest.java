package com.example.math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest({PiController.class})
public class PiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    public PiControllerTest() {
    }

    @Test
    public void getPiValue() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/math/pi", new Object[0]).accept(new MediaType[]{MediaType.TEXT_PLAIN})).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("3.141592653589793"));
    }

    @Test
    public void notFoundPiValue() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/math/pi-notfound", new Object[0]).accept(new MediaType[]{MediaType.TEXT_PLAIN})).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
