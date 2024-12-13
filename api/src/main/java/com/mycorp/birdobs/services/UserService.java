package com.mycorp.birdobs.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycorp.birdobs.PasswordHasher;
import com.mycorp.birdobs.dao.UserDao;
import com.mycorp.birdobs.dto.UserDto;
import com.mycorp.birdobs.models.Users;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ReportService reportService;

    public UserDto save(UserDto userDto) {
        String hashedPassword = PasswordHasher.hashPassword(userDto.getMdp());

        userDto.setMdp(hashedPassword);

        Users user = toEntity(userDto);
        
        Users userSaved = userDao.save(user);

        return toDto(userSaved);
    }

    public UserDto findById(Integer userID) {
        Optional<Users> userInDb = userDao.findById(userID);

        if (!userInDb.isPresent()) {
            return null;
        }

        return toDto(userInDb.get());
    }

    public Users findUserById(Integer userID) {
        Optional<Users> userInDb = userDao.findById(userID);

        if (!userInDb.isPresent()) {
            return null;
        }

        return userInDb.get();
    }

    public UserDto updateById(Integer id, UserDto userDto) {
        Users userInDb = findUserById(id);

        if (userInDb == null) {
            return null;
        }

        // Mettre à jour les champs nécessaires
        if (userDto.getPseudo() != null) {
            userInDb.setPseudo(userDto.getPseudo());
        }

        if (userDto.getEmail() != null) {
            userInDb.setEmail(userDto.getEmail());
        }

        if (userDto.getMdp() != null) {
            userInDb.setMdp(userDto.getMdp());
        }

        Users updatedUser = userDao.save(userInDb);

        return toDto(updatedUser);
    }

    public boolean deleteById(Integer id) {
        Users userInDb = findUserById(id);

        if (userInDb == null) {
            return false;
        }

        userDao.delete(userInDb);

        return true;
    }

    private Users toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        Users user = new Users();

        user.setUserID(userDto.getUserID());
        user.setPseudo(userDto.getPseudo());
        user.setEmail(userDto.getEmail());
        user.setMdp(userDto.getMdp());
        user.setReports(reportService.toEntityList(userDto.getReports()));

        return user;
    }

    private UserDto toDto(Users user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserID(user.getUserID());
        userDto.setPseudo(user.getPseudo());
        userDto.setEmail(user.getEmail());
        userDto.setMdp(user.getMdp());
        userDto.setReports(reportService.toDtoList(user.getReports()));

        return userDto;
    }
}