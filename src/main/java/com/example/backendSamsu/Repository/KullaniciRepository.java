package com.example.backendSamsu.Repository;

import com.example.backendSamsu.Model.KullaniciModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepository extends JpaRepository<KullaniciModel, Long> {
    KullaniciModel findByKullaniciAdi(String kullaniciAdi);
}
