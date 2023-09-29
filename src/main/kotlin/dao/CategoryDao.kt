package dao

import model.Category
import javax.persistence.EntityManager

class CategoryDao(private val entityManager: EntityManager) {

    fun register(category: Category) {
        this.entityManager.persist(category)
    }

    fun update(category: Category) {
        this.entityManager.merge(category)
    }

    fun delete(category: Category) {
        this.entityManager.remove(entityManager.merge(category))
    }

}