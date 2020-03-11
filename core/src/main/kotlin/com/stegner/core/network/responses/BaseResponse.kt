package com.stegner.core.network.responses

/**
 * Generic response wrapper for requests.
 *
 * Later this can be used to wrap exceptions if needed
 *
 * @param success Result of the action
 * @param data Data of the request. Generic for any use passed in
 */
data class BaseResponse<T>(val success: Boolean, val data: T)
