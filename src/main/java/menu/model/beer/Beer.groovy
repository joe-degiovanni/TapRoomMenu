package menu.model.beer

import org.springframework.beans.factory.annotation.Autowired

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
    Integer id
    String name


}
