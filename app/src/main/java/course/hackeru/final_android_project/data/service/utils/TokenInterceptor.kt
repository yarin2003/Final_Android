package course.hackeru.final_android_project.data.service.utils

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        //get the original request
        val original = chain.request()

        //add api_key query param to the url
        val url = original.url.newBuilder()
            .addQueryParameter("api_key", "53ccf1e48ec4b003aeb8129b0cf28d49")
            .build()

        //replace the url of the original request
        val request = original.newBuilder().url(url).build()
        Log.d("Request", "intercept:${request} ")
        //proceed with the chain
        return chain.proceed(request)
    }
}