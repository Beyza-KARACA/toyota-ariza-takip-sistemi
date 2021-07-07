package com.toyota.security;

import org.springframework.security.crypto.password.PasswordEncoder;

//default'ta spring security, şifreyi encode ediyor. Biz veritabanında açık tuttuğumuzdan dolayı
//custom bir encoder yazdım, bu encoder gelen şifreyi direk string olarak karşılaştırıyor. Encode/Decode işlemine
//ihtiyaç duyulmuyor
public class PasswordEnconderDisabler implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}