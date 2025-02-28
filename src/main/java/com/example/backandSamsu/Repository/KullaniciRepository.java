package com.example.backandSamsu.Repository;

import com.example.backandSamsu.Model.KullaniciModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepository extends JpaRepository<KullaniciModel, Long> {
    KullaniciModel findByKullaniciAdi(String kullaniciAdi);
}
