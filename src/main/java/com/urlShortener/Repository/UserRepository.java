package com.urlShortener.Repository;

import com.urlShortener.Model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users u", nativeQuery = true)
    public List<User> findAll();

    @Query(value = "SELECT * FROM users u", nativeQuery = true)
    public List<User> findAllPaginated(Pageable pageable);

    @Query(value = "SELECT * FROM Users u Where u.email = :email", nativeQuery = true)
    public User getByEmail(String email);

    @Query(value = "SELECT * FROM Users u Where u.id = :id", nativeQuery = true)
    public User getById(long id);

}