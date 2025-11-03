/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.*;
/**
 *
 * @author User
 */

@Entity
@Table(name = "daerah")
public class Daerah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_daerah")
    private int idDaerah;

    @Column(name = "kecamatan", nullable = false, length = 100)
    private String kecamatan;

    public Daerah() {
    }

    public Daerah(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public int getIdDaerah() {
        return idDaerah;
    }

    public void setIdDaerah(int idDaerah) {
        this.idDaerah = idDaerah;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    @Override
    public String toString() {
        return kecamatan;
    }
}