package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository <UserAccount, String> {

    //UserDetails findUserByUsername (String username);
}
