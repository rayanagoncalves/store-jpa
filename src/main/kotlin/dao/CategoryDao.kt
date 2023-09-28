package dao

import model.Category
import model.Product
import javax.persistence.EntityManager

class CategoryDao(private val entityManager: EntityManager) {

    fun register(category: Category) {
        this.entityManager.persist(category)
    }

}