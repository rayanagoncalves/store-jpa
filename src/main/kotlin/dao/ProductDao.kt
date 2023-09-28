package dao

import model.Product
import javax.persistence.EntityManager

class ProductDao(private val entityManager: EntityManager) {

    fun register(product: Product) {
        this.entityManager.persist(product)
    }

}