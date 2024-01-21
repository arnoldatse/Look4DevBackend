package dev.arnoldatse.opensource.look4dev.app.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperToUser;

import java.util.ArrayList;
import java.util.Collections;

public class MapperUserToCoreUserWithoutLazyFetch implements MapperToUser {
    private final User user;

    public MapperUserToCoreUserWithoutLazyFetch(User user) {
        this.user = user;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.user.User mapToUser() {
        dev.arnoldatse.opensource.look4dev.core.entities.user.User coreUser = new dev.arnoldatse.opensource.look4dev.core.entities.user.User();
        coreUser.setId(user.getId());
        coreUser.setLastname(user.getLastname());
        coreUser.setFirstname(user.getFirstname());
        coreUser.setEmail(user.getEmail());
        coreUser.setPassword(user.getPassword());
        coreUser.setPseudo(user.getPseudo());
        coreUser.setPicture(user.getPicture());
        coreUser.setBio(user.getBio());
        coreUser.setCv(user.getCv());
        coreUser.setCreatedAt(user.getCreatedAt());
        coreUser.setUpdatedAt(user.getUpdatedAt());
        coreUser.setUserProfiles(new ArrayList<>());
        return coreUser;
    }
}
