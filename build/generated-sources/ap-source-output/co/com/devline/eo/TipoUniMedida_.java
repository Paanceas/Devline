package co.com.devline.eo;

import co.com.devline.eo.CotizacionHasMaterial;
import co.com.devline.eo.Material;
import co.com.devline.eo.MaterialHasAdquisicion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-22T17:07:56")
@StaticMetamodel(TipoUniMedida.class)
public class TipoUniMedida_ { 

    public static volatile CollectionAttribute<TipoUniMedida, CotizacionHasMaterial> cotizacionHasMaterialCollection;
    public static volatile CollectionAttribute<TipoUniMedida, Material> materialCollection;
    public static volatile SingularAttribute<TipoUniMedida, String> abreviatura;
    public static volatile SingularAttribute<TipoUniMedida, Integer> idTipoUniMedida;
    public static volatile SingularAttribute<TipoUniMedida, String> nombreTipoUniMedida;
    public static volatile CollectionAttribute<TipoUniMedida, MaterialHasAdquisicion> materialHasAdquisicionCollection;

}