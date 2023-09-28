package tests

import dao.ProductDao
import model.Product
import java.math.BigDecimal
import javax.persistence.Persistence

fun main() {
    val product = Product(name = "iphone", description = "teste", price = BigDecimal.valueOf(1000), category = Product.Category.CELLPHONES)

    val entityManagerFactory = Persistence.createEntityManagerFactory("store")
    val entityManager = entityManagerFactory.createEntityManager()
    val productDao = ProductDao(entityManager!!)

    entityManager.transaction.begin()
    productDao.register(product)
    entityManager.transaction.commit()
    entityManager.close()
}
