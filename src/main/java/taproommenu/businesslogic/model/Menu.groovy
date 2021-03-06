package taproommenu.businesslogic.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany

@Entity
class Menu extends AbstractEntity {

    @Id
    @GeneratedValue
    long id

    String name

    @OneToMany
    @JoinTable(
                    name="MENU_BEER",
                    joinColumns=[ @JoinColumn(name="MENU_ID", referencedColumnName="id") ],
                    inverseJoinColumns=[ @JoinColumn(name="BEER_ID", referencedColumnName="id", unique=true) ]
            )
    List<Beer> beerList

}
