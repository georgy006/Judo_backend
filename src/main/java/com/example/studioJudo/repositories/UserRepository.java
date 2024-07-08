package com.example.studioJudo.repositories;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {
}
