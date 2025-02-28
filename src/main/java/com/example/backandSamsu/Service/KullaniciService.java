package com.example.backandSamsu.Service;
import com.example.backandSamsu.Model.KullaniciModel;
import com.example.backandSamsu.Repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KullaniciService {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    public KullaniciModel saveKullanici(KullaniciModel kullanici) {
        return kullaniciRepository.save(kullanici);
    }

    public KullaniciModel findByUserName(String kullaniciAdi) {
        return kullaniciRepository.findByKullaniciAdi(kullaniciAdi);
    }
}