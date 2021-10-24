package codluck.training.demo.dao;

import codluck.training.demo.model.UserRole;
import codluck.training.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserRole> user1 = userRoleRepository.getAccountByUserName(username);
        user1.orElseThrow(() -> new UsernameNotFoundException(("User not found! " + username)));
        return user1.map(MyUserDetail::new).get();
    }
}
