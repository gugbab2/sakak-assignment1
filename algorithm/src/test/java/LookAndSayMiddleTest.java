import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LookAndSayMiddleTest {

    @ParameterizedTest
    @CsvSource({
            "5,12",
            "8,21"
    })
    void 성공_케이스(int n, int expected) {
        assertEquals(expected, LookAndSayMiddleVersion2.middleTwoDigits(n));
    }

    @Test
    void 실패_케이스() {
        assertThrows(IllegalArgumentException.class,
                () -> LookAndSayMiddleVersion1.middleTwoDigits(0));
        assertThrows(IllegalArgumentException.class,
                () -> LookAndSayMiddleVersion1.middleTwoDigits(-3));
    }

}