import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Yes/No - good inputs, should work with all capitalizations")
    void verifyYesNo() {
        assertEquals(true,Main.verifyYesNo("yes"));
        assertEquals(true,Main.verifyYesNo("YES"));
        assertEquals(true,Main.verifyYesNo("YeS"));
        assertEquals(true,Main.verifyYesNo("no"));
        assertEquals(true,Main.verifyYesNo("nO"));
        assertEquals(true,Main.verifyYesNo("No"));
    }
    @Test
    @DisplayName("Yes/No - null, empty string, int")
    void verifyYesNoBad(){
        assertEquals(false,Main.verifyYesNo(""));
        assertEquals(false,Main.verifyYesNo("1"));
        assertEquals(false,Main.verifyYesNo(null));
    }
}