package com.example.BRDO.services;

import com.example.BRDO.models.User;
import com.example.BRDO.services.commets_dto.OneCommentDTO;
import com.example.BRDO.services.commets_dto.CommentsListDTO;
import com.example.BRDO.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServices {
    private final String DUMMY_JSON_URL = "https://dummyjson.com/comments";

    private final UserRepository userRepository;

    public List<User> getUsersOrLoad() {
        long count = userRepository.count();
        if (count == 0) {
            loadDate();
        }
        return userRepository.findAll();
    }

    public List<User> reloadAndGetUsers() {
        userRepository.deleteAll();
        loadDate();
        return userRepository.findAll();
    }

    public void createUsers(List<User> users) {
        try {
            userRepository.saveAll(users);
        } catch (Exception exception) {
            log.info("User creation error: " + String.valueOf(exception));
        }
    }

    public void loadDate() {
        String inputLine;
        CommentsListDTO commentsDTO;
        StringBuilder res = new StringBuilder();
        try {
            URL oracle = new URL(DUMMY_JSON_URL);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            while ((inputLine = in.readLine()) != null)
                res.append(inputLine);
            in.close();

            ObjectMapper mapper = new ObjectMapper();
            commentsDTO = mapper.readValue(res.toString(), CommentsListDTO.class);
            createUsers(commentsDTOToUserArray(commentsDTO));
        } catch (Exception exception) {
            log.info("Date load error: " + String.valueOf(exception));
        }


    }

    private ArrayList<User> commentsDTOToUserArray(CommentsListDTO commentsListDTO) {
        ArrayList<OneCommentDTO> comments = commentsListDTO.comments;

        return new ArrayList<>(comments.stream().map(this::getUser).toList());
    }

    private User getUser(OneCommentDTO commentDTO) {
        try {
            return new User(
                    commentDTO.getUser().getId(),
                    commentDTO.getBody(),
                    commentDTO.getPostId(),
                    firstNameLetterToUpperCase(commentDTO.getUser().getUsername()),
                    new Date());
        } catch (Exception exception) {
            log.info("Get user error: " + String.valueOf(exception));
            return null;
        }
    }

    private String firstNameLetterToUpperCase(String userName) {
        try {
            return userName.substring(0, 1).toUpperCase() + userName.substring(1);
        } catch (Exception exception) {
            log.info("Username error:  " + String.valueOf(exception));
            return null;
        }
    }

}
