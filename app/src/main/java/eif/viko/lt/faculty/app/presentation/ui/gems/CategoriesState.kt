package eif.viko.lt.faculty.app.presentation.ui.gems

import eif.viko.lt.faculty.app.domain.models.Category

data class CategoriesState (
    val isLoading: Boolean = false,
    val error: String? = null,
    val categories: List<Category> = emptyList()
)