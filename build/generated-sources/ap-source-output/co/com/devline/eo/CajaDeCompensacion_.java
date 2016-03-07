package co.com.devline.eo;

import co.com.devline.eo.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-06T15:19:01")
@StaticMetamodel(CajaDeCompensacion.class)
public class CajaDeCompensacion_ { 

    public static volatile SingularAttribute<CajaDeCompensacion, String> nombreCajaDeCompensacion;
    public static volatile CollectionAttribute<CajaDeCompensacion, Empleado> empleadoCollection;
    public static volatile SingularAttribute<CajaDeCompensacion, Integer> idCajaDeCompensacion;

}