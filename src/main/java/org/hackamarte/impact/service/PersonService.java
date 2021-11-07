package org.hackamarte.impact.service;

import lombok.NoArgsConstructor;
import org.hackamarte.impact.exception.NotFoundException;
import org.hackamarte.impact.model.Person;
import org.hackamarte.impact.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
@NoArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findById(UUID id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada com ID: "+id));
    }

    public Optional<Person> findByCpf(String cpf) {
        return personRepository.findByCpf(cpf);
    }

    public Person create(Person person) {

        if (personRepository.findByCpf(person.getCpf()).isPresent()){
            throw new ResponseStatusException(HttpStatus.FOUND,"Já existe uma pessoa cadastrada com o CPF: "+ person.getCpf());
        }
        return personRepository.save(person);
    }

    public Person update(Person person) {
        return personRepository.save(person);
    }


}
