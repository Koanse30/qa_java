import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamTest {
    private final String sex;
    private final boolean isMale;
    private final String exception;

    public LionParamTest(String sex, boolean isMale, String exception) {
        this.sex = sex;
        this.isMale = isMale;
        this.exception = exception;
    }

    @Parameterized.Parameters(name = "Создание льва с данными - {0}, {1}")
    public static Object[][] getLionParam() {
        return new Object[][] {
                {"Самец", true, "Ошибка при указании пола Самец"},
                {"Самка", false, "Ошибка при указании пола Самка"},
                {"Exception", true, "Используйте допустимые значения пола животного - самец или самка"}
        };
    }

    @Test
    public void lionParamTest() {
        try {
            Feline feline = new Feline();
            Lion lion = new Lion(sex, feline);
            assertEquals(isMale, lion.doesHaveMane());
        } catch (Exception e) {
            assertEquals(e.getMessage(), exception);
        }
    }
}
