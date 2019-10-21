package com.shop.spring.myshop.controller;

import com.shop.spring.myshop.dto.PasswordForgotDTO;
import com.shop.spring.myshop.model.AppUser;
import com.shop.spring.myshop.model.sendmail.Mail;
import com.shop.spring.myshop.model.sendmail.PasswordResetToken;
import com.shop.spring.myshop.repo.PasswordResetTokenRepository;
import com.shop.spring.myshop.service.impl.EmailService;
import com.shop.spring.myshop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/forgot-password")
public class PasswordForgotController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    PasswordResetTokenRepository tokenRepository;

    @Autowired private EmailService emailService;

    @ModelAttribute("forgotPasswordForm")
    public PasswordForgotDTO forgotPasswordDto() {
        return new PasswordForgotDTO();
    }

    @GetMapping
    public String displayForgotPasswordPage() {
        return "client/forgot-password";
    }

    @PostMapping
    public String processForgotPasswordForm(@ModelAttribute("forgotPasswordForm") @Valid PasswordForgotDTO form,
                                            BindingResult result,
                                            HttpServletRequest request){
        if (result.hasErrors()){
            return "client/forgot-password";
        }

        AppUser user = userService.findByEmail(form.getEmail());
        if (user == null){
            result.rejectValue("email", null, "We could not find an account for that e-mail address.");
            return "client/forgot-password";
        }

        PasswordResetToken token = new PasswordResetToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        token.setExpiryDate(30);
        tokenRepository.save(token);

        Mail mail = new Mail();
        mail.setFrom("no-reply@memorynotfound.com");
        mail.setTo(user.getEmail());
        mail.setSubject("Password reset request");

        Map<String, Object> model = new HashMap<>();
        model.put("token", token);
        model.put("user", user);
        model.put("signature", "https://memorynotfound.com");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        model.put("resetUrl", url + "/client/reset-password?token=" + token.getToken());
        mail.setModel(model);
        emailService.sendEmail(mail);

        return "redirect:/client/forgot-password?success";
    }
}
