package com.shop.spring.myshop.repo;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

@Repository
public interface MailSenderRepo extends JavaMailSender {

}
