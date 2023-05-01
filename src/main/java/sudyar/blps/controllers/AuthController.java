package sudyar.blps.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sudyar.blps.dto.response.AuthResponse;
import sudyar.blps.entity.User;
import sudyar.blps.etc.AuthUser;
import sudyar.blps.etc.AuthUserWithRole;
import sudyar.blps.service.AuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
@Validated
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("sign-in")
    ResponseEntity<AuthResponse> signIn(@Valid @RequestBody AuthUser user) throws BadCredentialsException {
        return ResponseEntity.ok(authService.signIn(user));
    }

    @PostMapping("sign-up")
    ResponseEntity<AuthResponse> signUp(@Valid @RequestBody AuthUserWithRole newUser){
        return authService.signUp(newUser);
    }
}