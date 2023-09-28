package model

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String,
    val price: BigDecimal,
    @Column(name = "created_at")
    val createdAt: LocalDate = LocalDate.now(),
    @ManyToOne
    val category: Category
) {
}