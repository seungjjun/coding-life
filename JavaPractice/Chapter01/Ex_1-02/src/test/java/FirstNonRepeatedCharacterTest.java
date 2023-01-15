import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatedCharacterTest {
    @Test
    void V1() {
        FirstNonRepeatedCharacter firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();

        assertEquals('c', firstNonRepeatedCharacter.firstNonRepeatedCharacterV1("aabbcddef"));
    }

    @Test
    void V2() {
        FirstNonRepeatedCharacter firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();

        assertEquals('c', firstNonRepeatedCharacter.firstNonRepeatedCharacterV2("aabbcddef"));
    }
}
