package taproommenu.businesslogic.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The business logic for a beer to display on the taproom menu
 */
@Entity
public class Beer {

    @Id
    @GeneratedValue
    long id
    String name


}
