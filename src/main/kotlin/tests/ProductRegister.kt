package tests

import dao.CategoryDao
import dao.ProductDao
import model.Category
import model.Product
import java.math.BigDecimal
import javax.persistence.Persistence

fun main() {
    registerProduct()
    val entityManagerFactory = Persistence.createEntityManagerFactory("store")
    val entityManager = entityManagerFactory.createEntityManager()
    val productDao = ProductDao(entityManager!!)

    val product = productDao.findById(1L)
    println(product.price)

    val allProducts = productDao.findAll()
    allProducts.forEach{ println(it.name) }
}

fun registerProduct() {
    val category = Category(name = "CELLPHONES")
    val product = Product(name = "iphone", description = "teste", price = BigDecimal.valueOf(1000), category = category)

    val entityManagerFactory = Persistence.createEntityManagerFactory("store")
    val entityManager = entityManagerFactory.createEntityManager()
    val productDao = ProductDao(entityManager!!)
    val categoryDao = CategoryDao(entityManager!!)

    entityManager.transaction.begin()
    categoryDao.register(category = category)
    productDao.register(product = product)
    entityManager.transaction.commit()
    entityManager.close()
}