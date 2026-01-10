package com.petstore.user.repository;

import com.petstore.user.model.User;
import lombok.NonNull;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * user-service
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<@NonNull User, @NonNull Long> {

  Optional<User> findByUsername(String username);

}
