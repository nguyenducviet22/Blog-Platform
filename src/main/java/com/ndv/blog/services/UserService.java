package com.ndv.blog.services;

import com.ndv.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID id);
}
