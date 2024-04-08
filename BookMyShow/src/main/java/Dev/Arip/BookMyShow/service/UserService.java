package Dev.Arip.BookMyShow.service;

import Dev.Arip.BookMyShow.model.User;
import Dev.Arip.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String email, String pwd) throws Exception {
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser==null)
        {
            throw new Exception("User not present");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(pwd,savedUser.getPassword()))
        {
            return savedUser;
        }
        else
        {
            throw new Exception("Invalid Password");
        }
    }
@Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String name, String email, String pwd) throws Exception {
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser != null)
        {
            throw  new Exception("User is already Present");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(pwd));
        user.setTickets(new ArrayList<>());
        return userRepository.save(user);
    }
}
