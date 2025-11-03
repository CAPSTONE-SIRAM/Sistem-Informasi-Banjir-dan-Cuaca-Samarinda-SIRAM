/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.Cuaca;
import java.util.List;
/**
 *
 * @author User
 */
public interface CuacaDAO {
     void insert(Cuaca cuaca);

    void update(Cuaca cuaca);

    void delete(int idCuaca);

    Cuaca getById(int idCuaca);

    List<Cuaca> getAll();
}
