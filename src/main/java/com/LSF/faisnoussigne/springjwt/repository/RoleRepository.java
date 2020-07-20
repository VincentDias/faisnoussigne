package com.LSF.faisnoussigne.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LSF.faisnoussigne.springjwt.models.ERole;
import com.LSF.faisnoussigne.springjwt.models.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}