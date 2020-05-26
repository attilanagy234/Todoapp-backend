package com.naatho.todoapp.unit.service;

import com.naatho.todoapp.entity.Project;
import com.naatho.todoapp.repository.ProjectRepository;
import com.naatho.todoapp.service.ProjectService;
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
public class ProjectServiceTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProjectService projectService;

    @MockBean
    private ProjectRepository projectRepository;

    private final String root = "/projects";

    Project p;

    @Before
    public void setup() {
        p = new Project("name", "description");
        when(projectService.findAll())
                .thenReturn(Arrays.asList(p));
        when(projectService.findById(1))
                .thenReturn(Optional.ofNullable(p));
        when(projectService.findById(argThat(not(1))))
                .thenReturn(Optional.empty());
    }

    @Test
    public void findAll_ExpectReturnJson() throws Exception {
        List<Project> projects = projectService.findAll();

        assertThat(projects.size(), equalTo(1));
        assertThat(projects.get(0), equalTo(p));
    }

    @Test
    public void findById() throws Exception {
        Optional<Project> project = projectService.findById(1);
        assertThat(project, notNullValue());
        assertEquals(project, Optional.of(p));
    }

    @Test
    public void findById_UserNotExist() throws Exception {
        Optional<Project> project = projectService.findById(2);
        assertEquals(project, Optional.empty());
    }

    @Test
    public void deleteById() throws Exception {
        projectService.deleteById(1);
        Mockito.verify(projectService, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void save() throws Exception {
        projectService.save(p);
        Mockito.verify(projectService, Mockito.times(1)).save(p);
    }
}
