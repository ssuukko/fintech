package jpa.fintech.service;

import jpa.fintech.dto.request.UserRequestJoinDTO;
import jpa.fintech.dto.response.JoinResponse;
import jpa.fintech.entity.User;
import jpa.fintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public JoinResponse join(UserRequestJoinDTO requestDTO) {
        User user = User.builder()
                .username(requestDTO.getUserName())
                .password(requestDTO.getPassword())
                .build();

        userRepository.save(user);

        return new JoinResponse(user.getUsername(), "회원가입 성공");
    }

    public User findOne(Long userId) {
        return userRepository.findById(String.valueOf(userId))
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
    }
}
