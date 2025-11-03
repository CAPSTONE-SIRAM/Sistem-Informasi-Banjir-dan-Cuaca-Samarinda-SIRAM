/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
/**
 *
 * @author User
 */
@Converter(autoApply = true)
public class StatusTindakConverter implements AttributeConverter<StatusTindak, String> {

    @Override
    public String convertToDatabaseColumn(StatusTindak status) {
        if(status == null) return null;
        return status.getStatus();
    }

    @Override
    public StatusTindak convertToEntityAttribute(String dbStatus) {
        if(dbStatus == null) return null;
        return StatusTindak.fromString(dbStatus);
    }
}
