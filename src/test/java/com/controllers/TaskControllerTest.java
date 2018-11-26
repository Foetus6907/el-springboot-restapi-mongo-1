package com.controllers;

import com.ElSpringbootRestapiMongo1Application;
import com.entity.Task;
import com.entity.User;
import com.services.TaskService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * The type Task controller test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElSpringbootRestapiMongo1Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {Task.class, User.class})
public class TaskControllerTest {

    /**
     * The Mock mvc.
     */
    @Autowired
    MockMvc mockMvc;

    /**
     * The Task service.
     */
    @MockBean
    TaskService taskService;

    /**
     * The Mosk task.
     */
    Task moskTask = new Task("5bfa86b7b7bca66ed344ea83", "Make the EL exercise");


    /**
     * Sets up.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
    }

    /**
     * Gets all.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllTest() throws Exception {
        Mockito.when(taskService.findAll()).thenReturn(Arrays.asList(moskTask));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tasks/all");
        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

        String expected = "[\n" +
                "    {\n" +
                "        \"id\": \"5bfa86b7b7bca66ed344ea83\",\n" +
                "        \"description\": \"Make the EL exercise\"\n" +
                "    }\n" +
                "]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), true);
    }

    /**
     * Test Gets task by id.
     *
     * @throws Exception the exception
     */
    @Test
    public void getTaskByIdTest() throws Exception {
        Mockito.when(taskService.findById(Mockito.anyString())).thenReturn(java.util.Optional.ofNullable(moskTask));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tasks/5bfa86b7b7bca66ed344ea83");
        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\n" +
                "        \"id\": \"5bfa86b7b7bca66ed344ea83\",\n" +
                "        \"description\": \"Make the EL exercise\"\n" +
                "    }";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), true);
    }
}