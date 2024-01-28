package com.example.m17_recyclerview.data

import com.example.m17_recyclerview.entity.SinglePhoto
import java.util.Date

data class SinglePhotoDto(
    override val earth_date: Date,
    override val sol: Int?,
    override val img_src: String?
): SinglePhoto
