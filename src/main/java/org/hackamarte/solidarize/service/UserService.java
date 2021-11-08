package org.hackamarte.solidarize.service;

import lombok.NoArgsConstructor;
import org.hackamarte.solidarize.exception.NotFoundException;
import org.hackamarte.solidarize.model.User;
import org.hackamarte.solidarize.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
@NoArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User find(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado com ID: "+id));
    }

    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User create(User user) {

        if (userRepository.findByLogin(user.getLogin()).isPresent()){
            throw new ResponseStatusException(HttpStatus.FOUND,"Usuário já existe");
        }

        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

}
