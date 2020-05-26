package com.naatho.todoapp.unit.controller;


import com.naatho.todoapp.contoller.ProjectController;
import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.service.ProjectService;
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
@ContextConfiguration(classes = {ProjectController.class})
@WebMvcTest(value = ProjectController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProjectControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProjectService projectService;

    private final String root = "/projects";

    User u;
    Task t;

    @Before
    public void setup() {
        u = new User();
        t = new Task();
    }

    @Test
    public void findAll() throws Exception {
        Project p1 = new Project("project1", "project1 description");
        Project p2 = new Project("project2", "project2 description");

        given(projectService.findAll()).willReturn(Arrays.asList(p1, p2));

        mvc.perform(get(root)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        Project p1 = new Project("project1", "project1 description");

        given(projectService.findById(1)).willReturn(java.util.Optional.of(p1));
        given(projectService.findById(argThat(not(1)))).willReturn(null);

        mvc.perform(get(root+"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get(root+"/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteById() throws Exception {
        Project p1 = new Project("exampleProjectName","exampleProjectDesc");
        given(projectService.findById(1)).willReturn(java.util.Optional.of(p1));
        given(projectService.findById(argThat(not(1)))).willReturn(null);

        mvc.perform(delete(root + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(delete(root + "/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void save() throws Exception {
        Project p1 = new Project("exampleProjectName","exampleProjectDesc");
        projectService.save(p1);
        given(projectService.findAll()).willReturn(Arrays.asList(p1));
        given(projectService.findById(1)).willReturn(java.util.Optional.of(p1));
    }
}
