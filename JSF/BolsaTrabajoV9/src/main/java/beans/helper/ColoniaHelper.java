package beans.helper;

import beans.model.Colonia;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class ColoniaHelper {
    public List<Colonia> getColonias() {
        List<Colonia> colonias = new ArrayList<>();
        int coloniaId = 1;
        Colonia colonia = new Colonia(coloniaId++, "Napoles", 3810);
        colonias.add(colonia);
        colonia = new Colonia(coloniaId++, "Polanco", 11530);
        colonias.add(colonia);
        colonia = new Colonia(coloniaId++, "Del Valle Centro", 3100);
        colonias.add(colonia);

        return colonias;
    }

    public int getColoniaIdPorNombre(String nombre) {
        int coloniaId = 0;
        for (Colonia colonia : getColonias()) {
            if (colonia.getNombreColonia().equals(nombre)) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }

    public int getColoniaIdPorCodigoPostal(int codigoPostal) {
        int coloniaId = 0;
        for (Colonia colonia : getColonias()) {
            if (colonia.getCodigoPostal() == codigoPostal) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }

    public List<SelectItem> getSelectItems() {
        List<SelectItem> selectItems = new ArrayList<>();
        for (Colonia colonia : getColonias()) {
            selectItems.add(new SelectItem(colonia.getColoniaId(), colonia.getNombreColonia()));
        }
        return selectItems;
    }

}
