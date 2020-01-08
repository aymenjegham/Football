package com.angelstudio.football.Network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.angelstudio.football.Model.Competitions
import com.angelstudio.football.NoConnectivityException
import retrofit2.Response
import timber.log.Timber


class CompetitionsDataSourceImpl(
    private val footballApiService: FootballApiService
) : CompetitionsDataSource {
    private val _downloadedCompetitions = MutableLiveData<Competitions>()
    override val downloadedCompetitions: LiveData<Competitions>
        get() = _downloadedCompetitions



    override suspend fun fetchCompetitions(plan: String) {
    /*  try {
            val fetchCompetitions = footballApiService
                .getcompetitions(plan)
                .await()
            _downloadedCompetitions.postValue(fetchCompetitions)

        }
        catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection.", e)

        }*/
    }

    override suspend fun fetchSet(plan: String)
            = getResult { footballApiService.getSet(plan) }

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null)
                    Log.v("checkingresponseget",body.toString())

              //  return Result.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            Log.v("checkingresponseget","eroooooooor"+" "+e.toString())

            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        Timber.e(message)
        return Result.error("Network call has failed for a following reason: $message")
    }


}