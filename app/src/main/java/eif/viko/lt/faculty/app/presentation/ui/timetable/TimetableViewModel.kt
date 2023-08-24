package eif.viko.lt.faculty.app.presentation.ui.timetable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.faculty.app.domain.use_cases.GetGroupsUseCase
import eif.viko.lt.faculty.app.domain.use_cases.TimetableUseCases
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TimetableViewModel @Inject constructor(
    private val getGroupsUseCase: GetGroupsUseCase
) : ViewModel() {


    var state by mutableStateOf(GroupState())
        private set

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UIEvent {
        data class ShowSnackbar(val message: String) : UIEvent()
    }

    init {
        getGroups()
    }

    private fun getGroups() {
        getGroupsUseCase().onEach { result ->
            state = when (result) {
                is Resource.Success -> {
                    state.copy(
                        groups = result.data ?: emptyList(),
                        isLoading = false
                    )
                }

                is Resource.Loading -> {
                    state.copy(
                        groups = result.data ?: emptyList(),
                        isLoading = true
                    )
                }

                is Resource.Error -> {
                    state.copy(
                        groups = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
            }
        }

    }
}