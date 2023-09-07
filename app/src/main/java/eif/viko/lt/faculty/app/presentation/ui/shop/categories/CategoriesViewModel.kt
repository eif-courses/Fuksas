package eif.viko.lt.faculty.app.presentation.ui.shop.categories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.faculty.app.domain.use_cases.shop.GetCategoriesUseCase
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
): ViewModel() {
    var state by mutableStateOf(CategoriesState())
        private set

    init {
        getAllCategories()
    }
    private fun getAllCategories() {

        getCategoriesUseCase.invoke().onEach { result ->
            state = when (result) {
                is Resource.Success -> {
                    state.copy(
                        categories = result.data ?: emptyList(),
                       // groups = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    state.copy(
                        categories = result.data ?: emptyList(),
                        isLoading = true
                    )
                }
                is Resource.Error -> {
                    state.copy(
                        categories = result.data ?: emptyList(),
                        isLoading = false,
                        error = "Error loading data"
                    )
                }
            }
        }.launchIn(viewModelScope)

    }
}