package eif.viko.lt.faculty.app.presentation.ui.gems

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.faculty.app.domain.use_cases.GetGemsUseCase
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GemsViewModel @Inject constructor(
    private val getGemsUseCase: GetGemsUseCase
): ViewModel() {
    var state by mutableStateOf(GemsState())
        private set

    init {
        getGems()
    }
    private fun getGems() {

        getGemsUseCase.invoke().onEach { result ->
            state = when (result) {
                is Resource.Success -> {
                    state.copy(
                        gems = result.data ?: emptyList(),
                       // groups = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    state.copy(
                        gems = result.data ?: emptyList(),
                        isLoading = true
                    )
                }
                is Resource.Error -> {
                    state.copy(
                        gems = result.data ?: emptyList(),
                        isLoading = false,
                        error = "Error loading data"
                    )
                }
            }
        }.launchIn(viewModelScope)

    }
}