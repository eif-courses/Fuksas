package eif.viko.lt.faculty.app.data.remote

import eif.viko.lt.faculty.app.data.remote.mappers.CategoriesDto
import eif.viko.lt.faculty.app.domain.models.Category
import retrofit2.http.GET

interface ShopApi {

    @GET("api/v1/products/category")
    suspend fun getAllCategories(): List<Category>
}