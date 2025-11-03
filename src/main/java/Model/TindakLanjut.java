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
@Table(name = "tindak_lanjut")
public class TindakLanjut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tindak")
    private int idTindak;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_laporan", nullable = false)
    private Laporan laporan;

    @Column(name = "bentuk_penanganan", nullable = false, length = 255)
    private String bentukPenanganan;

    @Column(name = "tanggal_tindak", nullable = false)
    private LocalDate tanggalTindak;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusTindak statusTindak;

    // ===== Constructor =====
    public TindakLanjut() {}

    public TindakLanjut(Laporan laporan, String bentukPenanganan, LocalDate tanggalTindak, StatusTindak statusTindak) {
        this.laporan = laporan;
        this.bentukPenanganan = bentukPenanganan;
        this.tanggalTindak = tanggalTindak;
        this.statusTindak = statusTindak;
    }

    // ===== Getter & Setter =====
    public int getIdTindak() {
        return idTindak;
    }

    public void setIdTindak(int idTindak) {
        this.idTindak = idTindak;
    }
    

    public Laporan getLaporan() {
        return laporan;
    }

    public void setLaporan(Laporan laporan) {
        this.laporan = laporan;
    }

    public String getBentukPenanganan() {
        return bentukPenanganan;
    }

    public void setBentukPenanganan(String bentukPenanganan) {
        this.bentukPenanganan = bentukPenanganan;
    }

    public LocalDate getTanggalTindak() {
        return tanggalTindak;
    }

    public void setTanggalTindak(LocalDate tanggalTindak) {
        this.tanggalTindak = tanggalTindak;
    }

    public StatusTindak getStatusTindak() {
        return statusTindak;
    }

    public void setStatusTindak(StatusTindak statusTindak) {
        this.statusTindak = statusTindak;
    }
}
