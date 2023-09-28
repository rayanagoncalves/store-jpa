package model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "produtos")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var description: String,
    var price: BigDecimal
) {
}