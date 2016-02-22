package co.com.devline.eo;

import co.com.devline.eo.Cliente;
import co.com.devline.eo.Empleado;
import co.com.devline.eo.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-22T17:07:56")
@StaticMetamodel(TipoIdentificacion.class)
public class TipoIdentificacion_ { 

    public static volatile SingularAttribute<TipoIdentificacion, String> tipoIdentificacion;
    public static volatile CollectionAttribute<TipoIdentificacion, Empleado> empleadoCollection;
    public static volatile CollectionAttribute<TipoIdentificacion, Proveedor> proveedorCollection;
    public static volatile SingularAttribute<TipoIdentificacion, Integer> idTipoIdentificacion;
    public static volatile CollectionAttribute<TipoIdentificacion, Cliente> clienteCollection;

}