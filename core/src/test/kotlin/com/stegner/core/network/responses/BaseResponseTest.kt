package com.stegner.core.network.responses

import com.google.firebase.auth.FirebaseUser
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit tests for [BaseResponse]
 */
class BaseResponseTest {

    @Test
    fun createBaseResponse_ShouldAddCorrectAttributes() {
        val success = true
        val data: FirebaseUser = mock()

        val baseResponse = BaseResponse(
            success = success,
            data = data
        )

        assertEquals(success, baseResponse.success)
        assertEquals(data, baseResponse.data)
    }
}
