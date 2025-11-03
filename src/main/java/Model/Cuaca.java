/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import javax.swing.JTable;


/**
 *
 * @author User
 */

@Entity
@Table(name = "cuaca")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cuaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuaca")
    protected int idCuaca;

    @Column(name = "tanggal", nullable = false)
    protected LocalDate tanggal = LocalDate.now();

    @Column(name = "suhu", nullable = false)
    protected float suhu;

    @Column(name = "kelembapan", nullable = false)
    protected float kelembapan;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_cuaca", nullable = false)
    protected StatusCuaca statusCuaca;

    @ManyToOne
    @JoinColumn(name = "id_daerah", nullable = false)
    protected Daerah daerah;

    public abstract void tampil(JTable tabel);
    
    public LocalDate getTanggal() {
        return tanggal;
    }

    // Getter & Setter
    public void setTanggal(LocalDate tanggal) {    
        this.tanggal = tanggal;
    }

    public int getIdCuaca() {
        return idCuaca;
    }

    public float getSuhu() {
        return suhu;
    }

    public void setSuhu(float suhu) {
        this.suhu = suhu;
    }

    public float getKelembapan() {
        return kelembapan;
    }

    public void setKelembapan(float kelembapan) {
        this.kelembapan = kelembapan;
    }

    public StatusCuaca getStatusCuaca() {
        return statusCuaca;
    }

    public void setStatusCuaca(StatusCuaca statusCuaca) {
        this.statusCuaca = statusCuaca;
    }

    public Daerah getDaerah() {
        return daerah;
    }

    public void setDaerah(Daerah daerah) {
        this.daerah = daerah;
    }
}

