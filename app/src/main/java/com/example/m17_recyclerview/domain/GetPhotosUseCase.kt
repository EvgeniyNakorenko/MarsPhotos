package com.example.m17_recyclerview.domain

import android.util.Log
import com.example.m17_recyclerview.data.PhotosRepository
import com.example.m17_recyclerview.data.PhotosResponse
import retrofit2.Response
import javax.inject.Inject

class GetPhotosUseCase@Inject constructor(

    private val photosRepository: PhotosRepository
) {
    suspend fun execute(): PhotosResponse? {

        val req: Response<PhotosResponse> =
            photosRepository.searchIPI.getPhotos()
        var photoFromJson: PhotosResponse? = null
        if (req.isSuccessful) {
            photoFromJson = req.body()
            Log.d("@@@@@", "${photoFromJson?.photos}")
        }
        return photoFromJson
    }
}