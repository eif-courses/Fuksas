package eif.viko.lt.faculty.app.data.repositories

import eif.viko.lt.faculty.app.data.remote.ShopApi
import eif.viko.lt.faculty.app.data.remote.mappers.ProductPageDto
import eif.viko.lt.faculty.app.domain.models.Category
import eif.viko.lt.faculty.app.domain.repositories.ShopRepository
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val shopApi: ShopApi
): ShopRepository {
    override fun getAllCategories(): Flow<Resource<List<Category>>> = flow {

        //    override fun myGems(): Flow<Resource<List<GemsDto>>> = flow {
//        val token = prefs.getString("jwt", null)
         emit(Resource.Loading())

        val remoteData = shopApi.getAllCategories()

        emit(Resource.Loading(data = remoteData))

//        val remoteGroupsData = api.getMyGems("Bearer $token")
//        emit(Resource.Loading(data = remoteGroupsData))
//    }

    }
    override suspend fun createCategory(name: String) {
        //TODO("Not yet implemented")
    }

    override suspend fun getCategoryById(id: Int) {
        //TODO("Not yet implemented")
    }

    override suspend fun deleteCategoryById(id: Int) {
        //TODO("Not yet implemented")
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
}