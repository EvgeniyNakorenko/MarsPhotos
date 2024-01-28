package com.example.m17_recyclerview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m17_recyclerview.data.PhotosResponse
import com.example.m17_recyclerview.domain.GetPhotosUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getPhotosUseCase: GetPhotosUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow<PhotosResponse?>(null)
    val state = _state.asStateFlow()

    fun reloadPhotos() {
        var photosResponse: PhotosResponse?
        viewModelScope.launch(Dispatchers.IO) {
            photosResponse = getPhotosUseCase.execute()
            _state.value = photosResponse
        }
    }

}