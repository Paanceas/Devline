package co.com.devline.eo;

import co.com.devline.eo.Empleado;
import co.com.devline.eo.Roll;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-22T17:07:56")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, Boolean> eliminar;
    public static volatile CollectionAttribute<Usuario, Empleado> empleadoCollection;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, Roll> tipoRoll;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;

}