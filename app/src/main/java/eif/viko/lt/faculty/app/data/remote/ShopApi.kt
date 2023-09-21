package eif.viko.lt.faculty.app.data.remote

import eif.viko.lt.faculty.app.data.remote.mappers.Products
import eif.viko.lt.faculty.app.domain.models.Category
import eif.viko.lt.faculty.app.domain.models.CategoryName
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
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

    @POST("${PREFIX_URL}/category")
    suspend fun createCategory(@Body name: CategoryName)

    @DELETE("${PREFIX_URL}/category/{category_id}")
    suspend fun deleteCategoryById(@Path("category_id") id: Int): Response<Unit>

    @GET("${PREFIX_URL}/category/{category_id}")
    suspend fun getCategoryById(@Path("category_id") id: Int): Category





    companion object {
        const val PREFIX_URL = "api/v1/products"
    }

}