package jpa.fintech.service;

import jpa.fintech.dto.LoginDTO;
import jpa.fintech.entity.User;
import jpa.fintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private UserRepository userRepository;

    public boolean login(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());
        // USER의 아이디도 만들거면 조건 하나 추가해야 함
        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            return true;
        }
        return false;
    }
}
