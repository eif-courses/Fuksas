package eif.viko.lt.faculty.app.presentation.ui.shop.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.faculty.app.domain.use_cases.shop.GetProductsByCategoryUseCase
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsByCategoryUseCase: GetProductsByCategoryUseCase
): ViewModel(){

    var state by mutableStateOf(ProductsState())
        private set

    init {
        getAllProducts()
    }
    private fun getAllProducts() {

        productsByCategoryUseCase.invoke(1,1,10).onEach { result ->
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