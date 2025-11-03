/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 *
 * @author User
 */
@Entity
@Table(name = "laporan")
public class Laporan {
    
    public enum StatusBanjir {
        MASIH_BANJIR,
        SUDAH_SURUT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laporan")
    private int idLaporan;

    @Column(name = "tanggal_laporan", nullable = false)
    private LocalDate tanggalLaporan = LocalDate.now();

    @Column(name = "tinggi_air",nullable = false)
    private float tinggiAir;

    @Column(name = "lokasi", nullable = false, length = 500)
    private String lokasi;

    @Lob
    @Column(name = "foto_bukti", columnDefinition = "MEDIUMBLOB")
    private byte[] fotoBukti;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_banjir", nullable = false, length = 20)
    private StatusBanjir status = StatusBanjir.MASIH_BANJIR;
   
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "id_daerah", nullable = false)
    private Daerah daerah;

    public Laporan() {
    }

    public Laporan(float tinggiAir, String lokasi, byte[] fotoBukti, StatusBanjir status, Users user, Daerah daerah) {
        this.tinggiAir = tinggiAir;
        this.lokasi = lokasi;
        this.fotoBukti = fotoBukti;
        this.status = status;
        this.user = user;
        this.daerah = daerah;
    }

    public int getIdLaporan() {
        return idLaporan;
    }

    public LocalDate getTanggalLaporan() {
        return tanggalLaporan;
    }

    public void setTanggalLaporan(LocalDate tanggalLaporan) {
        this.tanggalLaporan = tanggalLaporan;
    }

    public float getTinggiAir() {
        return tinggiAir;
    }

    public void setTinggiAir(float tinggiAir) {
        this.tinggiAir = tinggiAir;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public byte[] getFotoBukti() {
        return fotoBukti;
    }

    public void setFotoBukti(byte[] fotoBukti) {
        this.fotoBukti = fotoBukti;
    }

    public StatusBanjir getStatus() {
        return status;
    }

    public void setStatus(StatusBanjir status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Daerah getDaerah() {
        return daerah;
    }

    public void setDaerah(Daerah daerah) {
        this.daerah = daerah;
    }
}
