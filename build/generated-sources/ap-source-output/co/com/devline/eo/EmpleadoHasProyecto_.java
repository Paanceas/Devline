package co.com.devline.eo;

import co.com.devline.eo.Empleado;
import co.com.devline.eo.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-06T15:19:01")
@StaticMetamodel(EmpleadoHasProyecto.class)
public class EmpleadoHasProyecto_ { 

    public static volatile SingularAttribute<EmpleadoHasProyecto, Proyecto> idProyecto;
    public static volatile SingularAttribute<EmpleadoHasProyecto, Empleado> idEmpleado;
    public static volatile SingularAttribute<EmpleadoHasProyecto, Integer> idEmpleadoHasProyecto;

}