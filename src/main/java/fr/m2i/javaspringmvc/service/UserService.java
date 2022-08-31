
package fr.m2i.javaspringmvc.service;

import fr.m2i.javaspringmvc.model.User;
import fr.m2i.javaspringmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public Double getBalance() throws Exception {
        User user = repo.findById(1L).orElseThrow(() -> new Exception()); // Todo throw a custom exception called NotFoundException
        return user.getBalance();
    }

    public void addBalance(Double balance) throws Exception {
        User user = repo.findById(1L).orElseThrow(() -> new Exception()); // Todo throw a custom exception called NotFoundException
        user.setBalance(user.getBalance() + balance);

        repo.save(user);
    }

    public void decreaseBalance(Double balance) throws Exception {
        User user = repo.findById(1L).orElseThrow(() -> new Exception()); // Todo throw a custom exception called NotFoundException
        user.setBalance(user.getBalance() - balance);

        repo.save(user);
    }
}




