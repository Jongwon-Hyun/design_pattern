import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import template_method.PostAccountController
import template_method.PostAccountReqBody

class TemplateMethodTest : FunSpec({
    test("Test Template Method") {
        val controller = PostAccountController()
        val response = controller.createAccount(PostAccountReqBody("12345", "123"))
        response.status shouldBe 201
    }
})