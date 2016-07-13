package menu.model.beer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
abstract class AbstractRecord {

    @Id
    @GeneratedValue
    long id

}
