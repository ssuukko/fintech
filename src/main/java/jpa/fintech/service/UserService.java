package jpa.fintech.service;

import jpa.fintech.entity.User;
import jpa.fintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    //AUTOWIRED 하는게 낫나?
    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        // 중복 처리 필요할듯(같은 아이디)
        userRepository.save(user);
        return user.getId();
    }

    public User findOne(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
    }

}
