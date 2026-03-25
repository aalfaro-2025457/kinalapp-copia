package com.angelalfaro.kinalapp.repository;

import com.angelalfaro.kinalapp.entity.User;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Slice<User> findByStateUser(int state);

}
