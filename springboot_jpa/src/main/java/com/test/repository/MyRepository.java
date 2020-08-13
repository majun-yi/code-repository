package com.test.repository;

import com.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MyRepository extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {
}
