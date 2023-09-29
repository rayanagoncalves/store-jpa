package dao

import model.Product
import javax.persistence.EntityManager

class ProductDao(private val entityManager: EntityManager) {

    fun register(product: Product) {
        this.entityManager.persist(product)
    }

    fun update(product: Product) {
        this.entityManager.merge(product)
    }

    fun delete(product: Product) {
        this.entityManager.remove(entityManager.merge(product))
    }

    fun findById(id: Long): Product = this.entityManager.find(Product::class.java, id)

    fun findAll(): List<Product> {
        val jpql = "SELECT p FROM Product p"
        return this.entityManager.createQuery(jpql, Product::class.java).resultList
    }
}