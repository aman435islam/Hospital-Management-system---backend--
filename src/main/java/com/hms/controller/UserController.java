package com.hms.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hms.dao.UserDAO;
import com.hms.model.User;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController{


    @Autowired
    private UserDAO userDAO;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User matchedUser = userDAO.getByUsernameAndPassword(user.getUsername(), user.getPassword(), user.getUserRole());
        if (matchedUser != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("id", matchedUser.getId());
            response.put("username", matchedUser.getUsername());
            response.put("name", matchedUser.getName());
            response.put("role", matchedUser.getUserRole());
            response.put("imageUrl", matchedUser.getImageUrl());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userDAO.save(user);
    }

    @PostMapping("/upload-image/{id}")
    public ResponseEntity<String> uploadImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {
        try {
            String folder = "uploads/";
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(folder + fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            User user = userDAO.getUserById(id);
            user.setImageUrl(fileName);
            userDAO.save(user);

            return ResponseEntity.ok("Image uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed");
        }
    }
    
    
//    @PostMapping("/upload-image/{id}")
//    public ResponseEntity<Map<String, String>> uploadImage(
//        @PathVariable Long id, @RequestParam("image") MultipartFile file) {
//        try {
//            String folderPath = "uploads/";
//            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//            Path path = Paths.get(folderPath + fileName);
//            Files.createDirectories(path.getParent());
//            Files.write(path, file.getBytes());
//
//            User user = userDAO.getUserById(id);
//            user.setImageUrl(fileName);
//            userDAO.save(user);
//
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Image uploaded successfully");
//            response.put("imageUrl", fileName);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//        	
//        	Map<String, String> response = new HashMap<>();
//        	response.put("message", "Failed to upload image");
//        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//        }
//    }
    
    
    

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username) {
        User user = userDAO.getUserByUsername(username);
        if (user != null) return ResponseEntity.ok(user);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/register")
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @GetMapping("/register/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userDAO.getUserById(id);
        return ResponseEntity.ok(user);
    }
  
}















//@Autowired
//UserDAO userDAO;
//
////@PostMapping("/login")
////public User login(@RequestBody User user) {
////	return userDAO.getByUsername(user);
////}
//
//@PostMapping("/login")
//public ResponseEntity<?> login(@RequestBody User user) {
//    User matchedUser = userDAO.getByUsernameAndPassword(user.getUsername(), user.getPassword(), user.getUserRole());
//
//    if (matchedUser != null) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("username", matchedUser.getUsername());
//        response.put("role", matchedUser.getUserRole());
//        return ResponseEntity.ok(response);
//    } else {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//    }
//}
//
//
//@PostMapping("/upload-image/{id}")
//public ResponseEntity<?> uploadImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {
//    try {
//        String folderPath = "uploads/";
//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//        Path path = Paths.get(folderPath + fileName);
//        Files.createDirectories(path.getParent());
//        Files.write(path, file.getBytes());
//
//        User user = userDAO.getUserById(id);
//        user.setImageUrl(fileName);
//        userDAO.save(user);
//
//        return ResponseEntity.ok("Image uploaded successfully");
//    } catch (Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
//    }
//}
//
//
//@GetMapping("/register")
//public List<User> getAll() {
//    return userDAO.getAll();
//}
//
//@GetMapping("/register/{id}")
//public ResponseEntity<User> getById(@PathVariable(value = "id") Long userId) {
//	User user = userDAO.getUserById(userId);
//    return ResponseEntity.ok().body(user);
//}
//
//@PostMapping("/register")
//public User save(@RequestBody User user) {
//	return userDAO.save(user);
//}
//

