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
@Table(name = "cuaca_panas")
@PrimaryKeyJoinColumn(name = "id_cuaca")
public class CuacaPanas extends Cuaca {

    @Column(name = "indeks_uv", nullable = false)
    private float indeksUV;

    @Enumerated(EnumType.STRING)
    @Column(name = "level_panas", nullable = false)
    private LevelPanas levelPanas;

    public float getIndeksUV() {
        return indeksUV;
    }

    public void setIndeksUV(float indeksUV) {
        this.indeksUV = indeksUV;
    }

    public LevelPanas getLevelPanas() {
        return levelPanas;
    }

    public void setLevelPanas(LevelPanas levelPanas) {
        this.levelPanas = levelPanas;
    }

    @Override
    public void tampil(JTable tabel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
    List<CuacaPanas> list = session.createQuery("FROM CuacaPanas ORDER BY tanggal DESC", CuacaPanas.class).list();
    session.close();

    DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Tanggal", "Kecamatan", "Suhu(°C)","Kelembapan(%)", "Indeks UV", "Level Panas"}, 0
    ){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    for (CuacaPanas c : list) {
        model.addRow(new Object[]{
            c.getTanggal(),
            c.getDaerah().getKecamatan(),
            c.getSuhu(),
            c.getKelembapan(),
            c.getIndeksUV(),
            c.getLevelPanas()
        });
    }
    tabel.setModel(model);
    tabel.getTableHeader().setReorderingAllowed(false);
    }
    
    public void tampilAdmin(JTable tabel) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<CuacaPanas> list = session.createQuery("FROM CuacaPanas ORDER BY tanggal DESC", CuacaPanas.class).list();
    session.close();

    DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "Tanggal", "Kecamatan", "Suhu(°C)", "Kelembapan(%)", "Indeks UV", "Level Panas"}, 0
    );
    for (CuacaPanas c : list) {
        model.addRow(new Object[]{
            c.getIdCuaca(),
            c.getTanggal(),
            c.getDaerah().getKecamatan(),
            c.getSuhu(),
            c.getKelembapan(),
            c.getIndeksUV(),
            c.getLevelPanas()
        });
    }

    tabel.setModel(model);
    tabel.getTableHeader().setReorderingAllowed(false);

}

}