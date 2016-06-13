package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.Runner;
import ca.epsilonlambda.shoppingcart.data.UserRepository;
import ca.epsilonlambda.shoppingcart.domain.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

import static org.mockito.Mockito.*;

/**
 * Created by Kirill on 6/12/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Runner.class)
public class UserServiceTest extends TestCase {
    UserService service;
    UserRepository mockRepository;

    @Before
    public void setUp() {
        mockRepository = mock(UserRepository.class);
        service = new UserServiceImpl(mockRepository);

        when(mockRepository.save(any(User.class))).thenAnswer((Answer<User>) invocation -> {
            User u = (User) invocation.getArguments()[0];
            return u;
        });
    }

    @Test
    public void canCreateUser() {
        User u = service.createAndStoreAnonymousUser();
        verify(mockRepository).save(u);
    }

    @Test
    public void createsDifferentUsers() {
        HashSet<String> ids = new HashSet<>();

        for(int i = 0; i < 10; i++) {
            User u = service.createAndStoreAnonymousUser();
            assertFalse(ids.contains(u.getId()));
            ids.add(u.getId());
        }

        assertTrue(ids.size() > 0);
    }
}
