package eif.viko.lt.faculty.app.domain.use_cases.shop

import eif.viko.lt.faculty.app.domain.models.Category

import eif.viko.lt.faculty.app.domain.repositories.ShopRepository
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: ShopRepository
) {
    operator fun invoke(): Flow<Resource<List<Category>>> {
        return repository.getAllCategories()
    }
}
