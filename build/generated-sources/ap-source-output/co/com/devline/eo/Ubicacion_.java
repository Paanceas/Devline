package co.com.devline.eo;

import co.com.devline.eo.Ciudad;
import co.com.devline.eo.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-22T17:07:56")
@StaticMetamodel(Ubicacion.class)
public class Ubicacion_ { 

    public static volatile SingularAttribute<Ubicacion, Pais> idPais;
    public static volatile CollectionAttribute<Ubicacion, Ciudad> ciudadCollection;
    public static volatile SingularAttribute<Ubicacion, Integer> idUbicacion;
    public static volatile SingularAttribute<Ubicacion, String> nombreUbicacion;

}