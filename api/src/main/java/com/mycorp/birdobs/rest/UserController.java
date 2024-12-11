package com.mycorp.birdobs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycorp.birdobs.dto.UserDto;
import com.mycorp.birdobs.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private final static String VERIFY_ID = "/{id:[0-9]+}";

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        if (userDto.getUserID() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas spécifier l'ID. La base s'occupe de le créer.", HttpStatus.BAD_REQUEST);
        }

        if (userDto.getReports() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas spécifier l'ID. La base s'occupe de le créer.", HttpStatus.BAD_REQUEST);
        }

        UserDto userSaved = userService.save(userDto);

        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @GetMapping(VERIFY_ID)
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        UserDto userInDb = userService.findById(id);

        if (userInDb == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userInDb, HttpStatus.OK);
    }

    @PutMapping(VERIFY_ID)
    public ResponseEntity<?> updateUserById(@PathVariable Integer id, @RequestBody UserDto userDto) {
        UserDto userUpdated = userService.updateById(id, userDto);

        if (userUpdated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    @DeleteMapping(VERIFY_ID)
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        boolean found = userService.deleteById(id);

        if (!found) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}