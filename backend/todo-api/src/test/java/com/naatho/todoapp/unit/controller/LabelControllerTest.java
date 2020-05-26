package com.naatho.todoapp.unit.controller;

import com.naatho.todoapp.contoller.LabelController;
import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.service.LabelService;
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
@ContextConfiguration(classes = {LabelController.class})
@WebMvcTest(value = LabelController.class)
@AutoConfigureMockMvc(addFilters = false)
public class LabelControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LabelService labelService;

    private final String root = "/labels";

    Task t;

    @Before
    public void setup() {
        t = new Task();
    }

    @Test
    public void findAll_ExpectReturnJson() throws Exception {
        Label l1 = new Label();
        Label l2 = new Label();
        given(labelService.findAll()).willReturn(Arrays.asList(l1, l2));

        mvc.perform(get(root)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        Label l1 = new Label("exampleLabelName","exampleLabelDesc");
        given(labelService.findById("exampleLabelName")).willReturn(java.util.Optional.of(l1));
        given(labelService.findById(argThat(not("exampleLabelName")))).willReturn(null);
    }

    @Test
    public void deleteById() throws Exception {
        Label l1 = new Label("exampleLabelName","exampleLabelDesc");
        given(labelService.findById("exampleLabelName")).willReturn(java.util.Optional.of(l1));
        given(labelService.findById(argThat(not("exampleLabelName")))).willReturn(null);

        mvc.perform(delete(root + "/exampleLabelName")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        mvc.perform(delete(root + "/label123")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
    }

    @Test
    public void save() throws Exception {
        Label l1 = new Label("exampleLabelName","exampleLabelDesc");
        labelService.save(l1);
        given(labelService.findAll()).willReturn(Arrays.asList(l1));
        given(labelService.findById("exampleLabelName")).willReturn(java.util.Optional.of(l1));
    }

}
