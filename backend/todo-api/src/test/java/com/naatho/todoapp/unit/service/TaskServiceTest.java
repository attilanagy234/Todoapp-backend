package com.naatho.todoapp.unit.service;

import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.repository.TaskRepository;
import com.naatho.todoapp.service.ProjectService;
import com.naatho.todoapp.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProjectService.class})
@WebMvcTest(value = ProjectService.class)
@AutoConfigureMockMvc(addFilters = false)
public class TaskServiceTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    private final String root = "/tasks";

    Task t;

    @Before
    public void setup() {
        t = new Task();
        when(taskService.findAll())
                .thenReturn(Arrays.asList(t));
        when(taskService.findById(1))
                .thenReturn(Optional.ofNullable(t));
        when(taskService.findById(argThat(not(1))))
                .thenReturn(Optional.empty());
    }

    @Test
    public void findAll_ExpectReturnJson() throws Exception {
        List<Task> tasks = taskService.findAll();

        assertThat(tasks.size(), equalTo(1));
        assertThat(tasks.get(0), equalTo(t));
    }

    @Test
    public void findById() throws Exception {
        Optional<Task> task = taskService.findById(1);
        assertThat(task, notNullValue());
        assertEquals(task, Optional.of(t));
    }

    @Test
    public void findById_UserNotExist() throws Exception {
        Optional<Task> task = taskService.findById(2);
        assertEquals(task, Optional.empty());
    }

    @Test
    public void deleteById() throws Exception {
        taskService.deleteById(1);
        Mockito.verify(taskService, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void save() throws Exception {
        taskService.save(t);
        Mockito.verify(taskService, Mockito.times(1)).save(t);
    }

}
