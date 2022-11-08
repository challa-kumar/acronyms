package com.example.acronyms.network

import com.example.acronyms.data.Meaning
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://www.nactem.ac.uk/software/acromine/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MeaningsApiService {
    @GET("dictionary.py")
    suspend fun getMeaningProperties(@Query("sf") type: String): List<MeaningsProperty>
}

object MeaningsApi {
    val retrofitService: MeaningsApiService by lazy { retrofit.create(MeaningsApiService::class.java) }

    suspend fun getMeanings(shortForm: String): List<Meaning> {
        val meaningProperties = retrofitService.getMeaningProperties(type = shortForm)
        return if (meaningProperties.isNotEmpty()) {
            meaningProperties[0].longForms
        } else emptyList()
    }
}