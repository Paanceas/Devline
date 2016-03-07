package co.com.devline.eo;

import co.com.devline.eo.CajaDeCompensacion;
import co.com.devline.eo.Cargo;
import co.com.devline.eo.Ciudad;
import co.com.devline.eo.EmpleadoHasProyecto;
import co.com.devline.eo.Pension;
import co.com.devline.eo.Salud;
import co.com.devline.eo.TipoIdentificacion;
import co.com.devline.eo.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-06T15:19:01")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, Salud> idSalud;
    public static volatile SingularAttribute<Empleado, Pension> idPension;
    public static volatile SingularAttribute<Empleado, TipoIdentificacion> idTipoIdentificacion;
    public static volatile SingularAttribute<Empleado, Usuario> idUsuario;
    public static volatile SingularAttribute<Empleado, String> direccion;
    public static volatile CollectionAttribute<Empleado, EmpleadoHasProyecto> empleadoHasProyectoCollection;
    public static volatile SingularAttribute<Empleado, String> documento;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile SingularAttribute<Empleado, Ciudad> idCiudad;
    public static volatile SingularAttribute<Empleado, Date> fechaIngreso;
    public static volatile SingularAttribute<Empleado, Cargo> idCargo;
    public static volatile SingularAttribute<Empleado, Boolean> eliminar;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile SingularAttribute<Empleado, String> correo;
    public static volatile SingularAttribute<Empleado, String> celular;
    public static volatile SingularAttribute<Empleado, String> arl;
    public static volatile SingularAttribute<Empleado, Date> fechaRetiro;
    public static volatile SingularAttribute<Empleado, String> telefono;
    public static volatile SingularAttribute<Empleado, CajaDeCompensacion> idCajaDeCompensacion;

}