package co.com.devline.eo;

import co.com.devline.eo.Cliente;
import co.com.devline.eo.Empleado;
import co.com.devline.eo.Proveedor;
import co.com.devline.eo.Ubicacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-06T15:19:00")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, String> nombreCiudad;
    public static volatile CollectionAttribute<Ciudad, Empleado> empleadoCollection;
    public static volatile CollectionAttribute<Ciudad, Proveedor> proveedorCollection;
    public static volatile SingularAttribute<Ciudad, Ubicacion> idUbicacion;
    public static volatile SingularAttribute<Ciudad, Integer> idCiudad;
    public static volatile CollectionAttribute<Ciudad, Cliente> clienteCollection;

}