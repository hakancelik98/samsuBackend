package com.example.backandSamsu.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "kullanici")
public class KullaniciModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kullaniciAdi;
    private String sifre;

    @Enumerated(EnumType.STRING)
    private KullaniciRoluEnum kullaniciRoluEnum;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public KullaniciRoluEnum getKullaniciRoluEnum() {
        return kullaniciRoluEnum;
    }
    public void setKullaniciRoluEnum(KullaniciRoluEnum kullaniciRoluEnum) {
        this.kullaniciRoluEnum = kullaniciRoluEnum;
    }
}
