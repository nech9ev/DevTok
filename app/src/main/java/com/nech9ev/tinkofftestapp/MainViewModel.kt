package com.nech9ev.tinkofftestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nech9ev.core.GifCategory
import com.nech9ev.domain.ShowGifUseCase
import com.nech9ev.domain.model.Gif
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gifUseCase: ShowGifUseCase
): ViewModel() {
    private var numberGif = 0;
    private var category = GifCategory.LATEST
    private var loadingJob: Job? = null

    private val _gif = MutableStateFlow<ActionState<Gif>>(ActionState.Loading())
    val gif : StateFlow<ActionState<Gif>> get() = _gif

    init {
        getNextGif()
    }

    fun getNextGif() {
        loadingJob?.cancel()

        loadingJob = viewModelScope.launch(Dispatchers.IO) {
            increaseNumGif()
            _gif.value = ActionState.Loading()
            try{
                _gif.value = ActionState.Success(gifUseCase.getNext(category))
            }catch (e: Exception){
                _gif.value = ActionState.Error(message = e.message?: "Unknown exception")
            }
        }
    }

    fun getNumLoadedGif() = numberGif

    fun increaseNumGif() = numberGif++

    fun changeCategory(category: GifCategory){
        this.category = category
        numberGif = 0;
        getNextGif()
    }

}
