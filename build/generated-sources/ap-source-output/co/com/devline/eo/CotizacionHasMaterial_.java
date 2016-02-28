package co.com.devline.eo;

import co.com.devline.eo.Cotizacion;
import co.com.devline.eo.Material;
import co.com.devline.eo.TipoUniMedida;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-25T04:51:07")
@StaticMetamodel(CotizacionHasMaterial.class)
public class CotizacionHasMaterial_ { 

    public static volatile SingularAttribute<CotizacionHasMaterial, String> descripcion;
    public static volatile SingularAttribute<CotizacionHasMaterial, Integer> precio;
    public static volatile SingularAttribute<CotizacionHasMaterial, TipoUniMedida> idTipoUniMedida;
    public static volatile SingularAttribute<CotizacionHasMaterial, Cotizacion> idCotizacion;
    public static volatile SingularAttribute<CotizacionHasMaterial, Material> idMaterial;
    public static volatile SingularAttribute<CotizacionHasMaterial, Integer> cantidad;
    public static volatile SingularAttribute<CotizacionHasMaterial, Integer> idCotizacionHasMaterial;

}