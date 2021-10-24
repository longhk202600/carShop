package codluck.training.demo.service.Impl;

import codluck.training.demo.repository.UserRoleRepository;
import codluck.training.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;
}
