package com.hsmnzaydn.terminalcommandsjetpackcompose.base

data class CoreDataState<out T>(val status: Status, val data: T?,  val code:Int? ,val message: String?) {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?,code: Int): CoreDataState<T> {
            return CoreDataState(Status.SUCCESS, data, code,null)
        }

        fun <T> error(code:Int,message: String): CoreDataState<T> {
            return CoreDataState(Status.ERROR, null,code, message)
        }

        fun <T> loading(data: T? = null): CoreDataState<T> {
            return CoreDataState(Status.LOADING, data, null,null)
        }
    }
}