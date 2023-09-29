package dao

import model.Product
import java.math.BigDecimal
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

    fun findByName(name: String): List<Product> {
        val jpql = "SELECT p FROM Product p WHERE p.name = ?1"
      //  val jpql = "SELECT p FROM Product p WHERE p.name = :name" -> outra forma de passar o parametro
        return this.entityManager.createQuery(jpql, Product::class.java)
            .setParameter(1, name)
       //     .setParameter("name", name)
            .resultList
    }

    fun findByCategoryName(categoryName: String): List<Product> {
        val jpql = "SELECT p FROM Product p WHERE p.category.name = :name"
        return this.entityManager.createQuery(jpql, Product::class.java)
            .setParameter("name", categoryName)
            .resultList
    }

    fun findByPriceWithName(name: String): BigDecimal {
        val jpql = "SELECT p.price FROM Product p WHERE p.name = :name"
        return this.entityManager.createQuery(jpql, BigDecimal::class.java)
            .setParameter("name", name)
            .singleResult
    }
}