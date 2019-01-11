package com.codeup.springblog.Repositories;

import com.codeup.springblog.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
