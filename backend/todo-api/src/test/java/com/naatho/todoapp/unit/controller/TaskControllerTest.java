package com.naatho.todoapp.unit.controller;

import com.naatho.todoapp.contoller.TaskController;
import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TaskController.class})
@WebMvcTest(value = TaskController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TaskControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskService taskService;

    private final String root = "/tasks";

    User u;
    Project p;

    @Before
    public void setup() {
        u = new User();
        p = new Project();
    }

    @Test
    public void findAll() throws Exception {
        Task t1 = new Task("taskName", u, p);
        Task t2 = new Task("taskName2", u, p);

        given(taskService.findAll()).willReturn(Arrays.asList(t1, t2));

        mvc.perform(get(root)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        Task t1 = new Task("taskName", u, p);

        given(taskService.findById(1)).willReturn(java.util.Optional.of(t1));
        given(taskService.findById(argThat(not(1)))).willReturn(null);

        mvc.perform(get(root+"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get(root+"/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteById() throws Exception {
        Task t1 = new Task("taskName", u, p);
        given(taskService.findById(1)).willReturn(java.util.Optional.of(t1));
        given(taskService.findById(argThat(not(1)))).willReturn(null);

        mvc.perform(delete(root + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(delete(root + "/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void save() throws Exception {
        Task t1 = new Task("taskName", u, p);
        taskService.save(t1);
        given(taskService.findAll()).willReturn(Arrays.asList(t1));
        given(taskService.findById(1)).willReturn(java.util.Optional.of(t1));
    }

}
