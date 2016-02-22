package co.com.devline.eo;

import co.com.devline.eo.Cliente;
import co.com.devline.eo.CotizacionHasMaterial;
import co.com.devline.eo.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-22T17:07:56")
@StaticMetamodel(Cotizacion.class)
public class Cotizacion_ { 

    public static volatile SingularAttribute<Cotizacion, Date> fechaCotizacion;
    public static volatile CollectionAttribute<Cotizacion, CotizacionHasMaterial> cotizacionHasMaterialCollection;
    public static volatile SingularAttribute<Cotizacion, String> notaInicio;
    public static volatile SingularAttribute<Cotizacion, Boolean> eliminar;
    public static volatile SingularAttribute<Cotizacion, Cliente> idCliente;
    public static volatile SingularAttribute<Cotizacion, Float> iva;
    public static volatile SingularAttribute<Cotizacion, String> notaFinal;
    public static volatile SingularAttribute<Cotizacion, Integer> idCotizacion;
    public static volatile CollectionAttribute<Cotizacion, Proyecto> proyectoCollection;

}