package com.naatho.todoapp.unit.service;

import com.naatho.todoapp.entity.User;
import com.naatho.todoapp.repository.UserRepository;
import com.naatho.todoapp.service.ProjectService;
import com.naatho.todoapp.service.UserService;
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
public class UserServiceTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private final String root = "/users";

    User u;

    @Before
    public void setup() {
        u = new User("Joe Test", "test@test.com", "password");
        when(userService.findAll())
                .thenReturn(Arrays.asList(u));
        when(userService.findById(1))
                .thenReturn(Optional.ofNullable(u));
        when(userService.findById(argThat(not(1))))
                .thenReturn(Optional.empty());
    }

    @Test
    public void findAll_ExpectReturnJson() throws Exception {
        List<User> users = userService.findAll();

        assertThat(users.size(), equalTo(1));
        assertThat(users.get(0), equalTo(u));
    }

    @Test
    public void findById() throws Exception {
        Optional<User> user = userService.findById(1);
        assertThat(user, notNullValue());
        assertEquals(user, Optional.of(u));
    }

    @Test
    public void findById_UserNotExist() throws Exception {
        Optional<User> user = userService.findById(2);
        assertEquals(user, Optional.empty());
    }

    @Test
    public void deleteById() throws Exception {
        userService.deleteById(1);
        Mockito.verify(userService, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void save() throws Exception {
        userService.save(u);
        Mockito.verify(userService, Mockito.times(1)).save(u);
    }

}
