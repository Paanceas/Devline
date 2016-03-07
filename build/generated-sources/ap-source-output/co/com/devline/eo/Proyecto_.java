package co.com.devline.eo;

import co.com.devline.eo.Cotizacion;
import co.com.devline.eo.EmpleadoHasProyecto;
import co.com.devline.eo.Estado;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-06T15:19:01")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, Integer> idProyecto;
    public static volatile SingularAttribute<Proyecto, Estado> idEstado;
    public static volatile SingularAttribute<Proyecto, Date> fechaInicioProyecto;
    public static volatile SingularAttribute<Proyecto, Boolean> eliminar;
    public static volatile SingularAttribute<Proyecto, Date> fechaFinalProyecto;
    public static volatile SingularAttribute<Proyecto, String> descripcionProyecto;
    public static volatile CollectionAttribute<Proyecto, EmpleadoHasProyecto> empleadoHasProyectoCollection;
    public static volatile SingularAttribute<Proyecto, String> codigoProyecto;
    public static volatile SingularAttribute<Proyecto, String> nombreProyecto;
    public static volatile SingularAttribute<Proyecto, Integer> valorAnticipado;
    public static volatile SingularAttribute<Proyecto, Cotizacion> idCotizacion;
    public static volatile SingularAttribute<Proyecto, Integer> valorTotalProyecto;

}