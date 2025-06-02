import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import thienln.example.AccountService;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {

    static AccountService accountService;

    @BeforeAll
    static void setup() {
        accountService = new AccountService();
    }

    @ParameterizedTest(name = "{index} => username={0}, password={1}, email={2}, expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean actual = accountService.registerAccount(username, password, email);
        assertEquals(expected, actual);
    }
}
