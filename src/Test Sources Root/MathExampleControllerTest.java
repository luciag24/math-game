import org.example.DetskaAppkaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DetskaAppkaApplication.class)
public class MathExampleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGenerateExample() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/test", String.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Test endpoint is working!", response.getBody());
    }
}

