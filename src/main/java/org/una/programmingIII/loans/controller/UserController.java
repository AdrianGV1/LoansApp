package org.una.programmingIII.loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.programmingIII.loans.dto.UserDTO;
import org.una.programmingIII.loans.service.User.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

   @Autowired
   private UserService userService;

   @GetMapping
   public ResponseEntity<List<UserDTO>> getAllUsers() {
       List<UserDTO> users = userService.getAllUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);
   }

   @GetMapping("/findByEmail")
   public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email) {
       Optional<UserDTO> userDTO = userService.getUserByEmail(email);
       return userDTO.map(ResponseEntity::ok)
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }

   @PostMapping
   public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
       UserDTO createdUser = userService.createUser(userDTO);
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
   }

   @PutMapping("/{id}")
   public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
       Optional<UserDTO> updatedUser = userService.updateUser(id, userDTO);
       return updatedUser.map(ResponseEntity::ok)
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
       userService.deleteUser(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}

