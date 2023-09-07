package eif.viko.lt.faculty.app.domain.repositories

import eif.viko.lt.faculty.app.data.remote.mappers.ProductPageDto
import eif.viko.lt.faculty.app.data.remote.mappers.Products
import eif.viko.lt.faculty.app.domain.models.Category
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ShopRepository {
    fun getAllCategories(): Flow<Resource<List<Category>>>
    suspend fun createCategory(name: String)
    suspend fun getCategoryById(id: Int)
    suspend fun deleteCategoryById(id: Int)
    suspend fun createProduct()
    fun getProductsByPageNumber(
        pageNumber: Int,
        pageSize: Int
    ): Flow<Resource<List<ProductPageDto>>>

    fun getProductsByCategoryAndPageNumber(
        categoryId: Int,
        pageNumber: Int,
        pageSize: Int
    ): Flow<Resource<Products>>
}