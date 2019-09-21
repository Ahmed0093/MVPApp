package com.example.mvpapp.imagemodule

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.mvpapp.network.DomainIntegration

/**
 * Created by Ahmed Abdullah on 9/21/2019.
 */
val imageLoader by lazy { ImageLoader() }

class ImageLoader {

    fun providesGlide(): RequestManager {
        return Glide.with(DomainIntegration.getContext())
    }

}