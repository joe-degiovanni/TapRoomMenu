package taproommenu.businesslogic.model

import taproommenu.businesslogic.model.Beer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany

@Entity
class Menu {

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
