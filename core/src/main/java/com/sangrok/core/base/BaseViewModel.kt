package com.sangrok.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State, SideEffect>(initialState: State) : ViewModel() {
    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)

    val state = _state.asStateFlow()

    protected val currentState: State
        get() = _state.value

    private val _sideEffect: MutableSharedFlow<SideEffect> = MutableSharedFlow()

    val sideEffect = _sideEffect.asSharedFlow()

    protected fun updateState(reducer: State.() -> State) {
        _state.value = currentState.reducer()
    }

    protected suspend fun postSideEffect(effect: () -> SideEffect) = viewModelScope.launch {
        _sideEffect.emit(effect())
    }
}