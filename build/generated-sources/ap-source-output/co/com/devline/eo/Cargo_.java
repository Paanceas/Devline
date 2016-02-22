package co.com.devline.eo;

import co.com.devline.eo.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-22T17:07:56")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, Integer> idCargo;
    public static volatile SingularAttribute<Cargo, String> nombreCargo;
    public static volatile CollectionAttribute<Cargo, Empleado> empleadoCollection;

}