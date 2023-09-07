package eif.viko.lt.faculty.app.data.remote

import eif.viko.lt.faculty.app.data.remote.mappers.Products
import eif.viko.lt.faculty.app.domain.models.Category
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ShopApi {

    @GET("${PREFIX_URL}/categories")
    suspend fun getAllCategories(): List<Category>

    @GET("${PREFIX_URL}/{category_id}")
    suspend fun getProductsByCategory(
        @Path("category_id") id: Int,
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10
    ): Products


    companion object {
        const val PREFIX_URL = "api/v1/products"
    }

}