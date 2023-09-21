package eif.viko.lt.faculty.app.presentation.ui.shop.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.faculty.app.domain.repositories.AuthRepository
import eif.viko.lt.faculty.app.domain.repositories.ShopRepository
import eif.viko.lt.faculty.app.domain.use_cases.shop.GetProductsByCategoryUseCase
import eif.viko.lt.faculty.app.domain.util.AuthResult
import eif.viko.lt.faculty.app.domain.util.Resource
import eif.viko.lt.faculty.app.presentation.ui.auth.AuthUiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsByCategoryUseCase: GetProductsByCategoryUseCase,
    private val repository: ShopRepository
): ViewModel(){

    var state by mutableStateOf(ProductsState())
        private set


    init {
        getAllProducts()
    }

    fun onEvent(event: ProductUiEvents) {
        when(event) {
            is ProductUiEvents.CreateNewCategory-> {
                createNewCategory()
            }
            is ProductUiEvents.GetCategoryById-> {
                getCategoryById()
            }
            is ProductUiEvents.DeleteCategoryById-> {
                deleteCategoryById()
            }
            is ProductUiEvents.CreateNewProduct-> {

            }

        }
    }
    private fun createNewCategory() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.createCategory(state.name)
            state = state.copy(isLoading = false)
        }
    }

    private fun getCategoryById() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.getCategoryById(state.id)
            state = state.copy(isLoading = false)
        }
    }
    private fun deleteCategoryById() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)

            repository.deleteCategoryById(state.id)

            state = state.copy(isLoading = false)
        }
    }




    private fun getAllProducts() {

        productsByCategoryUseCase.invoke(8,1,10).onEach { result ->
            state = when (result) {
                is Resource.Success -> {
                    state.copy(
                        products = result.data,
                        // groups = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    state.copy(
                        products = result.data,
                        isLoading = true
                    )
                }
                is Resource.Error -> {
                    state.copy(
                        products = result.data,
                        isLoading = false,
                        error = "Error loading data"
                    )
                }
            }
        }.launchIn(viewModelScope)

    }
}