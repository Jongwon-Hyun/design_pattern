import org.junit.jupiter.api.Test;
import template_method.PostAccountController;
import template_method.PostAccountReqBody;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateMethodTest {

    @Test
    void testTemplateMethod() {
        final var controller = new PostAccountController();
        final var response = controller.createAccount(new PostAccountReqBody("12345", "123"));
        assertEquals(201, response.status());
    }
}
