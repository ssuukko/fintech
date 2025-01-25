package jpa.fintech.service;

import jpa.fintech.entity.User;
import jpa.fintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public User findOne(Long userId) {
        return userRepository.findById(userId).get();
    }

}
