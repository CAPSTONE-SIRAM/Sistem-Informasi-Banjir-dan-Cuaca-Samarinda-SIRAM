/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.HibernateUtil;
import jakarta.persistence.*;
import javax.swing.JTable;
import org.hibernate.Session;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */


@Entity
@Table(name = "cuaca_hujan")
@PrimaryKeyJoinColumn(name = "id_cuaca")
public class CuacaHujan extends Cuaca {

    @Column(name = "curah_hujan", nullable = false)
    private float curahHujan;

    @Enumerated(EnumType.STRING)
    @Column(name = "potensi_banjir", nullable = false)
    private PotensiBanjir potensiBanjir;

    public float getCurahHujan() {
        return curahHujan;
    }

    public void setCurahHujan(float curahHujan) {
        this.curahHujan = curahHujan;
    }

    public PotensiBanjir getPotensiBanjir() {
        return potensiBanjir;
    }

    public void setPotensiBanjir(PotensiBanjir potensiBanjir) {
        this.potensiBanjir = potensiBanjir;
    }

    @Override
    public void tampil(JTable tabel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CuacaHujan> list = session.createQuery("FROM CuacaHujan ORDER BY tanggal DESC", CuacaHujan.class).list();
        session.close();

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Tanggal", "Kecamatan", "Suhu(°C)", "Kelembapan(%)", "Curah Hujan(mm)", "Potensi Banjir"}, 0
        ){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
        for (CuacaHujan c : list) {
            model.addRow(new Object[]{
                c.getTanggal(),
                c.getDaerah().getKecamatan(),
                c.getSuhu(),
                c.getKelembapan(),
                c.getCurahHujan(),
                c.getPotensiBanjir()
            });
        }

        tabel.setModel(model);
        tabel.getTableHeader().setReorderingAllowed(false);
    }

    public void tampilAdmin(JTable tabel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CuacaHujan> list = session.createQuery("FROM CuacaHujan ORDER BY tanggal DESC", CuacaHujan.class).list();
        session.close();

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID", "Tanggal", "Kecamatan", "Suhu(°C)", "Kelembapan(%)", "Curah Hujan(mm)", "Potensi Banjir"}, 0
        ){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
        for (CuacaHujan c : list) {
            model.addRow(new Object[]{
                c.getIdCuaca(),
                c.getTanggal(),
                c.getDaerah().getKecamatan(),
                c.getSuhu(),
                c.getKelembapan(),
                c.getCurahHujan(),
                c.getPotensiBanjir()
            });
        }

        tabel.setModel(model);
        tabel.getTableHeader().setReorderingAllowed(false);
    }
}
