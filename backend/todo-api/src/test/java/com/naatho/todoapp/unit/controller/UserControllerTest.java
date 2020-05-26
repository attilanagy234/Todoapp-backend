package com.naatho.todoapp.unit.controller;

import com.naatho.todoapp.contoller.UserController;
import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.service.UserService;
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
@ContextConfiguration(classes = {UserController.class})
@WebMvcTest(value = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    private final String root = "/users";

    @Before
    public void setup() { }

    @Test
    public void findAll() throws Exception {
        User u1 = new User("Test Name", "test@test.com", "test");
        User u2 = new User("Test Joe", "joe@test.com", "test");
        given(userService.findAll()).willReturn(Arrays.asList(u1, u2));

        mvc.perform(get(root)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        User u1 = new User("Test Name", "test@test.com", "test");

        given(userService.findById(1)).willReturn(java.util.Optional.of(u1));
        given(userService.findById(argThat(not(1)))).willReturn(null);

        mvc.perform(get(root+"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get(root+"/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteById() throws Exception {
        User u1 = new User("Test Name", "test@test.com", "test");
        given(userService.findById(1)).willReturn(java.util.Optional.of(u1));
        given(userService.findById(argThat(not(1)))).willReturn(null);

        mvc.perform(delete(root + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(delete(root + "/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void save() throws Exception {
        User u1 = new User("Test Name", "test@test.com", "test");
        userService.save(u1);
        given(userService.findAll()).willReturn(Arrays.asList(u1));
        given(userService.findById(1)).willReturn(java.util.Optional.of(u1));
    }

}
