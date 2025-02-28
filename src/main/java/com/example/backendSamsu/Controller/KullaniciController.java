package com.example.backendSamsu.Controller;

import com.example.backendSamsu.Model.KullaniciModel;
import com.example.backendSamsu.Model.KullaniciRoluEnum;
import com.example.backendSamsu.Service.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KullaniciController {

    @Autowired
    private KullaniciService kullaniciService;

    @GetMapping("/login")
    public String getLoginAndRegisterForm(Model model) {
        model.addAttribute("roles", KullaniciRoluEnum.values());
        return "girisKayit";
    }

    @PostMapping("/login")
    public String loginOrKayit(@RequestParam String kullaniciAdi, @RequestParam String sifre,
                               @RequestParam(required = false) String islem, @RequestParam(required = false) String rol,
                               Model model) {
        if ("kayit".equals(islem)) {
            KullaniciModel kullanici = new KullaniciModel();
            kullanici.setKullaniciAdi(kullaniciAdi);
            kullanici.setSifre(sifre);
            kullanici.setKullaniciRoluEnum(KullaniciRoluEnum.valueOf(rol));
            kullaniciService.saveKullanici(kullanici);
            return "redirect:/login?success=true";
        }

        KullaniciModel kullanici = kullaniciService.findByUserName(kullaniciAdi);
        if (kullanici != null && kullanici.getSifre().equals(sifre)) {
            model.addAttribute("kullaniciRolu", kullanici.getKullaniciRoluEnum().name());
            if (kullanici.getKullaniciRoluEnum() == KullaniciRoluEnum.MUHENDIS) {
                return "redirect:/muhendisEkrani";
            } else if (kullanici.getKullaniciRoluEnum() == KullaniciRoluEnum.ADMIN) {
                return "adminEkrani";
            } else if (kullanici.getKullaniciRoluEnum() == KullaniciRoluEnum.MUHASEBECI) {
                return "redirect:/muhasebeciEkrani";
            }
        }
        return "redirect:/login?error=true";
    }

    @GetMapping("/adminEkrani")
    public String adminEkrani() {
        return "adminEkrani";
    }

    @GetMapping("/muhendisEkrani")
    public String muhendisEkrani() {
        return "muhendisEkrani";
    }

    @GetMapping("/muhasebeciEkrani")
    public String muhasebeciEkrani() {
        return "muhasebeciEkrani";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}