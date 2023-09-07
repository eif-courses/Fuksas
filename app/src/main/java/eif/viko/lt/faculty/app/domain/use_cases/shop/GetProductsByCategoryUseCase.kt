package eif.viko.lt.faculty.app.domain.use_cases.shop

import eif.viko.lt.faculty.app.data.remote.mappers.Products
import eif.viko.lt.faculty.app.domain.repositories.ShopRepository
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsByCategoryUseCase @Inject constructor(
    private val repository: ShopRepository
) {
    operator fun invoke(cat: Int, page: Int, size: Int): Flow<Resource<Products>> {
        return repository.getProductsByCategoryAndPageNumber(
            categoryId = cat,
            pageNumber = page,
            pageSize = size
        )
    }
}