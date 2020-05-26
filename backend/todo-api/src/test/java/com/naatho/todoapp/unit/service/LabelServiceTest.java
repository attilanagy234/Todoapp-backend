package com.naatho.todoapp.unit.service;


import com.naatho.todoapp.entity.Label;
import com.naatho.todoapp.entity.Task;
import com.naatho.todoapp.repository.LabelRepository;
import com.naatho.todoapp.service.LabelService;
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
@ContextConfiguration(classes = {LabelService.class})
@WebMvcTest(value = LabelService.class)
@AutoConfigureMockMvc(addFilters = false)
public class LabelServiceTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private LabelService labelService;

    @MockBean
    private LabelRepository labelRepository;

    private final String root = "/labels";

    Task t;
    Label l;

    @Before
    public void setup() {
        t = new Task();
        l = new Label("id", "name");
        when(labelService.findAll())
                .thenReturn(Arrays.asList(l));
        when(labelService.findById("id"))
                .thenReturn(Optional.ofNullable(l));
        when(labelService.findById(argThat(not("id"))))
                .thenReturn(Optional.empty());
    }

    @Test
    public void findAll_ExpectReturnJson() throws Exception {
        List<Label> labels = labelService.findAll();

        assertThat(labels.size(), equalTo(1));
        assertThat(labels.get(0), equalTo(l));
    }

    @Test
    public void findById() throws Exception {
        Optional<Label> label = labelService.findById("id");
        assertThat(label, notNullValue());
        assertEquals(label, Optional.of(l));
    }

    @Test
    public void findById_UserNotExist() throws Exception {
        Optional<Label> label = labelService.findById("asd");
        assertEquals(label, Optional.empty());
    }

    @Test
    public void deleteById() throws Exception {
        labelService.deleteById("id");
        Mockito.verify(labelService, Mockito.times(1)).deleteById("id");
    }

    @Test
    public void save() throws Exception {
        labelService.save(l);
        Mockito.verify(labelService, Mockito.times(1)).save(l);
    }
}
