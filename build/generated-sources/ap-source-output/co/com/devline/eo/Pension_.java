package co.com.devline.eo;

import co.com.devline.eo.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-25T04:51:07")
@StaticMetamodel(Pension.class)
public class Pension_ { 

    public static volatile SingularAttribute<Pension, Integer> idPension;
    public static volatile SingularAttribute<Pension, String> nombrePension;
    public static volatile CollectionAttribute<Pension, Empleado> empleadoCollection;

}