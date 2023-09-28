package tests

import model.Product
import java.math.BigDecimal
import javax.persistence.Persistence

fun main() {
    val product = Product(name = "iphone", description = "teste", price = BigDecimal.valueOf(1000))

    val entityManagerFactory = Persistence.createEntityManagerFactory("store")
    val entityManager = entityManagerFactory.createEntityManager()

    entityManager.transaction.begin()
    entityManager.persist(product)
    entityManager.transaction.commit()
    entityManager.close()
}