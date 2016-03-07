package co.com.devline.eo;

import co.com.devline.eo.Ubicacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-06T15:19:01")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> abreviatura;
    public static volatile SingularAttribute<Pais, Integer> idPais;
    public static volatile CollectionAttribute<Pais, Ubicacion> ubicacionCollection;
    public static volatile SingularAttribute<Pais, String> nombrePais;

}