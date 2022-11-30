package dio.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.aula.model.User;
import dio.aula.repository.UserRepository;

@Component
public class StartApp implements CommandLineRunner{

    @Autowired
    private UserRepository repository; 

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Samuel");
        user.setUsername("samuelr");
        user.setPassword("abc12345");

        repository.save(user);

        for (User u : repository.findAll()) {
            System.out.println(u);
        }
        
    }
    
}
