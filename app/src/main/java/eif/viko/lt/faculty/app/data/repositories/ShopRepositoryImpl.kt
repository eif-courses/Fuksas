package eif.viko.lt.faculty.app.data.repositories

import eif.viko.lt.faculty.app.data.remote.ShopApi
import eif.viko.lt.faculty.app.data.remote.mappers.ProductPageDto
import eif.viko.lt.faculty.app.data.remote.mappers.Products
import eif.viko.lt.faculty.app.domain.models.Category
import eif.viko.lt.faculty.app.domain.models.CategoryName
import eif.viko.lt.faculty.app.domain.repositories.ShopRepository
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val shopApi: ShopApi
) : ShopRepository {
    override fun getAllCategories(): Flow<Resource<List<Category>>> = flow {
        emit(Resource.Loading())
        val remoteData = shopApi.getAllCategories()
        emit(Resource.Loading(data = remoteData))
    }

    override suspend fun createCategory(name: String) {
        shopApi.createCategory(CategoryName(name))
    }

    override suspend fun getCategoryById(id: Int) {
        shopApi.getCategoryById(id)
    }

    override suspend fun deleteCategoryById(id: Int) {
        shopApi.deleteCategoryById(id)
    }

    override suspend fun createProduct() {
        //TODO("Not yet implemented")
    }

    override fun getProductsByPageNumber(
        pageNumber: Int,
        pageSize: Int
    ): Flow<Resource<List<ProductPageDto>>> = flow {
        // TODO("Not yet implemented")
    }

    override fun getProductsByCategoryAndPageNumber(
        categoryId: Int,
        pageNumber: Int,
        pageSize: Int
    ): Flow<Resource<Products>> = flow {

        emit(Resource.Loading())

        val remoteData = shopApi.getProductsByCategory(categoryId, pageNumber, pageSize)

        emit(Resource.Loading(data = remoteData))

    }
}



















