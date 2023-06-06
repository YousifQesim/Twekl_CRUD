package com.twekll.CRUD.Repo;

import com.twekll.CRUD.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
