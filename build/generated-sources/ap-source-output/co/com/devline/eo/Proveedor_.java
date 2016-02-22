package co.com.devline.eo;

import co.com.devline.eo.Ciudad;
import co.com.devline.eo.ProveedorHasMaterial;
import co.com.devline.eo.TipoIdentificacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-22T17:07:56")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile CollectionAttribute<Proveedor, ProveedorHasMaterial> proveedorHasMaterialCollection;
    public static volatile SingularAttribute<Proveedor, Boolean> eliminar;
    public static volatile SingularAttribute<Proveedor, Integer> idProveedor;
    public static volatile SingularAttribute<Proveedor, String> correo;
    public static volatile SingularAttribute<Proveedor, TipoIdentificacion> idTipoIdentificacion;
    public static volatile SingularAttribute<Proveedor, String> direccion;
    public static volatile SingularAttribute<Proveedor, String> celular;
    public static volatile SingularAttribute<Proveedor, String> identificacion;
    public static volatile SingularAttribute<Proveedor, String> telefono;
    public static volatile SingularAttribute<Proveedor, String> nombre;
    public static volatile SingularAttribute<Proveedor, Ciudad> idCiudad;

}