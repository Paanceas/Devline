package co.com.devline.eo;

import co.com.devline.eo.MaterialHasAdquisicion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-22T17:07:56")
@StaticMetamodel(Adquisicion.class)
public class Adquisicion_ { 

    public static volatile SingularAttribute<Adquisicion, Date> fechaAdquisicion;
    public static volatile SingularAttribute<Adquisicion, Integer> idAdquisicion;
    public static volatile CollectionAttribute<Adquisicion, MaterialHasAdquisicion> materialHasAdquisicionCollection;
    public static volatile SingularAttribute<Adquisicion, Integer> valorTotalAdquisicion;

}