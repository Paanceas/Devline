package co.com.devline.eo;

import co.com.devline.eo.Categoria;
import co.com.devline.eo.CotizacionHasMaterial;
import co.com.devline.eo.MaterialHasAdquisicion;
import co.com.devline.eo.ProveedorHasMaterial;
import co.com.devline.eo.TipoUniMedida;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-06T15:19:01")
@StaticMetamodel(Material.class)
public class Material_ { 

    public static volatile SingularAttribute<Material, Integer> cantidadTotal;
    public static volatile CollectionAttribute<Material, CotizacionHasMaterial> cotizacionHasMaterialCollection;
    public static volatile SingularAttribute<Material, Integer> precioUnitario;
    public static volatile CollectionAttribute<Material, ProveedorHasMaterial> proveedorHasMaterialCollection;
    public static volatile SingularAttribute<Material, String> descripcionMaterial;
    public static volatile SingularAttribute<Material, TipoUniMedida> idTipoUniMedida;
    public static volatile SingularAttribute<Material, Integer> idMaterial;
    public static volatile SingularAttribute<Material, Categoria> idCategoria;
    public static volatile CollectionAttribute<Material, MaterialHasAdquisicion> materialHasAdquisicionCollection;
    public static volatile SingularAttribute<Material, String> codigoMaterial;
    public static volatile SingularAttribute<Material, String> nombreMaterial;

}