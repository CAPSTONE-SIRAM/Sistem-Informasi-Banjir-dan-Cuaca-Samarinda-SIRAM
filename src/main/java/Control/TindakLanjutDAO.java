/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.TindakLanjut;
import java.util.List;
/**
 *
 * @author User
 */
public interface TindakLanjutDAO {
    void create(TindakLanjut tindak);
    TindakLanjut findById(int id);
    List<TindakLanjut> findAll();
    void update(TindakLanjut tindak);
    void delete(int id);
}