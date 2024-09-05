package com.example.kmmnetworkcall

/**
 * Created by Himanshu Verma on 28/06/24.
 **/
class NetworkCall {
    suspend fun getData(): String {
        val data = RestCall.fetchData()
        return "Data from API $data"
    }
}