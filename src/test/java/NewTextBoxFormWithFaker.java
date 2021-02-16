import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class NewTextBoxFormWithFaker {

    @Test
    public void successFillTextBoxForm() {

        String fullName = "NAME",
               email = "EMAIL",
               currentAddress = "ADDRESS",
               permanentAddress = "PERMANENT_ADDRESS";

        Selenide.open("https://demoqa.com/text-box");

        Selenide.$("#userName").setValue(fullName);

        Selenide.$("#userEmail").setValue(email);

        Selenide.$("#currentAddress").setValue(currentAddress);

        Selenide.$("#permanentAddress").setValue(permanentAddress);




    }
}
