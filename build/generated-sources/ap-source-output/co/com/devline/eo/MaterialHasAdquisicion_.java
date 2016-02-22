package co.com.devline.eo;

import co.com.devline.eo.Adquisicion;
import co.com.devline.eo.Material;
import co.com.devline.eo.TipoUniMedida;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-22T17:07:56")
@StaticMetamodel(MaterialHasAdquisicion.class)
public class MaterialHasAdquisicion_ { 

    public static volatile SingularAttribute<MaterialHasAdquisicion, TipoUniMedida> idTipoUniMedida;
    public static volatile SingularAttribute<MaterialHasAdquisicion, Adquisicion> idAdquisicion;
    public static volatile SingularAttribute<MaterialHasAdquisicion, Integer> idMaterialHasAdquisicion;
    public static volatile SingularAttribute<MaterialHasAdquisicion, Material> idMaterial;

}