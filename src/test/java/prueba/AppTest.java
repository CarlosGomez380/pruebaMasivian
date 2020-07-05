package prueba;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import prueba.services.RouletteService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ App.class })
@AutoConfigureMockMvc
public class AppTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private RouletteService services;
    @Test
    public void shouldAnswerWithTrue() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.post("/roulette")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }


}
