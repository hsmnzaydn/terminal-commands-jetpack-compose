package com.hsmnzaydn.terminalcommandsjetpackcompose.base

import javax.inject.Inject

open class CoreBaseServicesImp @Inject constructor() {

    open suspend fun <T> getResponse(request: suspend () -> CoreBaseResponse<T>): CoreBaseResponse<T> {
        return try {
            val result = request.invoke()
            return result


        } catch (e: Throwable) {
            var networkError = CoreNetworkError(e)
            var baseResponse = CoreBaseResponse<T>()
            baseResponse.setCode(networkError.code)
            baseResponse.setError(networkError.appErrorMessage)
            return baseResponse
        }
    }

}