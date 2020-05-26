package com.naatho.todoapp.unit.controller;

import com.naatho.todoapp.contoller.LabelController;
import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.repository.LabelRepository;
import com.naatho.todoapp.service.LabelService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {LabelController.class})
@WebMvcTest(value = LabelController.class)
public class LabelControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LabelService labelService;

    private final String root = "/labels";

    Task t;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        t = new Task();
        labelService = new LabelService();
    }

    @Test
    public void findAll_ExpectReturnJson() throws Exception {
        Label l1 = new Label();
        Label l2 = new Label();
        given(labelService.findAll()).willReturn(Arrays.asList(l1, l2));

//        mvc.perform(get(root)
//                    .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        Label l1 = new Label("exampleLabelName","exampleLabelDesc");
        given(labelService.findById("exampleLabelName")).willReturn(java.util.Optional.of(l1));
        given(labelService.findById(argThat(not("exampleLabelName")))).willReturn(null);
    }

    @Test
    public void deleteById() throws Exception {
        Label l1 = new Label();
        given(labelService.findById("id")).willReturn(java.util.Optional.of(l1));
        given(labelService.findById(argThat(not("id")))).willReturn(null);

        mvc.perform(delete(root+"/id")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        mvc.perform(delete(root+"/id3")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
    }

}
